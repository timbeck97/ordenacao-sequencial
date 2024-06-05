package org.example.order.processing;

import org.example.order.Ordenation;

import java.io.*;
import java.util.Date;
import java.util.Random;

public class Data {
    private int size;
    private Ordenation order;

    public Data(int size, Ordenation order) {
        this.size = size;
        this.order = order;
    }

    public void orderArray(){
        for (int j=0;j<4;j++){
            Date now = new Date();
            for (int i = 1; i < size; i++) {
                int[] array = generateRandomArray(i);
                order.order(array);
            }
            Date finalDate = new Date();
            long totalTime = finalDate.getTime() - now.getTime();
            writeTime(totalTime);

            System.out.println("FINISHED - "+order.getName()+" "+totalTime+"ms");
        }
    }
    public synchronized void writeTime(long time){
        try (FileWriter fw = new FileWriter("tempos.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
             out.println(this.order.getName()+";"+time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] generateRandomArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(40000);
        }
        return array;
    }
    public void printName(){
        System.out.println(this.order.getName());
    }
}

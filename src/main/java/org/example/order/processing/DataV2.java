package org.example.order.processing;

import org.example.order.Ordenation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;


public class DataV2 {
    private int[] array;
    private Ordenation order;
    public DataV2(int[] array, Ordenation order) {
        this.array = array;
        this.order = order;
    }

    public void orderArray(){
        //System.out.println("size arrauy: "+array.length);
        order.order(array);

    }
//    public synchronized void writeTime(long time){
//        try (FileWriter fw = new FileWriter("tempos.txt", true);
//             BufferedWriter bw = new BufferedWriter(fw);
//             PrintWriter out = new PrintWriter(bw)) {
//            out.println(this.order.getName()+"-"+time);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int[] generateRandomArray(int size){
//        Random random = new Random();
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            array[i] = random.nextInt(40000);
//        }
//        return array;
//    }
//    private synchronized void finish(long time){
//        addTime(time);
//        addArrayOrdereds();
//        //System.out.println("Total de arrays ordenados: "+totalArrayOrdereds+" Tempo total: "+totalTime);
//        if(totalArrayOrdereds>=5000){
//            writeTime(totalTime);
//            totalArrayOrdereds=0;
//            totalTime=0;
//        }
//    }
//    private synchronized void addTime(long time){
//        this.totalTime+=time;
//    }
//    private synchronized void addArrayOrdereds(){
//        this.totalArrayOrdereds++;
//    }
}

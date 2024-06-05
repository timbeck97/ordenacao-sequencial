package org.example.order.processing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Total {
    private long total;
    private int totalArrayOrdereds;
    private int maxArrays;

    public Total(int maxArrays) {
        this.total = 0l;
        this.totalArrayOrdereds = 0;
        this.maxArrays = maxArrays;
    }
    public synchronized void finish(long time, String name){
        addTime(time);
        addArrayOrdereds();
        System.out.println("Total de arrays ordenados: "+totalArrayOrdereds+" Tempo total: "+total);
        if(totalArrayOrdereds>=maxArrays){
            writeTime(total, name);
            //System.out.println("writted: "+name+"-"+total);
            totalArrayOrdereds=0;
            total=0;
        }
    }
    public synchronized void writeTime(long time, String name){
        try (FileWriter fw = new FileWriter("tempos.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(name+"-"+time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public synchronized void addTime(long time){
        total+=time;
    }
    public synchronized void addArrayOrdereds(){
        totalArrayOrdereds++;
    }
}

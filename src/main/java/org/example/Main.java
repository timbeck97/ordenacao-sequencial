package org.example;


import org.example.order.Ordenation;
import org.example.order.imp.*;
import org.example.order.processing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int TOTAL_ARRAYS=40000;
        List<Ordenation> ordenations = new ArrayList<>();
        ordenations.add(new BucketSort());
        ordenations.add(new CountingSort());
        ordenations.add(new HeapSort());
        ordenations.add(new MergeSort());
        ordenations.add(new QuickSort());
        ordenations.add(new RadixSort());
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(Ordenation ordenation: ordenations){
            executor.submit(new Processing(new Data(TOTAL_ARRAYS, ordenation)));
            executor.submit(new Processing(new Data(TOTAL_ARRAYS, ordenation)));
            executor.submit(new Processing(new Data(TOTAL_ARRAYS, ordenation)));
            executor.submit(new Processing(new Data(TOTAL_ARRAYS, ordenation)));
            executor.submit(new Processing(new Data(TOTAL_ARRAYS, ordenation)));

        }
        executor.shutdown();




    }
   
}
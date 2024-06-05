package org.example;

import com.sun.scenario.effect.Merge;
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
        final int TOTAL_ARRAYS=30000;
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
    public static int[] generateRandomArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(40000);
        }
        return array;
    }
}
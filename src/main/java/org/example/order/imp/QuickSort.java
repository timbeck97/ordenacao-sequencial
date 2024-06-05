package org.example.order.imp;

import org.example.order.Ordenation;

import java.util.Date;

public class QuickSort implements Ordenation {

    @Override
    public void order(int[] array) {
        quickSortOrder(array, 0, array.length - 1);
    }

    @Override
    public String getName() {
        return "QuickSort";
    }

    public void quickSortOrder(int[] array, int low, int high) {
        if (low < high) {

            int pi = partition(array, low, high);


            quickSortOrder(array, low, pi - 1);
            quickSortOrder(array, pi + 1, high);
        }
    }

    // Método para realizar a partição do array
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (array[j] <= pivot) {
                i++;


                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }


        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }


    public void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }



}

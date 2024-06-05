package org.example.order.imp;

import org.example.order.Ordenation;

import java.util.Date;

public class  MergeSort implements Ordenation {


    public void order(int[] array) {
        mergeSortOrder(array, 0, array.length - 1);
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    public void mergeSortOrder(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSortOrder(array, left, middle);
            mergeSortOrder(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arrays temporários
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];


        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[middle + 1 + j];


        int i = 0, j = 0;
        int k = left;

        // Mescla os arrays temporários de volta ao array original
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de leftArray[], se houver
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de rightArray[], se houver
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

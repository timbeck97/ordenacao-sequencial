package org.example.order.imp;

import org.example.order.Ordenation;

import java.util.Date;

public class HeapSort  implements Ordenation {


    @Override
    public void order(int[] array) {
        heapSortOrder(array);
    }

    @Override
    public String getName() {
        return "HeapSort";
    }

    public void heapSortOrder(int[] array) {
        int n = array.length;

        // Constrói um heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrai elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chama heapify na heap reduzida
            heapify(array, i, 0);
        }
    }

    // Método para transformar um subarray em um heap
    private void heapify(int[] array, int n, int i) {
        int largest = i; // Inicializa o maior como a raiz
        int left = 2 * i + 1; // Filho à esquerda
        int right = 2 * i + 2; // Filho à direita

        // Se o filho à esquerda for maior que a raiz
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Se o filho à direita for maior que o maior até agora
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Se o maior não é a raiz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente heapifica a subárvore afetada
            heapify(array, n, largest);
        }
    }


}

package org.example.order.imp;

import org.example.order.Ordenation;

public class CountingSort implements Ordenation {


    @Override
    public void order(int[] array) {
        countingSortOrder(array);
    }

    @Override
    public String getName() {
        return "Counting Sort";
    }

    public void countingSortOrder(int[] array) {
        int n = array.length;

        // Encontra o maior valor no array
        int max = findMax(array);

        // Cria um array de contagem e inicializa com zero
        int[] count = new int[max + 1];

        // Conta a ocorrência de cada elemento no array original
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }

        // Modifica o array de contagem para que cada posição
        // contenha a posição final de cada elemento no array ordenado
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Cria um array de saída
        int[] output = new int[n];

        // Constrói o array de saída
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copia o array de saída para o array original
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Método para encontrar o maior valor no array
    private int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


}

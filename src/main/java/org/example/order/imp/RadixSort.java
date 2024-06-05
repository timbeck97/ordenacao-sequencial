package org.example.order.imp;

import org.example.order.Ordenation;

import java.util.Arrays;
import java.util.Date;

public class RadixSort  implements Ordenation {


    @Override
    public void order(int[] array) {
        radixSort(array);
    }

    @Override
    public String getName() {
        return "RadixSort";
    }

    public void radixSort(int[] array) {
        // Encontra o maior número no array para saber o número de dígitos
        int max = findMax(array);

        // Realiza o Counting Sort para cada dígito. Note que passamos o lugar (exp) de 1, 10, 100, etc.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
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

    // Método auxiliar para realizar o Counting Sort baseado em um dígito específico
    private void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Array de saída
        int[] count = new int[10]; // Contagem para os dígitos de 0 a 9

        // Inicializa o array de contagem com 0
        Arrays.fill(count, 0);

        // Conta o número de ocorrências de cada dígito
        for (int i = 0; i < n; i++) {
            int index = (array[i] / exp) % 10;
            count[index]++;
        }

        // Modifica o array de contagem para que cada posição
        // contenha a posição final de cada dígito no array ordenado
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída
        for (int i = n - 1; i >= 0; i--) {
            int index = (array[i] / exp) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }

        // Copia o array de saída para o array original
        System.arraycopy(output, 0, array, 0, n);
    }


}

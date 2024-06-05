package org.example.fibbonaci;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int maxN = 50;

        // Teste e comparação de tempos de execução
        for (int n = 0; n <= maxN; n++) {
            // Recursiva simples
            long start = System.currentTimeMillis();
            long resultRec = fibRecursive(n);
            long end = System.currentTimeMillis();
            long timeRec = end - start;

            // Memorização top-down
            start = System.currentTimeMillis();
            fibonacciMemoization(n, new int[n + 1]);
            end = System.currentTimeMillis();
            long timeMemo = end - start;

            // Iterativo (bottom-up)
            start = System.currentTimeMillis();
            long resultBottomUp = fibBottomUp(n);
            end = System.currentTimeMillis();
            long timeBottomUp = end - start;

            // Imprimir resultados
            System.out.printf("n=%d: Recursiva=%dms, Memorização=%dms, Bottom-Up=%dms%n", n, timeRec, timeMemo, timeBottomUp);
        }
    }
    public static long fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    public static long fibMemoization(int n, HashMap<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 1) return n;
        long result = fibMemoization(n - 1, memo) + fibMemoization(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    public static int fibonacciMemoization(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacciMemoization(n-1, memo) + fibonacciMemoization(n-2, memo);
        return memo[n];
    }
    public static long fibBottomUp(int n) {
        if (n <= 1) return n;
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}

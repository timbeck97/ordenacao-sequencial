package org.example.order.imp;

import org.example.order.Ordenation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort implements Ordenation {




    @Override
    public void order(int[] array) {
        bucketSortOrder(array, 100);
    }

    @Override
    public String getName() {
        return "BucketSort";
    }

    public void bucketSortOrder(int[] array, int bucketCount) {
        if (array.length <= 1) {
            return;
        }

        // Determine minimum and maximum values
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // Create buckets and distribute the elements
        int bucketRange = (maxValue - minValue + 1) / bucketCount;
        List<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i : array) {
            int bucketIndex = (i - minValue) / bucketRange;
            if (bucketIndex >= bucketCount) {
                bucketIndex = bucketCount - 1;
            }
            buckets[bucketIndex].add(i);
        }

        // Sort each bucket and concatenate results
        int currentIndex = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                array[currentIndex++] = value;
            }
        }
    }



}

package org.example;

public class SelectionSort implements SortingAlgorithm{

    @Override
    public int[] sorty(int[] arr) {
        int[] a = arr.clone();

        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }
}

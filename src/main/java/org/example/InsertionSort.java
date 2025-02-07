package org.example;

public class InsertionSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] arr) {
        int[] a = arr.clone();

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;

            while (j >= 0 && a[j] > arr[i]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = arr[i];
        }
        return a;
    }
}

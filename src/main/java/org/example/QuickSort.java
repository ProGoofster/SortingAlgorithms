package org.example;

public class QuickSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] arr) {
        int[] a = arr.clone();
        quicksort(a, 0, arr.length - 1);
        return a;
    }

    private void quicksort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;

        int high = partition(arr, startIndex, endIndex);

        quicksort(arr, startIndex, high);
        quicksort(arr, high + 1, endIndex);
    }

    private int partition(int[] arr, int start, int end) {
        int midpoint = start + (end - start) / 2;
        int pivot = arr[midpoint];


        boolean done = false;
        while (!done) {
            while (arr[start] < pivot) start++;

            while (pivot < arr[end]) end--;

            if (start >= end) done = true;
            else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        return end;
    }
}

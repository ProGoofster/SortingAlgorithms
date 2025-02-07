package org.example;

public class MergeSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] arr) {
        int[] a = arr.clone();
        mergeSort(a,0, a.length - 1);
        return a;
    }

    private static void mergeSort(int[] numbers, int i, int k) {
        int j;

        if (i < k) {
            j = (i + k) / 2;  // Find the midpoint in the partition

            // Recursively sort left and right partitions
            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);

            // Merge left and right partition in sorted order
            merge(numbers, i, j, k);
        }
    }

    private static void merge(int[] numbers, int i, int j, int k) {
        int mergedSize = k - i + 1;                // Size of merged partition
        int[] mergedNumbers = new int[mergedSize]; // Dynamically allocates temporary
        // array for merged numbers
        int mergePos = 0;                          // Position to insert merged number
        int leftPos = i;                           // Initialize left partition position
        int rightPos = j + 1;                      // Initialize right partition position

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= j && rightPos <= k) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        // Copy merged numbers back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }
}

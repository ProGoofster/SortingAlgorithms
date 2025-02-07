package org.example;

public class ShellSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] arr) {
        int[] a = arr.clone();
        //Shell sort tends to perform well when choosing gap values in descending order
        //Shell sort will correctly sort arrays using any positive integer gap values in any order

        // this is how I chose to generate the gap values based on what the book says
        // the book recommends powers of two, but generating those for an arbitrary length
        // would just complicate things more than need be
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int j = i;

                while (j >= gap && a[j - gap] > arr[i]) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = arr[i];
            }
        }

        return a;
    }
}

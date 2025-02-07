package org.example;

import java.util.Random;
import java.util.Timer;

public class Tester {
    private final SortingAlgorithm sa;
    public Tester(SortingAlgorithm sa){
        this.sa = sa;
    }

    // Should create an array of integers of the given size. Fill it with random
    // numbers and run the sorting algorithm’s sorty method. It should record and return the time it takes
    // to sort the array.
    public double singleTest(int size){
        int[] arr = new int[size];
//        Random ran = new Random();
//        for(int i = 0; i < size; i++){
//            arr[i] = ran.nextInt();
//        }

        generateKSorted(arr, 10);

        double startTime = System.nanoTime();
        sa.sorty(arr);
        double endTime = System.nanoTime();

        System.out.println(sa.getClass().getSimpleName()+ " sorting finished with " + size+ " size");
        return (endTime - startTime);
    }

    // Should run the singleTest method as many times as the number of
    // iterations provided and print to the console the
    // average time the algorithm takes to sort an array of
    // the given size.
    public double test(int iterations, int size){
        double totalTime = 0;
        for(int i = 0; i < iterations; i++){
            totalTime += singleTest(size);
        }

        System.out.println(sa.getClass().getSimpleName()+ " sorting finished with " + iterations + " iterations and " + size+ " size");
        return (totalTime/iterations)/1000000;
    }

    //We say that an array A is k-sorted if it has the property that for every
    //element i in array A, i’s position in array A is at most k away from i’s position in a sorted array of the same
    //data. For example, the array: [1, 4, 2, 3, 5, 7, 6, 8] is 2-sorted because every element is within 2 positions
    //of its “correct” position in a sorted array. Any array that is k-sorted is also j-sorted for all j > k.
    //In this part of the assignment, you will study the question of whether it is faster to sort k-sorted data than
    //fully random data. You will need to write a method generateKSorted(my_array) that fills the array that is
    //passed as an argument with 10-sorted data (each element is within 10 positions of its correct position in the
    //array).
    //Repeat the performance experiments from problem 5, this time with 10-sorted data instead of random data.

    public void generateKSorted(int[] arr, int k) {
        int n = arr.length;

        // Fill array with sorted values
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Random rand = new Random();

        // Shuffle elements within k positions
        for (int i = 0; i < n; i++) {
            int swapIndex;
            do {
                swapIndex = i + rand.nextInt(2 * k + 1) - k; // Choose a position within k range
            } while (swapIndex < 0 || swapIndex >= n);

            int temp = arr[i];
            arr[i] = arr[swapIndex];
            arr[swapIndex] = temp;
        }
    }

}
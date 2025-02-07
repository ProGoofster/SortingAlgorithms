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
        Random ran = new Random();
        for(int i = 0; i < size; i++){
            arr[i] = ran.nextInt();
        }
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

}
package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Performance{
    // A main function that runs the Tester.test() method with 20 iterations for each algorithm
    // for each of the following array sizes: 100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000
    // and produces a .txt file report with
    public static void main(String[] args){
        // Create output directory if it doesn't exist
        File outputDir = new File("output");
        if (!outputDir.exists()) outputDir.mkdir();

        SortingAlgorithm[] saList = {
                new MergeSort(),
                new QuickSort(),
                new ShellSort(),
                new SelectionSort(),
                new InsertionSort(),
                new BubbleSort(),
        };

        int[] arraySizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};




        try {
            FileWriter myWriter = new FileWriter(new File(outputDir,  "output.txt"));
            for(SortingAlgorithm sa : saList){
                Tester tester = new Tester(sa);
                myWriter.write("Sorting Algorithm - " + sa.getClass().getSimpleName()+"\n");
                for(int arraySize : arraySizes){
                    myWriter.write("Sorted "+arraySize+" elements in "+tester.test(20, arraySize)+" ms (avg)\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }
}

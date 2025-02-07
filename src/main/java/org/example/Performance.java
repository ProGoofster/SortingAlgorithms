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
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort(),
        };

        int[] arraySizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        for(SortingAlgorithm sa : saList){


            try {
                FileWriter myWriter = new FileWriter(new File(outputDir,  "output.txt"));
                myWriter.write();
                myWriter.close();
                System.out.println("Successfully wrote to " +sa.getClass().getSimpleName() + ".txt");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }

        }
    }
}

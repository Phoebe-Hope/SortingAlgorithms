package SortingAlgorithmTests;

import SortingAlgorithms.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;


public class TimeSortingAlgorithms {

    private static int[] readDataFromFile(String filename) {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + filename);
            System.exit(1);
        }

        int[] data = new int[numbers.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = numbers.get(i);
        }
        return data;
    }

    public static long timeSort(String filename, SortingAlgorithm sorter) {
        int[] originalData = readDataFromFile(filename);
        int[] dataToSort = Arrays.copyOf(originalData, originalData.length);

        long startTime = System.nanoTime();
        sorter.sort(dataToSort);
        long endTime = System.nanoTime();

        return (endTime - startTime);
    }

    public static void main(String[] args) {

        String[] testFiles = { "int10.txt", "int20k.txt", "int50.txt", "int100.txt", "int500k.txt", "int1000.txt", "intBig.txt", "bad.txt", "dutch.txt"};


        for (String filename : testFiles) {

            long totalInsertion = 0;
            long totalSelection = 0;
            long totalMerge = 0;
            long totalMergeBottomUp = 0;
            long totalMergeHybrid = 0;
            long totalQuick = 0;
            long totalQuickHybrid = 0;
            long totalQuickDutch = 0;
            long totalQuickMedian = 0;
            long totalShell = 0;

            System.out.println("Sorting times for: " + filename);

            for (int i = 0; i < 10; i++) {
                totalInsertion += timeSort(filename, new InsertionSort());
                totalSelection += timeSort(filename, new SelectionSort());
                totalMerge +=  timeSort(filename, new MergeSort());
                totalMergeBottomUp += timeSort(filename, new MergeSortBottomUp());
                totalMergeHybrid += timeSort(filename,  new MergeSortHybrid());
                totalQuick  += timeSort(filename, new QuickSort());
                totalQuickHybrid += timeSort(filename, new QuickSortHybrid());
                totalQuickDutch +=  timeSort(filename, new QuickSortDutch());
                totalQuickMedian += timeSort(filename, new QuickSortMedian());
                totalShell += timeSort(filename, new ShellSort());
            }

            System.out.println("Insertion sort average: " + (totalInsertion/ 1000000.0) + " milliseconds");
            System.out.println("Selection sort average: " + (totalSelection / 1000000.0) + " milliseconds");
            System.out.println("Merge sort average: " + (totalMerge / 1000000.0) + " milliseconds");
            System.out.println("Merge sort bottom up average: " + (totalMergeBottomUp / 1000000.0) + " milliseconds");
            System.out.println("Hybrid Merge sort average: " + (totalMergeHybrid / 1000000.0) + " milliseconds");
            System.out.println("Quick sort average: " + (totalQuick / 1000000.0) + " milliseconds");
            System.out.println("Hybrid Quick sort average: " + (totalQuickHybrid / 1000000.0) + " milliseconds");
            System.out.println("Quick Dutch sort average: " + (totalQuickDutch / 1000000.0) + " milliseconds");
            System.out.println("Quick median sort average: " + (totalQuickMedian / 1000000.0) + " milliseconds");
            System.out.println("Shell sort average: " + (totalShell / 1000000.0) + " milliseconds");

            System.out.println("----------------------------------------------------------------------------------------");

        }
    }

}
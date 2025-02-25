package SortingAlgorithmTests;

import SortingAlgorithms.*;

import java.util.Arrays;

public class TestSortingAlgorithms {

    public static boolean isSorted(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testArr = {3, 5, 1, 4, 9, 2};

        SortingAlgorithm[] algorithms = {
                new InsertionSort(),
                new MergeSort(),
                new MinHeap(),
                new SelectionSort(),
                new QuickSort(),
                new ShellSort(),
                new QuickSortMedian(),
                new QuickSortHybrid(),
                new QuickSortDutch(),
                new MergeSortHybrid(),
                new MergeSortBottomUp(),
        };

        String[] names = {
                "Insertion Sort",
                "Merge Sort",
                "Min Heap Sort",
                "Selection Sort",
                "Quick Sort",
                "Shell Sort",
                "Quick Sort Median",
                "Quick Sort Hybrid",
                "Quick Sort Dutch",
                "MergeSort Hybrid",
                "MergeSort BottomUp",
        };

        for (int i = 0; i < algorithms.length; i++) {

            int[] arrCopy = Arrays.copyOf(testArr, testArr.length);

            algorithms[i].sort(arrCopy);

            boolean sorted = isSorted(arrCopy);
            System.out.println(names[i] + " sorted correctly: " + sorted);
            System.out.println("Output: " + Arrays.toString(arrCopy));
        }


    }
}

package SortingAlgorithms;

import java.util.PriorityQueue;

public class MinHeap extends SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int value : arr) {
            minHeap.add(value);
        }

        int i=0;
        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll();
        }
    }
}

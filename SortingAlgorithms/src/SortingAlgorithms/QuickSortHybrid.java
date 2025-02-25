package SortingAlgorithms;

public class QuickSortHybrid extends SortingAlgorithm {

    private static final int CUTOFF = 10;

    @Override
    public void sort(int[] arr) {
        quickSortHybrid(arr, 0, arr.length - 1);
    }

    private void quickSortHybrid(int[] arr, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(arr, lo, hi);
            return;
        }

        int pivot = partition(arr, lo, hi);
        quickSortHybrid(arr, lo, pivot - 1 );
        quickSortHybrid(arr,  pivot + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo+1;
        int j = hi;

        while (true) {
            while (i <= hi && arr[i] < pivot) {
                i++;
            }
            while (j >= lo + 1 && arr[j] >  pivot)
                j--;
            if (i>= j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, lo, j);
        return j;
    }

    private void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

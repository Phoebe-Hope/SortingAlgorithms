package SortingAlgorithms;

public class MergeSortHybrid extends SortingAlgorithm {

    private static final int CUTOFF = 10;

    @Override
    public void sort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSortHybrid(arr, aux, 0, arr.length - 1);
    }

    private void mergeSortHybrid(int[] arr, int[] aux, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(arr, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSortHybrid(arr, aux, lo, mid);
        mergeSortHybrid(arr, aux, mid + 1, hi);

        if (arr[mid] <= arr[mid+1]) return;
        merge(arr, aux, lo, mid, hi);
    }

    private void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (aux[j] < aux[i]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    private void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

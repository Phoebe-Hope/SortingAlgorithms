package SortingAlgorithms;

public class QuickSortMedian extends SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        quickSortMedian(arr, 0, arr.length - 1);
    }

    private void quickSortMedian(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int pivotIndex = partitionMedian(arr, lo, hi);
        quickSortMedian(arr, lo, pivotIndex - 1);
        quickSortMedian(arr, pivotIndex + 1, hi);
    }

    private int partitionMedian(int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        if (arr[mid] < arr[lo])
            swap(arr, lo, mid);
        if (arr[hi] < arr[lo])
            swap(arr, lo, hi);
        if (arr[hi] < arr[mid])
            swap(arr, mid, hi);

        swap(arr, lo, mid);
        int pivot = arr[lo];
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= hi && arr[i] < pivot )
                i++;
            while (j >= lo + 1 && arr[j] > pivot)
                j--;
            if (i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, lo, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}


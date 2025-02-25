package SortingAlgorithms;

public class QuickSortDutch extends SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        quickSortDutch(arr, 0, arr.length - 1);
    }

    private void quickSortDutch(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = arr[lo];
        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i] > pivot ) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        quickSortDutch(arr, lo, lt - 1);
        quickSortDutch(arr, gt + 1, hi);
    }

    private void swap(int[ ]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

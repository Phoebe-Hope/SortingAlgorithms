package SortingAlgorithms;

public class MergeSortBottomUp extends SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        int[] aux = new int[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                int mid = lo + sz - 1;
                int hi = Math.min(lo + sz + sz - 1, n - 1);
                merge(arr, aux, lo, mid, hi);
            }
        }
    }

    private void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }
}

package SortingAlgorithms;

public class ShellSort extends SortingAlgorithm {

    @Override
    public void sort(int a[]) {
        int n = a.length;
        int h = 1;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                int temp = a[i];
                int j = i;
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }
    }
}

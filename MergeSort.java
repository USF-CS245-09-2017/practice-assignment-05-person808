import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {

    private void merge(int[] a, int[] left, int[] right) {
        int aIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                a[aIndex++] = left[leftIndex++];
            } else {
                a[aIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            a[aIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            a[aIndex++] = right[rightIndex++];
        }
    }

    private int[] getLeft(int[] a) {
        return Arrays.copyOfRange(a, 0, a.length / 2);
    }

    private int[] getRight(int[] a) {
        return Arrays.copyOfRange(a, a.length / 2, a.length);
    }

    @Override
    public void sort(int[] a) {
        if (a.length > 1) {
            int[] left = getLeft(a);
            int[] right = getRight(a);
            sort(left);
            sort(right);
            merge(a, left, right);
        }
    }
}

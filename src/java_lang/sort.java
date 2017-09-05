package java_lang;

/**
 * Created by naco_siren on 8/23/17.
 */
public class sort {
    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 4, 2, 8, 5 ,7};
        quickSort(arr1);

        int[] arr2 = new int[]{5, 2, 4, 1, 3, 6, 0};
        quickSort(arr2);

        return;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        int mid = partition(arr, left, right);
        if (mid - 1 > left) quickSort(arr, left, mid - 1);
        if (mid + 1 < right) quickSort(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;

        while (true) {
            while (i < hi && arr[++i] < arr[lo]);
            while (j > lo && arr[--j] > arr[lo]);

            if (i >= j) break;

            exch(arr, i, j);
        }

        exch(arr, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

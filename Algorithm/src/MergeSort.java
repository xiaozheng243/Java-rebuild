/**
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arrs = {1, 5, 3, 6}; // 12, 23, 34, 45, 56, 67,
//        mergeSort(arrs, 0, arrs.length);
        int[] temp = new int[arrs.length];
        sort(arrs, 0, arrs.length - 1, temp);
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            mergeSort(arr, left, mid, right, temp);
        }
    }

    private static void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}


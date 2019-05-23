public class QuickSort {
    public static void main(String[] args) {

        int[] arrs = {12, 23, 34, 45, 56, 67, 1, 5, 3, 6};
        quickSort(arrs, 0, arrs.length - 1);
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }

    private static void quickSort(int[] arrs, int start, int end) {
        if (start < end) {
            int i = start, j = end;
            int temp;
            int target = arrs[start];
            do {
                while (arrs[i] < target && i < end) {
                    i++;
                }
                while (arrs[j] > target && j > start) {
                    j--;
                }
                if (i <= j) {
                    temp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (j > start) {
                quickSort(arrs, start, j);
            }
            if (end > i) {
                quickSort(arrs, i, end);
            }

        }
    }
}



public class BubbleSort {
    public static void main(String[] args) {
        int[] arrs = {67, 1, 89, 34, 23, 54, 15, 10};
        bubbleSort(arrs);
        for (int a : arrs) {
            System.out.println(a);
        }
    }

    private static void bubbleSort(int[] arrs) {
        int temp;
        for (int i = 1; i < arrs.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arrs[j] > arrs[j + 1]) {
                    temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }
}



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
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }
}

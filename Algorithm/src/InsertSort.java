
public class InsertSort {
    public static void main(String[] args) {
        int[] arrs = {70, 32, 5, 12, 93, 62, 21};
        insertSort(arrs);
        for (int a : arrs) {
            System.out.println(a);
        }
    }

    private static void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            int index = i;
            int temp = arrs[i];
            while (index > 0 && temp < arrs[index - 1]) {
                arrs[index] = arrs[index - 1];
                index--;
            }
            arrs[index] = temp;
        }
    }
}
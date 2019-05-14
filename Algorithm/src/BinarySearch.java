public class BinarySearch {
    public static void main(String[] args) {
        int[] intArr = {1, 3, 5, 7, 9, 11, 34, 45, 56};
        System.out.println(binarySearch(5, intArr));
        System.out.println(binarySearch(0, intArr.length, 5, intArr));
    }

    private static int binarySearch(int target, int[] arrs) {
        int len = arrs.length;
        int mid;
        int begin = 0;
        while (begin < len) {
            mid = (begin + len) / 2;
            if (target == arrs[mid]) {
                return mid + 1;
            } else if (arrs[mid] < target) {
                begin = mid + 1;
            } else if (arrs[mid] > target) {
                len = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int begin, int end, int target, int[] arrs) {
        int mid = (begin + end) / 2;
        if (arrs[mid] == target) {
            return mid + 1;
        } else if (arrs[mid] < target) {
            return binarySearch(mid + 1, end, target, arrs);
        } else if (arrs[mid] > target) {
            return binarySearch(begin, mid - 1, target, arrs);
        }
        return -1;
    }
}

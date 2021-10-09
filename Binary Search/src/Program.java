public class Program {

    public static void main(String[] args) {
        int[] array = {-22, -15, 1, 7, 20, 35, 55};
        // The elements in the array must be sorted.

        System.out.println(iterativeBinarySearch(array, -15));
        System.out.println(iterativeBinarySearch(array, 35));
        System.out.println(iterativeBinarySearch(array, 8888));
        System.out.println(iterativeBinarySearch(array, 1));

        System.out.println("**********************************");

        System.out.println(recursiveBinarySearch(array, -15));
        System.out.println(recursiveBinarySearch(array, 35));
        System.out.println(recursiveBinarySearch(array, 8888));
        System.out.println(recursiveBinarySearch(array, 1));

        // Iterative Binary Search is better than Recursive Binary Search.
    }

    public static int iterativeBinarySearch(int[] array, int target) {

        // O(logn) time | O(1) space
        // where n is the length of the input array.

        int start = 0;
        int end = array.length;

        while (start < end) {
            int midPoint = (start + end) / 2;
            int valueInMidPoint = array[midPoint];

            if (valueInMidPoint == target) {
                return midPoint;
            } else if (valueInMidPoint < target) {
                start = midPoint + 1;
            } else {
                end = midPoint;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] array,  int target) {

        // O(logn) time | O(logn) space
        // where n is the length of the input array.

        return recursiveBinarySearch(array, 0, array.length,  target);
    }

    public static int recursiveBinarySearch(int[] array, int start, int end, int target) {
        if (start >= end) {
            return -1;
        }

        int midPoint = (start + end) / 2;
        int valueInMidPoint = array[midPoint];

        if (valueInMidPoint == target) {
            return midPoint;
        } else if (valueInMidPoint < target) {
            return recursiveBinarySearch(array, midPoint + 1, end, target);
        } else {
            return recursiveBinarySearch(array, start, midPoint, target);
        }
    }
}

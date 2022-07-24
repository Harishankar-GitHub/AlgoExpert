import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort_method_1(new int[]{8, 5, 2, 9, 5, 6, 3})));
        System.out.println(Arrays.toString(mergeSort_method_2(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }

    public static int[] mergeSort_method_1(int[] array) {

        // Best: O(n(log(n)) time | O(n(log(n)) space
        // Average: O(n(log(n)) time | O(n(log(n)) space
        // Worst: O(n(log(n)) time | O(n(log(n)) space

        int length = array.length;
        // Base case
        if (length <= 1) return array;

        int mid = length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(array, mid, length);

        // Recursive relation
        return merge(mergeSort_method_1(leftHalf), mergeSort_method_1(rightHalf));
    }

    public static int[] mergeSort_method_2(int[] array) {

        // Best: O(n(log(n)) time | O(n(log(n)) space
        // Average: O(n(log(n)) time | O(n(log(n)) space
        // Worst: O(n(log(n)) time | O(n(log(n)) space

        int length = array.length;
        // Base case
        if (length <= 1) return array;

        int mid = length / 2;

        // Recursive relation
        int[] leftHalf = mergeSort_method_2(Arrays.copyOfRange(array, 0, mid));
        int[] rightHalf = mergeSort_method_2(Arrays.copyOfRange(array, mid, length));

        return merge(leftHalf, rightHalf);
    }

    private static int[] merge(int[] leftHalf, int[] rightHalf) {
        int leftHalfLength = leftHalf.length;
        int rightHalfLength = rightHalf.length;

        int[] sortedArray = new int[leftHalfLength + rightHalfLength];

        int sortedArrayIdx = 0;
        int leftIdx = 0;
        int rightIdx = 0;

        while (leftIdx < leftHalfLength && rightIdx < rightHalfLength) {
            if (leftHalf[leftIdx] < rightHalf[rightIdx]) {
                sortedArray[sortedArrayIdx++] = leftHalf[leftIdx++];
            } else {
                sortedArray[sortedArrayIdx++] = rightHalf[rightIdx++];
            }
        }

        while (leftIdx < leftHalfLength) {
            sortedArray[sortedArrayIdx++] = leftHalf[leftIdx++];
        }

        while (rightIdx < rightHalfLength) {
            sortedArray[sortedArrayIdx++] = rightHalf[rightIdx++];
        }

        return sortedArray;
    }
}

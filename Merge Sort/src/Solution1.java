import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {

        // Divide and Conquer Algorithm
        // Recursive Algorithm
        // 2 Phases : Splitting and Merging
        // Splitting phase leads to faster sorting during the merging phase
        // Splitting is logical. We don't create new arrays.

        // Splitting phase
        // Start with an unsorted array
        // Divide it into 2 arrays which are unsorted
        // 1st array is left array and 2nd array is right array
        // Split left and right into 2 arrays each
        // Keep splitting until all arrays have 1 element each

        // Merging phase
        // Merge every left right pair of sibling arrays into a sorted array
        // After the first merge, we will have a bunch of 2 element sorted arrays
        // Then merge those sorted arrays to end up with a bunch of 4-element sorted arrays
        // Repeat until we have a single sorted array

        // Splitting phase is in place (i.e., it doesn't use temporary arrays)
        // Merging phase is not in place (i.e., It does use temporary array(s))

        // Time Complexity is (nlogn) - base 2 : We are repeatedly dividing the array in half during the splitting phase.
        // Stable algorithm

        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        mergeSort_method_1(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        array = new int[]{8, 5, 2, 9, 5, 6, 3};
        mergeSort_method_2(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort_method_1(int[] array, int start, int end) {

        // O(n(log(n)) time | O(n) space

        // Base case
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        // Recursive relation
        // Left part
        mergeSort_method_1(array, start, mid);
        // Right part
        mergeSort_method_1(array, mid+1, end);

        merge_method_1(array, start, end);
    }

    public static void mergeSort_method_2(int[] array, int start, int end) {

        // O(n(log(n)) time | O(n) space

        // Base case
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        // Recursive relation
        // Left part
        mergeSort_method_2(array, start, mid);
        // Right part
        mergeSort_method_2(array, mid+1, end);

        merge_method_2(array, start, end);
    }

    private static void merge_method_1(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;

        int firstHalfLength = mid - start + 1;
        int secondHalfLength = end - mid;

        int[] leftHalf = new int[firstHalfLength];
        int[] rightHalf = new int[secondHalfLength];

        int mainArrayIdx = start;
        for (int i = 0; i < firstHalfLength; i++) {
            leftHalf[i] = array[mainArrayIdx++];
        }

        mainArrayIdx = mid+1;
        for (int i = 0; i < secondHalfLength; i++) {
            rightHalf[i] = array[mainArrayIdx++];
        }

        int leftIdx = 0;
        int rightIdx = 0;
        mainArrayIdx = start;

        while (leftIdx < firstHalfLength && rightIdx < secondHalfLength) {
            if (leftHalf[leftIdx] < rightHalf[rightIdx]) {
                array[mainArrayIdx++] = leftHalf[leftIdx++];
            } else {
                array[mainArrayIdx++] = rightHalf[rightIdx++];
            }
        }

        while (leftIdx < firstHalfLength) {
            array[mainArrayIdx++] = leftHalf[leftIdx++];
        }

        while (rightIdx < secondHalfLength) {
            array[mainArrayIdx++] = rightHalf[rightIdx++];
        }
    }

    private static void merge_method_2(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;

        int[] sortedArray = new int[end - start + 1];

        int sortedArrayIdx = 0;
        int leftIdx = start;
        int rightIdx = mid+1;

        while (leftIdx <= mid && rightIdx <= end) {
            if (array[leftIdx] < array[rightIdx]) {
                sortedArray[sortedArrayIdx++] = array[leftIdx++];
            } else {
                sortedArray[sortedArrayIdx++] = array[rightIdx++];
            }
        }

        while (leftIdx <= mid) {
            sortedArray[sortedArrayIdx++] = array[leftIdx++];
        }

        while (rightIdx <= end) {
            sortedArray[sortedArrayIdx++] = array[rightIdx++];
        }

        System.arraycopy(sortedArray, 0, array, start, sortedArray.length);
    }
}

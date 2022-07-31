import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }

    // Divide and Conquer Algorithm
    // Recursive Algorithm
    // Uses pivot element to partition the array into 2 parts
    // Elements < pivot to its left, elements > pivot to its right
    // pivot will then be in its correct sorted position

    // Time Complexity is (nlogn) - base 2 : We are repeatedly dividing the array in half during the splitting phase.
    // Unstable algorithm
    // In place algorithm

    public static int[] quickSort(int[] array) {

        // Best: O(n(log(n)) time | O(n) space
        // Average: O(n(log(n)) time | O(n) space
        // Worst: O(n^2) time | O(n) space

        quickSort(array, 0, array.length-1);
        return array;
    }

    private static void quickSort(int[] array, int start, int end) {
        // Base case
        if (start >= end) return;

        // Partition
        int pivotIndex = partition(array, start, end);

        // Recursive relation
        // Sort left half
        quickSort(array, start, pivotIndex -1);
        // Sort right half
        quickSort(array, pivotIndex +1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivotElement = array[start];
        int count = 0;

        for (int i = start+1; i <= end; i++) {
            if (array[i] <= pivotElement) count++;
        }

        // Place pivot element at right position
        int pivotElementIndex = start + count;
        swap(array, pivotElementIndex, start);

        // Move elements lesser than pivot element to its left and greater than pivot element to its right
        int i = start;
        int j = end;

        while (i < pivotElementIndex && j > pivotElementIndex) {
            while (array[i] <= pivotElement) i++;
            while (array[j] > pivotElement) j--;

            if (i < pivotElementIndex && j > pivotElementIndex) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        return pivotElementIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

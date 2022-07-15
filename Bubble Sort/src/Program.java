import java.util.Arrays;

public class Program {

    // Bubble Sort

    // The performance of this algorithm degrades quickly as the number
    // of elements required to sort increases.
    // Time Complexity : O(nsquare) - Quadratic
    // It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items
    // and 1,000,000 steps to sort 1000 items
    // Algorithm degrades quickly

    // Bubble Sort is a stable algorithm.
    // It is stable because, duplicate elements maintain the same order.
    // {1, 6, 4, 3, 6, 8} - In this array, element 6 in the position 1 and at the position 4 maintain same order after sorting.
    // After sorting, {1, 3, 4, 6, 6, 8} - In this array, the first occurrence of 6 was originally at position 1 before
    // sorting and the second occurrence of 6 was originally at position 4 before sorting.
    // The position of duplicates are maintained after sorting. Hence, Bubble sort is a stable algorithm.

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort_method1(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(bubbleSort_method2(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(bubbleSort_method3(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(bubbleSort_method4(new int[]{20, 35, -15, 7, 55, 1, -22})));
    }

    public static int[] bubbleSort_method1(int[] array) {

        // Best:          O(n) time | O(1) space - When given a sorted array.
        // Average:    O(n^2) time | O(1) space
        // Worst:       O(n^2) time | O(1) space

        for (int lastUnsortedIndex = array.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
        return array;
    }

    public static int[] bubbleSort_method2(int[] array) {

        // Best:          O(n) time | O(1) space - When given a sorted array.
        // Average:    O(n^2) time | O(1) space
        // Worst:       O(n^2) time | O(1) space

        // This method doesn't have counter.
        // Method 3 has counter, and so is more optimized.

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length -1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
        return array;
    }

    public static int[] bubbleSort_method3(int[] array) {

        // Best:          O(n) time | O(1) space - When given a sorted array.
        // Average:    O(n^2) time | O(1) space
        // Worst:       O(n^2) time | O(1) space

        // With counter, it adds more optimization by reducing the number of elements to check.
        // In 1st loop, the last element of the array is sorted and in 2nd loop, last 2 elements are sorted and so on.
        // By adding counter, from the 2nd loop, it eliminates the need to check the last elements (sorted elements).

        boolean isNotSorted = true;
        int counter = 0;

        while (isNotSorted) {
            isNotSorted = false;
            for (int i = 0; i < array.length -1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isNotSorted = true;
                }
            }
            counter++;
        }
        return array;
    }

    public static int[] bubbleSort_method4(int[] array) {

        // Best:          O(n) time | O(n) space - When given a sorted array.
        // Average:    O(n^2) time | O(n) space
        // Worst:       O(n^2) time | O(n) space

        return bubbleSort_recursion(array, array.length);
    }

    private static int[] bubbleSort_recursion(int[] array, int length) {
        // Base case
        if (length <= 1) return array;

        for (int i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) swap(array, i, i + 1);
        }

        // Recursive Relation
        return bubbleSort_recursion(array, length-1);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

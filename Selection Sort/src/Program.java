import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        // It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items
        // and 1,000,000 steps to sort 1000 items.
        // Doesn't require as much swapping as bubble sort.
        // Unstable algorithm.

        System.out.println(Arrays.toString(selectionSort_using_for_loop(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(selectionSort_using_for_loop_reverse(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(selectionSort_using_while_loop(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(selectionSort_using_while_loop_reverse(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(selectionSort_using_recursion(new int[]{20, 35, -15, 7, 55, 1, -22})));
    }

    public static int[] selectionSort_using_for_loop(int[] array) {

        // Best: O(n^2) time | O(1) space
        // Average: O(n^2) time | O(1) space
        // Worst: O(n^2) time | O(1) space

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }
             swap(array, lastUnsortedIndex, largestIndex);
        }
        return array;
    }

    public static int[] selectionSort_using_for_loop_reverse(int[] array) {

        // Best: O(n^2) time | O(1) space
        // Average: O(n^2) time | O(1) space
        // Worst: O(n^2) time | O(1) space

        for (int firstUnsortedIndex = 0; firstUnsortedIndex <= array.length - 1; firstUnsortedIndex++) {
            int smallestIndex = firstUnsortedIndex;
            for (int i = firstUnsortedIndex + 1; i < array.length; i++) {
                if (array[i] < array[smallestIndex]) {
                    smallestIndex = i;
                }
            }
            swap(array, firstUnsortedIndex, smallestIndex);
        }
        return array;
    }

    public static int[] selectionSort_using_while_loop(int[] array) {

        // Best: O(n^2) time | O(1) space
        // Average: O(n^2) time | O(1) space
        // Worst: O(n^2) time | O(1) space

        int lastUnsortedIndex = array.length - 1;
        while (lastUnsortedIndex > 0) {
            int largestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }
            swap(array, lastUnsortedIndex, largestIndex);
            lastUnsortedIndex -= 1;
        }
        return array;
    }

    public static int[] selectionSort_using_while_loop_reverse(int[] array) {

        // Best: O(n^2) time | O(1) space
        // Average: O(n^2) time | O(1) space
        // Worst: O(n^2) time | O(1) space

        int firstUnsortedIndex = 0;
        while (firstUnsortedIndex < array.length - 1) {
            int smallestIndex = firstUnsortedIndex;
            for (int i = firstUnsortedIndex + 1; i < array.length; i++) {
                if (array[i] < array[smallestIndex]) {
                    smallestIndex = i;
                }
            }
            swap(array, firstUnsortedIndex, smallestIndex);
            firstUnsortedIndex += 1;
        }
        return array;
    }

    public static int[] selectionSort_using_recursion(int[] array) {

        // Best: O(n^2) time | O(n) space
        // Average: O(n^2) time | O(n) space
        // Worst: O(n^2) time | O(n) space

        return selectionSort_using_recursion(array, array.length - 1);
    }

    private static int[] selectionSort_using_recursion(int[] array, int lastUnsortedIndex) {
        // Base case
        if (lastUnsortedIndex == 0) return array;

        int largestIndex = 0;

        for (int i = 1; i <= lastUnsortedIndex; i++) {
            if (array[i] > array[largestIndex]) largestIndex = i;
        }

        swap(array, largestIndex, lastUnsortedIndex);

        // Recursive Relation
        return selectionSort_using_recursion(array, lastUnsortedIndex - 1);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

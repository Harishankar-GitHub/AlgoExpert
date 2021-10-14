import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        // It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items
        // and 1,000,000 steps to sort 1000 items.
        // Stable algorithm.

        // Assuming 1st element in the array is sorted.

        int[] array1 = {8, 5, 2, 9, 5, 6, 3};
        int[] array2 = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(insertionSort_method1(array1)));
        System.out.println(Arrays.toString(insertionSort_method2(array2)));
    }

    public static int[] insertionSort_method1(int[] array) {

        // Best: O(n) time | O(1) space
        // Average: O(n^2) time | O(1) space
        // Worst: O(n^2) time | O(1) space

        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(j, j-1, array);
                j -= 1;
            }
        }
        return array;
    }

    public static int[] insertionSort_method2(int[] array) {

        // Best: O(n) time | O(1) space
        // Average: O(n^2) time | O(1) space
        // Worst: O(n^2) time | O(1) space

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++){
            int currentElement = array[firstUnsortedIndex];
            int j;
            for (j = firstUnsortedIndex; j > 0 && array[j-1] > currentElement; j--) {
                array[j] = array[j-1];
            }
            array[j] = currentElement;
        }
        return array;
    }

    private static void swap(int j, int i, int[] array) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
    }
}

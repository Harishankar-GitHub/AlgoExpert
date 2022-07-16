import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(Arrays.toString(threeNumberSort_solution_1(new int[]{1, 0, 0, -1, -1, 0, 1, 1}, new int[]{0, 1, -1})));
        System.out.println(Arrays.toString(threeNumberSort_solution_1(new int[]{-2, -3, -3, -3, -3, -3, -2, -2, -3}, new int[]{-2, -3, 0})));
        System.out.println(Arrays.toString(threeNumberSort_solution_1(new int[]{3, 2, 1, 1, 3, 1, 2, 3, 3}, new int[]{1, 2, 3})));

        System.out.println("Solution 2");
        System.out.println(Arrays.toString(threeNumberSort_solution_2(new int[]{1, 0, 0, -1, -1, 0, 1, 1}, new int[]{0, 1, -1})));
        System.out.println(Arrays.toString(threeNumberSort_solution_2(new int[]{-2, -3, -3, -3, -3, -3, -2, -2, -3}, new int[]{-2, -3, 0})));
        System.out.println(Arrays.toString(threeNumberSort_solution_2(new int[]{3, 2, 1, 1, 3, 1, 2, 3, 3}, new int[]{1, 2, 3})));

        System.out.println("Solution 3");
        System.out.println(Arrays.toString(threeNumberSort_solution_3(new int[]{1, 0, 0, -1, -1, 0, 1, 1}, new int[]{0, 1, -1})));
        System.out.println(Arrays.toString(threeNumberSort_solution_3(new int[]{-2, -3, -3, -3, -3, -3, -2, -2, -3}, new int[]{-2, -3, 0})));
        System.out.println(Arrays.toString(threeNumberSort_solution_3(new int[]{3, 2, 1, 1, 3, 1, 2, 3, 3}, new int[]{1, 2, 3})));
    }

    public static int[] threeNumberSort_solution_1(int[] array, int[] order) {

        // O(n) time | O(1) space

        int currentIndexToBeSorted = 0;
        for (int currentNumberInOrder : order) {
            for (int i = currentIndexToBeSorted +1; i < array.length; i++) {
                if (array[currentIndexToBeSorted] == currentNumberInOrder) {
                    currentIndexToBeSorted += 1;
                } else if (currentNumberInOrder == array[i]) {
                    swap(array, currentIndexToBeSorted, i);
                    currentIndexToBeSorted += 1;
                }
            }
        }

        return array;
    }

    public static int[] threeNumberSort_solution_2(int[] array, int[] order) {

        // O(n) time | O(1) space
        // Sorting 1st and 3rd number so that 2nd number gets sorted automatically.

        int firstNumberInOrder = order[0];
        int lastNumberInOrder = order[2];

        int length = array.length;

        int currentIndexToBeSorted = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == firstNumberInOrder) {
                swap(array, i, currentIndexToBeSorted);
                currentIndexToBeSorted += 1;
            }
        }

        currentIndexToBeSorted = array.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == lastNumberInOrder) {
                swap(array, i, currentIndexToBeSorted);
                currentIndexToBeSorted--;
            }
        }

        return array;
    }

    public static int[] threeNumberSort_solution_3(int[] array, int[] order) {

        // O(n) time | O(1) space

        int firstNumberInOrder = order[0];
        int secondNumberInOrder = order[1];

        // Keeping track of the indices where the values are stored.
        int firstNumberIndex = 0;
        int secondNumberIndex = 0;
        int thirdNumberIndex = array.length - 1;

        while (secondNumberIndex <= thirdNumberIndex) {
            int number = array[secondNumberIndex];

            if (number == firstNumberInOrder) {
                swap(array, firstNumberIndex, secondNumberIndex);
                firstNumberIndex++;
                secondNumberIndex++;
            } else if (number == secondNumberInOrder) {
                secondNumberIndex++;
            } else {
                swap(array, secondNumberIndex, thirdNumberIndex);
                thirdNumberIndex--;
            }
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

import java.util.Arrays;

class Program {

    public static void main(String[] args) {
//        int[] array1 = {1,2,3,5,6,8,9};
        int[] array1 = {-3,-2,-1,0,1,2};
        int[] result = sortedSquaredArray_my_solution(array1);
        printArray(result);

        System.out.println();

//        int[] array2 = {1,2,3,5,6,8,9};
        int[] array2 = {-3,-2,-1,0,1,2};
        result = sortedSquaredArray_method2(array2);
        printArray(result);

    }

    public static int[] sortedSquaredArray_my_solution(int[] array) {
        // O(nlogn) time because we are sorting before returning.
        // For this solution, O(1) space as we update the values in the same array.
        // O(n) space if we use separate array to return.

        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            array[i] = currentNum * currentNum;
        }

        Arrays.sort(array);
        return array;
    }

    public static int[] sortedSquaredArray_method2(int[] array) {
        // O(n) time | O(n) space

        int[] result = new int[array.length];
        int smallValueIdx = 0;
        int largeValueIdx = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            int smallValue = array[smallValueIdx];
            int largerValue = array[largeValueIdx];

            if (Math.abs(smallValue) > Math.abs(largerValue)) {
                result[i] = smallValue * smallValue;
                smallValueIdx++;
            } else {
                result[i] = largerValue * largerValue;
                largeValueIdx--;
            }
        }
        return result;
    }

    private static void printArray(int[] array) {
        for (int num : array)
            System.out.print(num + " ");
    }
}
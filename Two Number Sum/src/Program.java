import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Program {

    public static void main(String[] args) {
        int[] array = {3,5,-4,8,11,1,-1,6};
        int targetSum = 10;
//        int[] array = {-21, 301, 12, 4, 65, 56, 210, 356, 9, -47};
//        int targetSum = 164;

        printArray(twoNumberSum_using_Array(array,targetSum));
        printArray(twoNumberSum_using_HashSet(array,targetSum));
        printArray(twoNumberSum_using_SlidingWindow(array,targetSum));
    }

    public static int[] twoNumberSum_using_Array(int[] array, int targetSum) {
        // O(n^2) time | O(1) space

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSum_using_HashSet(int[] array, int targetSum) {
        // O(n) time | O(n) space

        Set<Integer> integerSet = new HashSet<>();

        for (int num : array) {
            int potentialMatch = targetSum - num;

            if (integerSet.contains(potentialMatch))
                return new int[] {potentialMatch, num};
            else
                integerSet.add(num);
        }
        return new int[0];
    }

    public static int[] twoNumberSum_using_SlidingWindow(int[] array, int targetSum) {
        // O(nLog(n)) time | O(1) space

        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int leftNumber = array[left];
            int rightNumber = array[right];
            int currentSum = leftNumber + rightNumber;

            if (currentSum == targetSum)
                return new int[] {leftNumber, rightNumber};
            else if (currentSum < targetSum) left += 1;
            else right -= 1;
        }
        return new int[0];
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();
    }
}

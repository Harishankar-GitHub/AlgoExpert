import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        System.out.println("First Duplicate Value: " + firstDuplicateValue_method_1(new int[]{2, 1, 5, 2, 3, 3, 4}));
        System.out.println("First Duplicate Value: " + firstDuplicateValue_method_2(new int[]{2, 1, 5, 2, 3, 3, 4}));
        System.out.println("First Duplicate Value: " + firstDuplicateValue_method_3(new int[]{2, 1, 5, 2, 3, 3, 4}));
        System.out.println("First Duplicate Value: " + firstDuplicateValue_method_4(new int[]{2, 1, 5, 2, 3, 3, 4}));
    }

    public static int firstDuplicateValue_method_1(int[] array) {

        // O(n) time | O(n) space

        Set<Integer> set = new HashSet<>();

        for(int num : array) {
            if (set.contains(num)) return num;
            else set.add(num);
        }

        return -1;
    }

    public static int firstDuplicateValue_method_2(int[] array) {

        // O(n) time | O(n) space

        int[] intArr = new int[array.length+1];
        // As per this question, array has integers between 1 and n both inclusive
        // where n is the length of the array.
        // If the integers in the array are random and doesn't meet the above condition,
        // then the array method cannot be used.

        for(int num : array) {
            if (intArr[num] == 1) return num;
            else intArr[num] = 1;
        }

        return -1;
    }

    public static int firstDuplicateValue_method_3(int[] array) {

        // O(n^2) time | O(1) space

        int minimumSecondIndex = array.length;

        for (int i = 0; i < array.length; i++) {
            int value = array[i];

            for (int j = i+1; j < array.length; j++) {
                int valueToCompare = array[j];

                if (value == valueToCompare) minimumSecondIndex = Math.min(minimumSecondIndex, j);
            }
        }

        if (minimumSecondIndex == array.length) return -1;

        return array[minimumSecondIndex];
    }

    public static int firstDuplicateValue_method_4(int[] array) {

        // O(n) time | O(1) space

        for (int num : array) {
            int absValue =Math.abs(num);
            if (array[absValue - 1] < 0) return absValue;
            array[absValue - 1] *= -1;
        }

        return -1;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Program {

    public static void main(String[] args) {
        List<Integer[]> threeNumberSum = threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);

        for (Integer[] array : threeNumberSum) {
            System.out.println(Arrays.toString(array));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        // O(n^2) time | O(n) space

        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int left = i+1;
            int right = array.length - 1;
            int currentNum = array[i];

            while (left < right) {
                int leftNum = array[left];
                int rightNum = array[right];
                int currentSum = currentNum + leftNum + rightNum;

                if (currentSum == targetSum) {
                    triplets.add(new Integer[]{currentNum, leftNum, rightNum});
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }
}

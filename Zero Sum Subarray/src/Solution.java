import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(zeroSumSubarray(new int[]{-5, -5, 2, 3, -2}));
    }

    // Note:
    // Array:                             -5,  -5,   2,  3, -2
    // Sum till current index:     -5  -10  -8  -5
    // When we come across 2 equal sums (-5 and -5 in this case), then the array has zero sum subarray.
    // How?
    // -5 below -5 is the sum of all elements till that index.
    // -5 below 3 is the sum of all elements till that index.
    // So the sum of elements from the index next to 1st -5 till second -5 must be 0 (-5+2+3 = 0).
    // If it is 0, then it is the zero sum subarray.

    public static boolean zeroSumSubarray(int[] nums) {

        // O(n) time | O(n) space

        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        // Adding 0 to the set because if we come across 0 in the nums array,
        // that is also a valid zero sum subarray.

        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (sums.contains(currentSum)) return true;
            else sums.add(currentSum);
        }
        return false;
    }
}

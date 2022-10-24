public class Solution {

    public static void main(String[] args) {
        System.out.println("Number of ways to make change: " + numberOfWaysToMakeChange(6, new int[]{1, 5}));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // O(n) time | O(n) space

        int[] ways = new int[n+1];
        ways[0] = 1;
        // Base case.
        // Note that there are only one way to make change for 0; that is to not use any coins.

        for (int denomination : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denomination <= amount) {
                    ways[amount] = ways[amount] + ways[amount - denomination];
                }
            }
        }

        return ways[n];
    }
}

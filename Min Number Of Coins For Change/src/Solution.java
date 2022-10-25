import java.util.Arrays;

public class Solution {

    // Note:
    // Greedy approach (starting from big denominations) will not work here.
    // Because, Amount = 18
    // Coins = 1, 9, 16
    // Greedy approach = 16 + 1 + 1 = 18 (3 coins used)
    // Answer: 9 + 9 = 18 (2 coins used)

    public static void main(String[] args) {
        System.out.println("Min Number Of Coins For Change - Solution 1: " + minNumberOfCoinsForChange_solution_1(7, new int[]{1, 5, 10}));
        System.out.println("Min Number Of Coins For Change - Solution 2: " + minNumberOfCoinsForChange_solution_2(7, new int[]{1, 5, 10}));
    }

    public static int minNumberOfCoinsForChange_solution_1(int n, int[] denoms) {

        // Using recursion and dynamic programming.
        // O(n*m) time, no. of distinct recursive calls * no. of work per recursive call.
        // O(m) space, where m is the amount.

        int[] dpArr = new int[n+1];
        return minNumberOfCoinsForChange(denoms, n, dpArr);
    }

    private static int minNumberOfCoinsForChange(int[] coins, int amount, int[] dpArr) {
        if (amount <= 0) return 0;

        int ans = -1;

        if (dpArr[amount] != 0) return dpArr[amount];

        for (int coin : coins) {
            if (coin <= amount) {
                int val = minNumberOfCoinsForChange(coins, amount - coin, dpArr);

                if (val != -1 && (ans == -1 || val + 1 < ans)) {
                    ans = val + 1;
                }
            }
        }

        dpArr[amount] = ans;
        return ans;
    }

    public static int minNumberOfCoinsForChange_solution_2(int n, int[] denoms) {

        // Using iterative approach and dynamic programming.
        // O(n*d) time, where d is the number of denominations.
        // O(n) space

        int[] numOfCoins = new int[n+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare;

        for (int denomination : denoms) {
            for (int amount = 0; amount <= n; amount++) {
                if (denomination <= amount) {
                    if (numOfCoins[amount - denomination] == Integer.MAX_VALUE) {
                        toCompare = numOfCoins[amount - denomination];
                    } else {
                        toCompare = numOfCoins[amount - denomination] + 1;
                    }
                    numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
                }
            }
        }

        return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
    }
}

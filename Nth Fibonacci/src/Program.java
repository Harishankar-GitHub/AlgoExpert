import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        int n = 6;

        System.out.println("Fibonacci (using recursion) of " + n + ": " + getNthFib_using_recursion(n));
        System.out.println("Fibonacci (using recursion and memoization 1) of " + n + ": " + getNthFib_using_recursion_and_memoization_1(n));
        System.out.println("Fibonacci (using recursion and memoization 2) of " + n + ": " + getNthFib_using_recursion_and_memoization_2(n));
        System.out.println("Fibonacci (using tabulation) of " + n + ": " + getNthFib_tabulation(n));
        System.out.println("Fibonacci (using space optimization 1) of " + n + ": " + getNthFib_space_optimization_1(n));
        System.out.println("Fibonacci (using space optimization 2) of " + n + ": " + getNthFib_space_optimization_2(n));
        System.out.println("Fibonacci (using space optimization 3) of " + n + ": " + getNthFib_space_optimization_3(n));

        fibonacciSeries(n);

        // NOTE:
        //                          Top Down                         <                 Bottom up                    <          Space optimization
        //              O(n) time | O(n)+O(n) space         <         O(n) time | O(n) space         <         O(n) time | O(1) space
    }

    public static int getNthFib_using_recursion(int n) {

        // O(2^n) time | O(n) space
        // At any given time in the algorithm, we store at most O(n) space on the call stack.

        if(n == 2) return 1;
        if(n <= 1) return n;
        // Above 2 are base cases.

        return getNthFib_using_recursion(n - 1) + getNthFib_using_recursion(n - 2);
    }

    public static int getNthFib_using_recursion_and_memoization_1(int n) {

        // O(n) time | O(n) + O(n) space = O(n) space
        // Using Dynamic Programming - Top Down - Recursion and Memoization

        // Step 1
        Map<Integer, Integer> memoize = new HashMap<>();

        // Step 2
        memoize.put(1, 0);
        memoize.put(2, 1);

        return getNthFib(n, memoize);
    }

    private static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (n <= 1) return n;
        // Base case.

        // Step 4
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        }

        // Step 3
        memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
        return memoize.get(n);
    }

    public static int getNthFib_using_recursion_and_memoization_2(int n) {

        // O(n) time | O(n) + O(n) space = O(n) space
        // Using Dynamic Programming - Top Down - Recursion and Memoization

        // Step 1
        int[] dpArray = new int[n+1];
        Arrays.fill(dpArray, -1);

        return getNthFib(n, dpArray);
    }

    private static int getNthFib(int n, int[] dpArray) {
        if (n <= 1) return n;
        // Base case.

        // Step 3
        if (dpArray[n] != -1) {
            return dpArray[n];
        }

        // Step 2
        dpArray[n] = getNthFib(n-1, dpArray) + getNthFib(n-2, dpArray);
        return dpArray[n];
    }

    public static int getNthFib_tabulation(int n) {

        // O(n) time | O(n) space
        // Using Dynamic Programming - Bottom up - Tabulation

        // Step 1
        int[] dpArray = new int[n+1];

        // Step 2
        dpArray[0] = 0;
        dpArray[1] = 1;

        // Step 3
        for (int i = 2; i <= n; i++) {
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        }

        return dpArray[n];
    }

    public static int getNthFib_space_optimization_1(int n) {

        // O(n) time | O(1) space
        // Using Dynamic Programming - Space optimization.

        int prev1 = 1;
        int prev2 = 0;

        if (n == 0) return prev2; // or return 0;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static int getNthFib_space_optimization_2(int n) {

        // O(n) time | O(1) space

        int[] lastTwo = {0, 1};
        int counter = 2;

        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

    public static int getNthFib_space_optimization_3(int n) {

        // O(n) time | O(1) space

        int prev1 = 1;
        int prev2 = 0;

        if (n == 0) return prev2; // or return 0;

        while (n >= 2) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
            n--;
        }

        return prev1;
    }

    // ------------------------------------------------------------------------------------------------

    public static void fibonacciSeries(int n) {

        System.out.println("Fibonacci Series of " + n + ": ");

        if(n == 2) System.out.println("1");
        if(n == 1) System.out.println("0");

        int a = 0;
        int b = 1;
        int sum;

        System.out.print(a + " " + b + " ");

        while (n >= 2) {
            sum = a + b;
            System.out.print(sum + " ");
            a = b;
            b = sum;
            n--;
        }
    }
}
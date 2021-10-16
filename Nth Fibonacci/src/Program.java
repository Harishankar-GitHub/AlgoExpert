import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        int n = 6;

        System.out.println("Fibonacci (using recursion) of " + n + ": " + getNthFib_using_recursion(n));
        System.out.println("Fibonacci (using recursion and caching) of " + n + ": " + getNthFib_using_recursion_and_caching(n));
        System.out.println("Fibonacci (using iterative while loop) of " + n + ": " + getNthFib_iterative_while_loop(n));
        System.out.println("Fibonacci (using iterative for loop) of " + n + ": " + getNthFib_iterative_for_loop(n));
        System.out.println("Fibonacci (using iterative for loop another solution) of " + n + ": " + getNthFib_iterative_for_loop_another_solution(n));

        fibonacciSeries(n);
    }

    public static int getNthFib_using_recursion(int n) {

        // O(2^n) time | O(n) space
        // At any given time in the algorithm, we store at most O(n) space on the call stack.

        if(n == 2) return 1;
        if(n == 1) return 0;

        return getNthFib_using_recursion(n - 1) + getNthFib_using_recursion(n - 2);
    }

    public static int getNthFib_using_recursion_and_caching(int n) {

        // O(n) time | O(n) space

        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);

        return getNthFib(n, memoize);
    }

    private static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (!memoize.containsKey(n)) {
            memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
        }
        return memoize.get(n);
    }

    public static int getNthFib_iterative_while_loop(int n) {

        // O(n) time | O(1) space

        if(n == 2) return 1;
        if(n == 1) return 0;

        int a = 0;
        int b = 1;
        int sum = 0;

        while (n > 2) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return sum;
    }

    public static int getNthFib_iterative_for_loop(int n) {

        // O(n) time | O(1) space

        int[] lastTwo = {0, 1};
        int counter = 3;

        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

    public static int getNthFib_iterative_for_loop_another_solution(int n) {

        // O(n) time | O(1) space

        if(n == 2) return 1;
        if(n == 1) return 0;

        int a = 0;
        int b = 1;
        int sum = 0;

        for (int i = 0; i < n - 2; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void fibonacciSeries(int n) {

        System.out.println("Fibonacci Series of " + n + ": ");

        if(n == 2) System.out.println("1");
        if(n == 1) System.out.println("0");

        int a = 0;
        int b = 1;
        int sum = 0;

        System.out.print(a + " " + b + " ");

        while (n > 2) {
            sum = a + b;
            System.out.print(sum + " ");
            a = b;
            b = sum;
            n--;
        }
    }
}

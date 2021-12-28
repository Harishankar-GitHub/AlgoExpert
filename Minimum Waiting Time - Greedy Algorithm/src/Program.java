import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        System.out.println(minimumWaitingTime_method_1(new int[]{3, 2, 1, 2, 6}));
        System.out.println(minimumWaitingTime_method_2(new int[]{3, 2, 1, 2, 6}));
    }

    public static int minimumWaitingTime_method_1(int[] queries) {

        // O(nlogn) to sort the array. O(n) to iterate the array once.
        // O(nlogn) time | O(1) space
        // where n is the number of queries.
        
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        int counter  = 0;

        for (int i = 0; i < queries.length - 1; i++) {
            counter += 1;
            int currentSum = 0;

            for (int j = 0; j < counter; j++) {
                currentSum += queries[j];
            }

            totalWaitingTime += currentSum;
        }

        return totalWaitingTime;
    }

    public static int minimumWaitingTime_method_2(int[] queries) {

        // O(nlogn) to sort the array. O(n) to iterate the array once.
        // O(nlogn) time | O(1) space
        // where n is the number of queries.

        Arrays.sort(queries);

        int totalWaitingTime = 0;

        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i+1);
            totalWaitingTime += duration * queriesLeft;
        }

        return totalWaitingTime;
    }
}

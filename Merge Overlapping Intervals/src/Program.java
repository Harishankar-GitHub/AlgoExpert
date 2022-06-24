import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        mergeOverlappingIntervals(
                                new int[][] {
                                        {1, 2},
                                        {3, 5},
                                        {4, 7},
                                        {6, 8},
                                        {9, 10}
                                }
                        )));
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        // O(nlog(n)) time | O(n) space

        // Sort the intervals by starting value.
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);

        for (int[] nextInterval : sortedIntervals) {
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                mergedIntervals.add(nextInterval);
                currentInterval = nextInterval;
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}

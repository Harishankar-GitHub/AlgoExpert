public class Program {

    public static void main(String[] args) {
        System.out.println("Kadane's Algorithm\nMaximum sum that can be obtained by summing up " +
                "all of the integers\nin a non-empty subarray of the input array: "
        + kadanesAlgorithm(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));
    }

    public static int kadanesAlgorithm(int[] array) {

        // O(n) time | O(1) space

        int maxEndingHere = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            int currentNum = array[i];
            maxEndingHere = Math.max(maxEndingHere + currentNum, currentNum);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}

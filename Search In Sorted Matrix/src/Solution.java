import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchInSortedMatrix
                (new int[][]{
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
                }, 44)
        ));
        System.out.println(Arrays.toString(searchInSortedMatrix
                (new int[][]{
                        {1, 4, 7, 12, 15, 1000},
                        {2, 5, 19, 31, 32, 1001},
                        {3, 8, 24, 33, 35, 1002},
                        {40, 41, 42, 44, 45, 1003},
                        {99, 100, 103, 106, 128, 1004},
                }, 4)
        ));
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        // O(n+m) time | O(1) space

        int row = 0;
        int col = matrix[0].length - 1;
        // Starting from top right of the matrix.
        // Starting from bottom left also works!

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];

            if (target > value) row++;
            else if (target < value) col--;
            else return new int[]{row, col};
        }

        return new int[]{-1, -1};
    }
}

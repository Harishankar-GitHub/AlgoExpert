import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Integer> list;

        System.out.println("Iterative Solution");
        list = spiralTraverse_iterative_solution(new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        });

        list.forEach(System.out::print);
        System.out.println();

        list = spiralTraverse_iterative_solution(new int[][]{  // Sample input for 3rd For loop.
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        });

        list.forEach(System.out::print);
        System.out.println();

        list = spiralTraverse_iterative_solution(new int[][]{  // Sample input for 4th For loop.
                {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7}
        });

        list.forEach(System.out::print);

        System.out.println("\nRecursive Solution");
        list = spiralTraverse_recursive_solution(new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        });

        list.forEach(System.out::print);
        System.out.println();

        list = spiralTraverse_recursive_solution(new int[][]{  // Sample input for 3rd For loop.
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        });

        list.forEach(System.out::print);
        System.out.println();

        list = spiralTraverse_recursive_solution(new int[][]{  // Sample input for 4th For loop.
                {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7}
        });

        list.forEach(System.out::print);
    }

    public static List<Integer> spiralTraverse_iterative_solution(int[][] array) {

        // O(n) time | O(n) space
        // where n is the total number of elements

        if (array.length == 0) return new ArrayList<>();

        List<Integer> resultList = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                resultList.add(array[startRow][col]);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                resultList.add(array[row][endCol]);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                // Handle the edge case when there's a single row
                // in the middle of the matrix. In this case, we don't
                // want to double-count the values in this row, which
                // we've already counted in the first for loop above.
                if (startRow == endRow) break;
                resultList.add(array[endRow][col]);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                // Handle the edge case when there's a single column
                // in the middle of the matrix. In this case, we don't
                // want to double-count the values in this column, which
                // we've already counted in the second for loop above.
                if (startCol == endCol) break;
                resultList.add(array[row][startCol]);
            }

                startRow += 1;
                endRow -= 1;
                startCol += 1;
                endCol -= 1;
            }

        return resultList;
    }

    public static List<Integer> spiralTraverse_recursive_solution(int[][] array) {

        // O(n) time | O(n) space
        // where n is the total number of elements

        if (array.length == 0) return new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, resultList);
        return resultList;
    }

    private static void spiralFill(
                                                int[][] array,
                                                int startRow,
                                                int endRow,
                                                int startCol,
                                                int endCol,
                                                List<Integer> resultList) {
        if (startRow > endRow || startCol > endCol) return;

        for (int col = startCol; col <= endCol; col++) {
            resultList.add(array[startRow][col]);
        }

        for (int row = startRow + 1; row <= endRow; row++) {
            resultList.add(array[row][endCol]);
        }

        for (int col = endCol - 1; col >= startCol; col--) {
            // Handle the edge case when there's a single row
            // in the middle of the matrix. In this case, we don't
            // want to double-count the values in this row, which
            // we've already counted in the first for loop above.
            if (startRow == endRow) break;
            resultList.add(array[endRow][col]);
        }

        for (int row = endRow - 1; row > startRow; row--) {
            // Handle the edge case when there's a single column
            // in the middle of the matrix. In this case, we don't
            // want to double-count the values in this column, which
            // we've already counted in the second for loop above.
            if (startCol == endCol) break;
            resultList.add(array[row][startCol]);
        }

        spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, resultList);
    }
}

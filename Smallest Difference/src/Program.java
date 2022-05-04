import java.util.Arrays;

class Program {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference_method1(
                new int[]{-1, 5, 10, 20, 28, 3},
                new int[]{26, 134, 135, 15, 17})
        ));

        System.out.println(Arrays.toString(smallestDifference_method2(
                new int[]{-1, 5, 10, 20, 28, 3},
                new int[]{26, 134, 135, 15, 17})
        ));
    }

    public static int[] smallestDifference_method1(int[] arrayOne, int[] arrayTwo) {

        // O(n^2) time | O(1) space

        int smallestDifference = Integer.MAX_VALUE;
        int[] resultArr = new int[2];   // There will only be one pair of numbers with the smallest difference.

        for (int firstNum : arrayOne) {
            for (int secondNum : arrayTwo) {
                int currentDifference;

                if (firstNum < secondNum) {
                    currentDifference = secondNum - firstNum;
                } else if (secondNum < firstNum) {
                    currentDifference = firstNum - secondNum;
                } else {
                    return new int[]{firstNum, secondNum};
                }

                if (smallestDifference > currentDifference) {
                    smallestDifference = currentDifference;
                    resultArr = new int[]{firstNum, secondNum};
                }
            }
        }
        return resultArr;
    }

    public static int[] smallestDifference_method2(int[] arrayOne, int[] arrayTwo) {

        // O(n(logn) + m(logm)) time | O(1) space
        // where n(logn) and m(logm) are the time required to sort arrayOne and arrayTwo respectively.

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int arrOneIndex = 0;
        int arrTwoIndex = 0;
        int smallestDifference = Integer.MAX_VALUE;
        int[] resultArr = new int[2];   // There will only be one pair of numbers with the smallest difference.

        while (arrOneIndex < arrayOne.length && arrTwoIndex < arrayTwo.length) {
            int firstNum = arrayOne[arrOneIndex];
            int secondNum = arrayTwo[arrTwoIndex];
            int currentDifference;

            if (firstNum < secondNum) {
                currentDifference = secondNum - firstNum;
                arrOneIndex++;
            } else if (secondNum < firstNum) {
                currentDifference = firstNum - secondNum;
                arrTwoIndex++;
            } else {
                return new int[]{firstNum, secondNum};
            }

            if (smallestDifference > currentDifference) {
                smallestDifference = currentDifference;
                resultArr = new int[]{firstNum, secondNum};
            }
        }
        return resultArr;
    }
}
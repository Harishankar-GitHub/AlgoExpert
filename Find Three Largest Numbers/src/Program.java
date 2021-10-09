import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println(Arrays.toString(findThreeLargestNumbers(array)));
    }

    public static int[] findThreeLargestNumbers(int[] array) {

        // O(n) time | O(1) space
        // where n is the length of the input array.

        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : array) {
            updateLargest(threeLargest, num);
        }
        return threeLargest;
    }

    private static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            shiftAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]){
           shiftAndUpdate(threeLargest, num, 1);
        } else if (num > threeLargest[0]){
            shiftAndUpdate(threeLargest, num, 0);
        }
}

    private static void shiftAndUpdate(int[] threeLargest, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                threeLargest[i] = num;
            } else {
                threeLargest[i] = threeLargest[i + 1];
            }
        }
    }
}

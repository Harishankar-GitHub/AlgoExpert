import java.util.Arrays;
import java.util.Stack;

public class Program {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement_solution_1(new int[]{2, 5, -3, -4, 6, 7, 2})));
        System.out.println(Arrays.toString(nextGreaterElement_solution_2(new int[]{2, 5, -3, -4, 6, 7, 2})));
    }

    public static int[] nextGreaterElement_solution_1(int[] array) {

        // O(n) time | O(n) space
        // In this approach, indices are stored in the stack.

        int length = array.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * length; i++) {
            int index = i % length;

            while (!stack.isEmpty() && array[stack.peek()] < array[index]) {
                int top = stack.pop();
                result[top] = array[index];
            }
            stack.push(index);
        }

        return result;
    }

    public static int[] nextGreaterElement_solution_2(int[] array) {

        // O(n) time | O(n) space
        // In this approach, values are stored in the stack.

        int length = array.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * length - 1; i >= 0 ; i--) {
            int index = i % length;

            while (!stack.isEmpty()) {
                int currentNum = array[index];

                if (stack.peek() <= currentNum) {
                    stack.pop();
                } else {
                    result[index] = stack.peek();
                    break;
                }
            }

            stack.push(array[index]);
        }

        return result;
    }
}

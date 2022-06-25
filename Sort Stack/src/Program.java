import java.util.ArrayList;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        printStack(stack);
        ArrayList<Integer> sortedStack = sortStack(stack);
        printStack(sortedStack);
    }

    private static void printStack(ArrayList<Integer> stack) {
        for (Integer i : stack) {
            System.out.print(i + "");
        }
        System.out.println();
    }

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {

        // O(n^2) time | O(n) space

        if (stack.size() == 0) return stack;

        int top = stack.remove(stack.size() - 1);

        sortStack(stack);

        insertInSortedOrder(stack, top);

        return stack;
    }

    private static void insertInSortedOrder(ArrayList<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }

        int top = stack.remove(stack.size() - 1);

        insertInSortedOrder(stack, value);

        stack.add(top);
    }
}

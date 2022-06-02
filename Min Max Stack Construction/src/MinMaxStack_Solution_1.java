import java.util.ArrayList;
import java.util.List;

class MinMaxStack_Solution_1 {
    private final List<Integer> stack = new ArrayList<>();
    private final List<Integer> min = new ArrayList<>();
    private final List<Integer> max = new ArrayList<>();

    // O(1) time | O(1) space
    public int peek() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public int pop() {
        if (stack.isEmpty()) return -1;

        int stackSize = stack.size();   // Can be min/max size() as well.
        Integer numberToBePopped = stack.get(stackSize - 1);
        stack.remove(stackSize - 1);
        min.remove(stackSize - 1);
        max.remove(stackSize - 1);
        return numberToBePopped;
    }

    // O(1) time | O(1) space
    public void push(Integer number) {
        stack.add(number);

        if (min.isEmpty() || max.isEmpty()) {
            min.add(number);
            max.add(number);
        } else {
            Integer currentMax = max.get(max.size() - 1);
            Integer currentMin = min.get(min.size() - 1);

            if (number < currentMin) min.add(number);
            else min.add(currentMin);

            if (number > currentMax) max.add(number);
            else max.add(currentMax);
        }
    }

    // O(1) time | O(1) space
    public int getMin() {
        return min.isEmpty() ? -1 : min.get(min.size() - 1);
    }

    // O(1) time | O(1) space
    public int getMax() {
        return max.isEmpty() ? -1 : max.get(max.size() - 1);
    }
}
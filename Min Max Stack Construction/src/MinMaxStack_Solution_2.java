import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MinMaxStack_Solution_2 {
    private final List<Integer> stack = new ArrayList<>();
    List<Map<String, Integer>> minMaxStack = new ArrayList<>();
    public static final String MIN = "min";
    public static final String MAX = "max";

    // O(1) time | O(1) space
    public int peek() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public int pop() {
        if (stack.isEmpty()) return -1;

        int stackSize = stack.size();   // Can be minMaxStack size() as well.
        Integer numberToBePopped = stack.get(stackSize - 1);
        stack.remove(stackSize - 1);
        minMaxStack.remove(stackSize - 1);
        return numberToBePopped;
    }

    // O(1) time | O(1) space
    public void push(Integer number) {
        stack.add(number);

        Map<String, Integer> newMinMax = new HashMap<>();
        newMinMax.put(MIN, number);
        newMinMax.put(MAX, number);

        if (!minMaxStack.isEmpty()) {
            Map<String, Integer> currentMinMax = minMaxStack.get(minMaxStack.size() - 1);

            newMinMax.replace(MIN, Math.min(newMinMax.get(MIN), currentMinMax.get(MIN)));
            newMinMax.replace(MAX, Math.max(newMinMax.get(MAX), currentMinMax.get(MAX)));
        }

        minMaxStack.add(newMinMax);
    }

    // O(1) time | O(1) space
    public int getMin() {
        return minMaxStack.isEmpty() ? -1 : minMaxStack.get(minMaxStack.size() - 1).get(MIN);
    }

    // O(1) time | O(1) space
    public int getMax() {
        return minMaxStack.isEmpty() ? -1 : minMaxStack.get(minMaxStack.size() - 1).get(MAX);
    }
}
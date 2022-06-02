import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MinMaxStack_Solution_3 {
    private final LinkedList<Integer> stack = new LinkedList<>();
    List<Map<String, Integer>> minMaxStack = new ArrayList<>();
    public static final String MIN = "min";
    public static final String MAX = "max";

    // O(1) time | O(1) space
    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    // O(1) time | O(1) space
    public int pop() {
        if (stack.isEmpty()) return -1;

        int stackSize = stack.size();   // Can be minMaxStack size() as well.
        Integer numberToBePopped = stack.pop();
        minMaxStack.remove(stackSize - 1);
        return numberToBePopped;
    }

    // O(1) time | O(1) space
    public void push(Integer number) {
        stack.push(number);

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
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Program {

    public static void main(String[] args) {
        System.out.println("Balanced Brackets: " + balancedBrackets_solution_1("([])(){}(())()()"));
        System.out.println("Balanced Brackets: " + balancedBrackets_solution_2("([])(){}(())()()"));
    }

    public static boolean balancedBrackets_solution_1(String str) {

        // O(n) time | O(n) space

        System.out.println(str);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {

                if (stack.isEmpty()) return false;

                char popChar = stack.pop();

                if (popChar == '(' && currentChar != ')') return false;
                else if (popChar == '[' && currentChar != ']') return false;
                else if (popChar == '{' && currentChar != '}') return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean balancedBrackets_solution_2(String str) {

        // O(n) time | O(n) space

        System.out.println(str);

        Stack<Character> stack = new Stack<>();
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');


        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (openingBrackets.indexOf(currentChar) != -1) {
                stack.push(currentChar);
            } else if (closingBrackets.indexOf(currentChar) != -1) {

                if (stack.isEmpty()) return false;
                char popChar = stack.pop();
                if (popChar != matchingBrackets.get(currentChar)) return false;
            }
        }

        return stack.isEmpty();
    }
}

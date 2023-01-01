import java.util.ArrayList;
import java.util.Collections;

public class Program {

    public static void main(String[] args) {
        System.out.println("\nReversed String: " + reverseWordsInString_Solution1("AlgoExpert is the best!"));
        System.out.println("\nReversed String: " + reverseWordsInString_Solution2("AlgoExpert is the best!"));
    }

    // Note: Solution 2 is easy to understand.

    public static String reverseWordsInString_Solution1(String string) {

        // O(n) time | O(n) space

        ArrayList<String> words = new ArrayList<>();
        int startOfWord = 0;

        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);

            if (character == ' ') {
                words.add(string.substring(startOfWord, index));
                startOfWord = index;
            } else if (string.charAt(startOfWord) == ' ') {
                words.add(" ");
                startOfWord = index;
            }
        }

        words.add(string.substring(startOfWord));

        Collections.reverse(words); // O(n) time
        return String.join("", words);
    }

    public static String reverseWordsInString_Solution2(String string) {

        // O(n) time | O(n) space

        char[] characters = string.toCharArray();
        int length = characters.length;

        reverseListRange(characters, 0, length - 1);

        int startOfWord = 0;
        while (startOfWord < length) {
            int endOfWord = startOfWord;
            while (endOfWord < length && characters[endOfWord] != ' ') {
                endOfWord += 1;
            }

            reverseListRange(characters, startOfWord, endOfWord - 1);
            startOfWord = endOfWord + 1;
        }

        return new String(characters);
    }

    private static void reverseListRange(char[] list, int start, int end) {
        while (start < end) {
            char temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        String s = "abcdcaf";

        System.out.println(firstNonRepeatingCharacter_method1(s));
        System.out.println(firstNonRepeatingCharacter_method2(s));
        System.out.println(firstNonRepeatingCharacter_method3(s));
    }

    public static int firstNonRepeatingCharacter_method1(String string) {
        // Using built in method
        // O(n) time | O(1) space
        // where n is the length of the input string.
        // We don't use any extra space.

        for (char c : string.toCharArray()) {
            if (string.indexOf(c) == string.lastIndexOf(c))
                return string.indexOf(c);
        }
        return -1;
    }

    public static int firstNonRepeatingCharacter_method2(String string) {
        // Using HashMap
        // O(n) time | O(1) space
        // where n is the length of the input string.
        // The Constant Space is because the input string has only lowercase
        // English-Alphabet letters. Thus, the HashMap will never have more than
        // 26 characters.

        Map<Character,Integer> charCountMap = new HashMap<>();

        for (char c : string.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : string.toCharArray()) {
            if (charCountMap.get(c) == 1)
                return string.indexOf(c);
        }
        return -1;
    }

    public static int firstNonRepeatingCharacter_method3(String string) {
        // Using Array to store count of characters
        // O(n) time | O(1) space
        // where n is the length of the input string.
        // The Constant Space is because the input string has only lowercase
        // English-Alphabet letters. And we have an array of size 26 to store the count.
        // of each characters.

        char[] charCounts = new char[26];

        for (char c : string.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (char c : string.toCharArray()) {
            if (charCounts[c - 'a'] == 1) return string.indexOf(c);
        }
        return -1;
    }
}

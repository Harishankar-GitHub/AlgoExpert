import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        printList(groupAnagrams_solution_1
                (new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"))));
        System.out.println("----------------------------------------");
        printList(groupAnagrams_solution_2
                (new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"))));
    }

    public static List<List<String>> groupAnagrams_solution_1(List<String> words) {

        // O(w * nlog(n)) time | O(wn) space
        // where w is the number of words and n is the longest word.

        List<List<String>> groupAnagrams = new ArrayList<>();

        for (int i = 0; i < words.size() - 1; i++) {
            List<String> currentAnagramGroup = new ArrayList<>();
            String currentStr = words.get(i);
            char[] currentStringArray = currentStr.toCharArray();
            Arrays.sort(currentStringArray);
            currentAnagramGroup.add(currentStr);
            for (int j = i+1; j < words.size(); j++) {
                String anotherString = words.get(j);
                char[] anotherStringArray = anotherString.toCharArray();
                Arrays.sort(anotherStringArray);

                if (Arrays.equals(currentStringArray, anotherStringArray)) {
                    currentAnagramGroup.add(anotherString);
                }
            }
            groupAnagrams.add(currentAnagramGroup);
            words.removeAll(currentAnagramGroup);
            i = -1;
        }

        if (!words.isEmpty()) groupAnagrams.add(words);

        return groupAnagrams;
    }

    public static List<List<String>> groupAnagrams_solution_2(List<String> words) {

        // O(w * nlog(n)) time | O(wn) space
        // where w is the number of words and n is the longest word.

        Map<String, List<String>> groupAnagrams = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if (groupAnagrams.containsKey(sortedWord)) {
                groupAnagrams.get(sortedWord).add(word);
            } else {
                groupAnagrams.put(sortedWord, new ArrayList<>(List.of(word)));
            }
        }

        return new ArrayList<>(groupAnagrams.values());
    }

    private static void printList(List<List<String>> list) {
        list.forEach(System.out::println);
    }
}

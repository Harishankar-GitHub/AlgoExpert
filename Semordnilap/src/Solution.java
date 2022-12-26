import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println("\n---------------------------------------");
        System.out.println("\n My solution");
        ArrayList<ArrayList<String>> semordnilap = semordnilap(new String[]{"diaper", "abc", "test", "cba", "repaid"});
        if (semordnilap.isEmpty()) System.out.println("No semordnilap!");
        else semordnilap.forEach(System.out::println);

        System.out.println("\n Another solution");
        semordnilap = semordnilap_another_solution(new String[]{"diaper", "abc", "test", "cba", "repaid"});
        if (semordnilap.isEmpty()) System.out.println("No semordnilap!");
        else semordnilap.forEach(System.out::println);

        System.out.println("\n My solution is better!");
        System.out.println("---------------------------------------");
    }

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {

        // O(n*m) time | O(n) space
        // where n is the number of words and m is the length of the longest word.

        ArrayList<ArrayList<String>> semordnilap = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String firstWord = words[i];
            for (int j = i+1; j < words.length; j++) {
                String secondWord = words[j];

                if (firstWord.length() == secondWord.length()) {
                    if(bothWordsAreSame(firstWord, secondWord)) {
                        ArrayList<String> sameWords = new ArrayList<>();
                        sameWords.add(firstWord);
                        sameWords.add(secondWord);
                        semordnilap.add(sameWords);
                    }
                }
            }
        }

        return semordnilap;
    }


    public static ArrayList<ArrayList<String>> semordnilap_another_solution(String[] words) {

        // O(n*m) time | O(n*m) space
        // where n is the number of words and m is the length of the longest word.

        ArrayList<ArrayList<String>> semordnilap = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (wordsSet.contains(reverse) && !reverse.equals(word)) {
                ArrayList<String> sameWords = new ArrayList<>();
                sameWords.add(word);
                sameWords.add(reverse);
                semordnilap.add(sameWords);
                wordsSet.remove(word);
                wordsSet.remove(reverse);
            }
        }

        return semordnilap;
    }

    private static boolean bothWordsAreSame(String firstWord, String secondWord) {
        int start = 0;
        int end = firstWord.length() - 1;

        while (start < end) {
            if (firstWord.charAt(start) != secondWord.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}

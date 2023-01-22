import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minimumCharactersForWords(new String[]{"this", "that", "did", "deed", "them!", "a"})));
    }

    public static char[] minimumCharactersForWords(String[] words) {
        // O(n * l) time | O(c) space
        // where n is the number of words, l is the length of the longest word.
        // c is the number of unique characters across all words.

        Map<Character, Integer> finalCharCountMap = new HashMap<>();
        int uniqueCharCount = 0;

        for (String word : words) {
            Map<Character, Integer> currentWordCharCountMap = getCurrentWordCharCount(word);
            uniqueCharCount = updateFinalCharCount(finalCharCountMap, uniqueCharCount, currentWordCharCountMap);
        }

        return convertFinalCharCountMapToArray(finalCharCountMap, uniqueCharCount);
    }

    private static Map<Character, Integer> getCurrentWordCharCount(String word) {
        Map<Character, Integer> currentWordCharCountMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            currentWordCharCountMap.put(c, currentWordCharCountMap.getOrDefault(c, 0) + 1);
        }
        return currentWordCharCountMap;
    }

    private static int updateFinalCharCount(Map<Character, Integer> finalCharCountMap, int count, Map<Character, Integer> currentWordCharCountMap) {
        for (Map.Entry<Character, Integer> entry : currentWordCharCountMap.entrySet()) {
            int currentWordCharCount = entry.getValue();

            if (!finalCharCountMap.containsKey(entry.getKey())) {
                finalCharCountMap.put(entry.getKey(), currentWordCharCount);
                count += currentWordCharCount;
            }
            else if (finalCharCountMap.get(entry.getKey()) < currentWordCharCount) {
                int difference = currentWordCharCount - finalCharCountMap.get(entry.getKey());
                finalCharCountMap.put(entry.getKey(), Math.max(currentWordCharCount, finalCharCountMap.get(entry.getKey())));
                count += difference;
            }
        }
        return count;
    }

    private static char[] convertFinalCharCountMapToArray(Map<Character, Integer> finalCharCountMap, int uniqueCharCount) {
        char[] resultArr = new char[uniqueCharCount];
        int index = 0;

        for (Map.Entry<Character, Integer> entry : finalCharCountMap.entrySet()) {
            char currentChar = entry.getKey();
            int currentCharCount = entry.getValue();
            for (int i = 0; i < currentCharCount; i++) {
                resultArr[index] = currentChar;
                index++;
            }
        }
        return resultArr;
    }
}

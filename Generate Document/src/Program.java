import java.util.HashMap;
import java.util.Map;

class Program
{
    public static void main(String[] args)
    {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";

        System.out.println(generateDocument_my_solution(characters,document));
        System.out.println(generateDocument_method2(characters,document));
    }

    public static boolean generateDocument_my_solution(String characters, String document)
    {
        // O(n+m+m) time | O(a+b) space
        // where n and m are characters and document respectively.
        // where a and b are unique characters of characters and document respectively.

        Map<Character,Integer> charMap = new HashMap<>();
        Map<Character,Integer> docMap = new HashMap<>();

        for (char c : characters.toCharArray())
        {
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
        }
        for (char c : document.toCharArray())
        {
            docMap.put(c, docMap.getOrDefault(c,0) + 1);
        }

        for (char c : document.toCharArray())
        {
            if (!charMap.containsKey(c) || charMap.get(c) < docMap.get(c))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean generateDocument_method2(String characters, String document)
    {
        // O(n+m) time | O(c) space
        // where n, m and c are characters, document and unique characters in characters respectively.

        Map<Character,Integer> charMap = new HashMap<>();

        for (char c : characters.toCharArray())
        {
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
        }

        for (char c : document.toCharArray())
        {
            if (!charMap.containsKey(c) || charMap.get(c) == 0)
            {
                return false;
            }
            charMap.put(c,charMap.get(c) - 1);
        }
        return true;
    }
}
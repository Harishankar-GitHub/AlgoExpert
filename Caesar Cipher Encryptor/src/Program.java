

class Program
{
    public static void main(String[] args)
    {
        String str = "xyz";
        int key = 2;

//        String str = "abc";
//        int key = 57;

//        String str = "xyz";
//        int key = 25;

        System.out.println(caesarCypherEncryptor_my_solution(str, key));
        System.out.println(caesarCypherEncryptor_method_2(str, key));
        System.out.println(caesarCypherEncryptor_method_3(str, key));
    }

    // ------------------------------------------------------------------------------------------------------------- //

    public static String caesarCypherEncryptor_my_solution(String str, int key)
    {
        // O(n) time | O(n) space

        int[] charArray = new int[str.length()];
        int startingCharValue = 97;
        String result = "";

        if (key % 26 == 0) return str;

        for (int i = 0; i < str.length(); i++)
        {
            if (key <= 26)
            {
                int currentCharValue = (int) str.charAt(i) + key;
                if (currentCharValue > 122)
                {
                    charArray[i] = (startingCharValue) - 1 + (currentCharValue - 122);
                }
                else
                {
                    charArray[i] = currentCharValue;
                }
            }
            else
            {
                key = key % 26;
                charArray[i] = startingCharValue + key;
            }
            result += (char) charArray[i];
        }
        return result;
    }

    // ------------------------------------------------------------------------------------------------------------- //

    public static String caesarCypherEncryptor_method_2(String str, int key)
    {
        // O(n) time | O(n) space

        char[] newLetters = new char[str.length()];
        int newKey = key % 26;

        for (int i = 0; i < str.length(); i++)
        {
            newLetters[i] = getNewLetter(str.charAt(i), newKey);
        }
        return new String(newLetters);
    }

    public static char getNewLetter(char letter, int key)
    {
        int newLetterCode = letter + key;

        if (newLetterCode <= 122) return (char) newLetterCode;
        else return (char)(96 + newLetterCode % 122);
    }

    // ------------------------------------------------------------------------------------------------------------- //

    public static String caesarCypherEncryptor_method_3(String str, int key)
    {
        // O(n) time | O(n) space

        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < str.length(); i++)
        {
            newLetters[i] = getNewLetter(str.charAt(i), newKey, alphabets);
        }
        return new String(newLetters);
    }

    private static char getNewLetter(char letter, int key, String alphabets)
    {
        int newLetterCode = alphabets.indexOf(letter) + key;
        return alphabets.charAt(newLetterCode % 26);
    }

    // ------------------------------------------------------------------------------------------------------------- //
}
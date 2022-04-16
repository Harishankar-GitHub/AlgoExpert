class Program {
    public static void main(String[] args) {
//        String string = "AAAAAAAAAAAAABBCCCCDD";
        String string = "AAABCCDD";

        System.out.println(runLengthEncoding_method1(string));
        System.out.println(runLengthEncoding_method2(string));
    }

    //------------------------------------------------------------------------------------------//

    public static String runLengthEncoding_method1(String string) {
        // Comparing Current Character with Next Character.
        // O(n) time | O(n) space where n is the length of the input string.

        // The input string is non-empty. So the starting count is 1.
        int count = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length() - 1; i++) {
            char currentChar = string.charAt(i);
            char nextChar = string.charAt(i + 1);

            if (currentChar != nextChar || count == 9) {
                result.append(count);
                result.append(currentChar);
                count = 0;
            }
            count++;
        }

        // Handling the last character's count.
        result.append(count);
        result.append(string.charAt(string.length() - 1));

        return result.toString();
    }

    //------------------------------------------------------------------------------------------//

    public static String runLengthEncoding_method2(String string) {
        // Comparing Current Character with Previous Character.
        // O(n) time | O(n) space where n is the length of the input string.

        // The input string is non-empty. So the starting count is 1.
        int count = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            char previousCharacter = string.charAt(i - 1);

            if (currentCharacter != previousCharacter || count == 9) {
                result.append(count);
                result.append(previousCharacter);
                count = 0;
            }
            count++;
        }

        // Handling the last character's count.
        result.append(count);
        result.append(string.charAt(string.length() - 1));

        return result.toString();
    }

    //------------------------------------------------------------------------------------------//
}
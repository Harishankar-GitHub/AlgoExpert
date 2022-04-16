class Program {

    public static void main(String[] args) {
        String str = "ababa";

        System.out.println(isPalindrome_my_solution(str));
        System.out.println(isPalindrome_method2(str));
        System.out.println(isPalindrome_method3(str));
        System.out.println(isPalindrome_method4(str));
    }

    // --------------------------------------------------------------------------------------- //

    public static boolean isPalindrome_my_solution(String str) {
        // O(n) time | O(1) space
        // O(n/2) time which is equal to O(n) time.

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // --------------------------------------------------------------------------------------- //

    public static boolean isPalindrome_method2(String str) {
        // O(n^2) time | O(n) space
        // O(n^2) time:
        //  For iterating the string once in For loop O(n).
        //  Everytime we append a character to a String, a new String is created. So, another O(n).
        //  Hence O(n^2) time.

        String reversedString = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return str.equals(reversedString);
    }

    // --------------------------------------------------------------------------------------- //

    public static boolean isPalindrome_method3(String str) {
        // O(n) time | O(n) space
        // O(n) time:
        //  For iterating the string once in For loop O(n).
        //  We have used StringBuilder instead of String.
        //  So, when appending each character won't create a new String.
        //  Hence, we can complete this in O(n) time.

        StringBuilder reversedString = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }
        return str.equals(reversedString.toString());
    }

    // --------------------------------------------------------------------------------------- //

    public static boolean isPalindrome_method4(String str) {
        // Using Recursion
        // O(n) time | O(n) space

        return isPalindrome(str,0);
    }

    private static boolean isPalindrome(String str, int i) {
        int j = str.length() - 1 - i;

//        return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1);
        return i >= j || str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1);
    }

    // --------------------------------------------------------------------------------------- //
}
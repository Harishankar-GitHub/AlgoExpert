public class Program {

    public static void main(String[] args) {
        System.out.println("Longest Palindromic Substring: " +
                longestPalindromicSubstring("abaxyzzyxf"));
    }

    public static String longestPalindromicSubstring(String str) {

        // O(n^2) time | O(n) space

        int[] longestPalindromeIndices = {0, 1};

        for (int i = 1; i < str.length(); i++) {
            // starting from 1 because single character is also a palindrome
            // and left side of 1st letter in a string has nothing.
            // So, starting from 1.

            int[] oddPalindrome = getLongestPalindromeFrom(str, i-1, i+1);
            int[] evenPalindrome = getLongestPalindromeFrom(str, i-1, i);

            int[] longest = oddPalindrome[1] - oddPalindrome[0] > evenPalindrome[1] - evenPalindrome[0]
                    ? oddPalindrome : evenPalindrome;

            longestPalindromeIndices = longestPalindromeIndices[1] - longestPalindromeIndices[0] > longest[1] - longest[0]
                    ? longestPalindromeIndices : longest;
        }

        return str.substring(longestPalindromeIndices[0], longestPalindromeIndices[1]);
    }

    private static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) break;
            leftIdx -= 1;
            rightIdx += 1;
        }
        return new int[]{leftIdx + 1, rightIdx};
    }
}

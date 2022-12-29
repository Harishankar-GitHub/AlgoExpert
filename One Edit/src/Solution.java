public class Solution {

    public static void main(String[] args) {
        System.out.println("\nMy solution");
        System.out.println(oneEdit_my_solution("hello", "hollo"));  // Returns true
        System.out.println(oneEdit_my_solution("a", "a"));  // Returns true
        System.out.println(oneEdit_my_solution("ab", "b")); // Returns true
        System.out.println(oneEdit_my_solution("bb", "a")); // Returns false
        System.out.println(oneEdit_my_solution("ab", "a")); // Returns true
        System.out.println(oneEdit_my_solution("bcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // Returns true

        System.out.println("\nCode refactored solution");
        System.out.println(oneEdit_code_refactored_solution("hello", "hollo"));  // Returns true
        System.out.println(oneEdit_code_refactored_solution("a", "a"));  // Returns true
        System.out.println(oneEdit_code_refactored_solution("ab", "b")); // Returns true
        System.out.println(oneEdit_code_refactored_solution("bb", "a")); // Returns false
        System.out.println(oneEdit_code_refactored_solution("ab", "a")); // Returns true
        System.out.println(oneEdit_code_refactored_solution("bcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // Returns true
    }

    // Note:
    // My solution is more readable and easy to understand.
    // In my solution, code is implemented based on 3 conditions.
        // 1. If difference in length is more than 1.
        // 2. If lengths are same.
        // 3. If length differs by 1.

    public static boolean oneEdit_my_solution(String stringOne, String stringTwo) {

        // O(n) time | O(1) space

        int stringOneLength = stringOne.length();
        int stringTwoLength = stringTwo.length();

        // If the difference in lengths of the strings is greater than 1,
        // then there's no way to make them equal with a single edit (add/remove/replace).
        // So returning false.
        if (Math.abs(stringOneLength - stringTwoLength) > 1) return false;

        // If the lengths of the strings are same, then the only possible edit is a replacement, because
        // adding or removing a character would make the strings different lengths.
        if (stringOneLength == stringTwoLength) {
            int start = 0;
            int charDifference = 0;

            while (start <= stringOneLength - 1) {
                if (stringOne.charAt(start) != stringTwo.charAt(start)) {
                    charDifference++;
                }
                start++;
            }

            return charDifference <= 1;
        }

        // If the strings are different lengths, the only possible moves are adding and removing a character.
        // These are essentially same operation, because they represent the case where one string has a character that another does not.

        else {
            int stringOneStart = 0;
            int stringTwoStart = 0;
            int end = Math.min(stringOneLength, stringTwoLength) - 1;
            int charDifference = 0;

            while (stringOneStart <= end && stringTwoStart <= end) {
                if (stringOne.charAt(stringOneStart) != stringTwo.charAt(stringTwoStart)) {
                    charDifference++;
                    if (stringOneLength > stringTwoLength) {
                        stringOneStart++;
                    } else {
                        stringTwoStart++;
                    }

                    if (charDifference > 1) return false;
                } else {
                    stringOneStart++;
                    stringTwoStart++;
                }
            }

            // In the above while loop, we are iterating only till the minimum length between the two strings.
            // There will be 1 character remaining in either stringOne or stringTwo.

            // If charDifference is 0 then the remaining character in either stringOne or stringTwo is the only
            // difference. So we can return true here.
            if (charDifference == 0) return true;
            // At this point, the charDifference will be exactly equal to 1.
            // Now the remaining character in either stringOne or stringTwo has to be same
            // because already charDifference is 1. There can't be any more differences.
            else return stringOne.charAt(stringOneLength - 1) == stringTwo.charAt(stringTwoLength - 1);
        }
    }

    public static boolean oneEdit_code_refactored_solution(String stringOne, String stringTwo) {

        // O(n) time | O(1) space

        int stringOneLength = stringOne.length();
        int stringTwoLength = stringTwo.length();

        // If the difference in lengths of the strings is greater than 1,
        // then there's no way to make them equal with a single edit (add/remove/replace).
        // So returning false.
        if (Math.abs(stringOneLength - stringTwoLength) > 1) return false;

        boolean madeEdit = false;
        int indexOne = 0;
        int indexTwo = 0;

        // If the lengths of the strings are same, then the only possible edit is a replacement, because
        // adding or removing a character would make the strings different lengths.
        // If the strings are different lengths, the only possible moves are adding and removing a character.
        // These are essentially same operation, because they represent the case where one string has a character that another does not.

        while (indexOne < stringOneLength && indexTwo < stringTwoLength) {
            if (stringOne.charAt(indexOne) != stringTwo.charAt(indexTwo)) {
                if (madeEdit) {
                    return false;
                } else {
                    madeEdit = true;
                }

                if (stringOneLength > stringTwoLength) {
                    indexOne++;
                } else if (stringTwoLength > stringOneLength) {
                    indexTwo++;
                } else {
                    indexOne++;
                    indexTwo++;
                }
            } else {
                indexOne++;
                indexTwo++;
            }
        }
        return true;
    }
}

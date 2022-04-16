import java.util.*;

class Program {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = List.of(1, 6, -1, 10);

        System.out.println(isValidSubsequence_using_ForLoop(integerList,sequence));
        System.out.println(isValidSubsequence_using_WhileLoop(integerList,sequence));
    }

    public static boolean isValidSubsequence_using_ForLoop(List<Integer> array, List<Integer> sequence) {
        // O(n) time | O(1) space - where n is the length of the array

        int index = 0;

        for (int num : array) {
            if (num == sequence.get(index)) {
                if (index == sequence.size() - 1) return true;
                index++;
            }
        }
        return false;
    }

    public static boolean isValidSubsequence_using_WhileLoop(List<Integer> array, List<Integer> sequence) {
        // O(n) time | O(1) space - where n is the length of the array

        int arrIndex = 0;
        int seqIndex = 0;

        while (arrIndex < array.size() && seqIndex < sequence.size()) {
            if (array.get(arrIndex) == sequence.get(seqIndex))
                seqIndex++;

            arrIndex++;
        }
        return seqIndex == sequence.size();
    }
}
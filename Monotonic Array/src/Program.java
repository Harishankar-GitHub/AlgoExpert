class Program {

    public static void main(String[] args) {
        System.out.println(isMonotonic_method_1(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
        System.out.println(isMonotonic_method_2(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
        System.out.println(isMonotonic_method_3(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
    }

    public static boolean isMonotonic_method_1(int[] array) {

        // O(n) space | O(1) space

        if (array.length <= 1) return true;

        boolean isIncreasing = false;
        boolean isDecreasing = false;

        for (int i = 0; i < array.length - 1; i++) {
            int currentNum = array[i];
            int nextNum = array[i + 1];

            if (currentNum < nextNum) isIncreasing = true;
            if (currentNum > nextNum) isDecreasing = true;

            if (isIncreasing && isDecreasing) return false;
        }

        return true;
    }

    public static boolean isMonotonic_method_2(int[] array) {

        // O(n) space | O(1) space

        if (array.length <= 2) return true;

        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;

        for (int i = 0; i < array.length - 1; i++) {
            int currentNum = array[i];
            int nextNum = array[i + 1];

            if (currentNum < nextNum) isNonIncreasing = false;
            if (currentNum > nextNum) isNonDecreasing = false;
        }

        return isNonIncreasing || isNonDecreasing;
    }

    public static boolean isMonotonic_method_3(int[] array) {

        // O(n) space | O(1) space

        if (array.length <= 2) return true;

        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;

        for (int i = 1; i < array.length; i++) {
            int currentNum = array[i];
            int prevNum = array[i - 1];

            if (currentNum < prevNum) isNonDecreasing = false;
            if (currentNum > prevNum) isNonIncreasing = false;
        }

        return isNonIncreasing || isNonDecreasing;
    }
}
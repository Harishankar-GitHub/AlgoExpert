class Program {

    public static void main(String[] args) {
        System.out.println("Max Subset Sum No Adjacent: "
                + maxSubsetSumNoAdjacent_method_1(new int[] {75, 105, 120, 75, 90, 135}));

        System.out.println("Max Subset Sum No Adjacent: "
                + maxSubsetSumNoAdjacent_method_2(new int[] {75, 105, 120, 75, 90, 135}));
    }

    public static int maxSubsetSumNoAdjacent_method_1(int[] array) {

        // O(n) time | O(n) space

        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];

        int[] maxSums = new int[array.length];

        maxSums[0] = array[0];
        maxSums[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i-1], maxSums[i-2] + array[i]);
        }

        return maxSums[maxSums.length - 1];
    }

    public static int maxSubsetSumNoAdjacent_method_2(int[] array) {

        // O(n) time | O(1) space

        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];

        int second = array[0];
        int first = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            int currentSum = Math.max(first, second + array[i]);
            second = first;
            first = currentSum;
        }

        return first;
    }
}

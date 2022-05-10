class Program {

    public static void main(String[] args) {
        System.out.println("Has Single Cycle: " + hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2}));
    }

    public static boolean hasSingleCycle(int[] array) {

        // O(n) time | O(1) space

        int numOfElementsVisited = 0;
        int currentIdx = 0;

        while (numOfElementsVisited < array.length) {
            if (numOfElementsVisited > 0 && currentIdx == 0) return false;
            numOfElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }

        return currentIdx == 0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }
}
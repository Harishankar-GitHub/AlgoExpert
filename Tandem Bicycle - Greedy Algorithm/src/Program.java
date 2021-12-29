import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        System.out.println("Method 1: Maximum possible total speed: " + tandemBicycle_method_1(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, true));
        System.out.println("Method 1: Minimum possible total speed: " + tandemBicycle_method_1(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, false));

        System.out.println("Method 2: Minimum possible total speed: " + tandemBicycle_method_2(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, true));
        System.out.println("Method 2: Minimum possible total speed: " + tandemBicycle_method_2(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, false));
    }

    public static int tandemBicycle_method_1(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        // O(nlogn) time | O(1) space
        // where n is the number of tandem bicycles

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        int maximumPossibleTotalSpeed = 0;
        int minimumPossibleTotalSpeed = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int redShirtSpeed = redShirtSpeeds[i];

            maximumPossibleTotalSpeed += Math.max(redShirtSpeed, blueShirtSpeeds[blueShirtSpeeds.length - i - 1]);
            minimumPossibleTotalSpeed += Math.max(redShirtSpeed, blueShirtSpeeds[i]);
        }

        if (fastest) {
            return maximumPossibleTotalSpeed;
        } else {
            return minimumPossibleTotalSpeed;
        }
    }

    public static int tandemBicycle_method_2(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        // O(nlogn) time | O(1) space
        // where n is the number of tandem bicycles

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (!fastest) {
            reverseArrayInPlace(redShirtSpeeds);    // Either redShirtSpeeds or blueShirtSpeeds can be reversed.
        }

        int totalSpeed = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int rider1 = redShirtSpeeds[i];
            int rider2 = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
            totalSpeed += Math.max(rider1, rider2);
        }

        return totalSpeed;
    }

    private static void reverseArrayInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

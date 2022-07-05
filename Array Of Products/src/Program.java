import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProducts_bruteForce(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProducts_solution_2(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProducts_solution_3(new int[]{5, 1, 4, 2})));
    }

    public static int[] arrayOfProducts_bruteForce(int[] array) {

        // O(n^2) time | O(n) space
        // Brute Force

        int[] arrayOfProducts = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int currentProduct = 1;
            for (int j = 0; j < array.length; j++) {
                if (j != i) currentProduct *= array[j];
            }
            arrayOfProducts[i] = currentProduct;
        }
        return arrayOfProducts;
    }

    public static int[] arrayOfProducts_solution_2(int[] array) {

        // O(n) time | O(n) space

        int[] leftArray = new int[array.length];
        int[] rightArray = new int[array.length];
        int[] arrayOfProducts = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftArray[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightArray[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            arrayOfProducts[i] = leftArray[i] * rightArray[i];
        }

        return arrayOfProducts;
    }

    public static int[] arrayOfProducts_solution_3(int[] array) {

        // O(n) time | O(n) space

        int[] arrayOfProducts = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            arrayOfProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            arrayOfProducts[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        return arrayOfProducts;
    }
}

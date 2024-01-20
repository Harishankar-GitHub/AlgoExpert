import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProducts_bruteForce(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProducts_solution_2(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProducts_solution_3(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProducts_solution_4(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProducts_solution_4(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(arrayOfProducts_solution_4(new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9})));
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

    public static int[] arrayOfProducts_solution_4(int[] array) {

        // O(n) time | O(1) space

        long product = 1;
        int noOfZeros = 0;

        for (int num : array) {
            if (num == 0) {
                noOfZeros += 1;
                continue;
            }

            if (noOfZeros > 1) {
                product = 0;
                break;
            }

            product = product * num;
        }

        if (noOfZeros > 1) {
            return new int[array.length];
        }

        if (noOfZeros == 1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = (int) product;
                    continue;
                }
                array[i] = 0;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (product /array[i]);
            }
        }

        return array;
    }
}

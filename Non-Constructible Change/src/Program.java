import java.util.Arrays;

class Program {

    public static void main(String[] args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(coins));
    }

    public static int nonConstructibleChange(int[] coins) {
        // O(nlogn + n) = O(nlogn) time | O(1) space
        // nlogn is for sorting the array
        // n is to iterate the array once after sorting

        Arrays.sort(coins);

        int currentChangeCreated = 0;

        for (int coin : coins) {
            if (coin > currentChangeCreated + 1)
                return currentChangeCreated + 1;

            currentChangeCreated += coin;
        }
        return currentChangeCreated + 1;
    }
}
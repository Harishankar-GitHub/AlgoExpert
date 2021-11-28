import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Object> listOfObjects = new ArrayList<>();
        listOfObjects.add(5);
        listOfObjects.add(2);
        List<Object> subList1 = new ArrayList<>();
        subList1.add(7);
        subList1.add(-1);
        listOfObjects.add(subList1);
        listOfObjects.add(3);
        List<Object> subList2 = new ArrayList<>();
        subList2.add(6);
        List<Object> subList3 = new ArrayList<>();
        subList3.add(-13);
        subList3.add(8);
        subList2.add(subList3);
        subList2.add(4);
        listOfObjects.add(subList2);

        // listOfObjects looks like this -> [5, 2, [7, -1], 3, [6, [-13, 8], 4]]

        System.out.println("Product Sum is: " + productSum(listOfObjects));
    }

    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> array) {

        // O(n) time | O(d) space
        // where n is the total number of elements in the array, including sub-elements, and
        // d is the greatest depth of "special" arrays in the array.

        return productSumHelper(array, 1);
    }

    private static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object element : array) {
            if (element instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Object> listOfObjects = (ArrayList<Object>) element;
                sum += productSumHelper(listOfObjects, multiplier + 1);
            } else {
                sum += (int) element;
            }
        }
        return sum * multiplier;
    }
}

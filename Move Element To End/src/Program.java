import java.util.Arrays;
import java.util.List;

class Program {

    public static void main(String[] args) {
        moveElementToEnd_method_1(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2)
                .forEach(System.out::print);

        System.out.println();

        moveElementToEnd_method_2(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2)
                .forEach(System.out::print);

        System.out.println();

        moveElementToEnd_method_3(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2)
                .forEach(System.out::print);
    }

    public static List<Integer> moveElementToEnd_method_1(List<Integer> array, int toMove) {

        // O(n) time | O(1) space

        int start = 0;
        int end = array.size() - 1;

        while (start < end) {
            int startNum = array.get(start);
            int endNum = array.get(end);

            if (startNum == toMove) {
                if (endNum != toMove) {
                    array.set(end, startNum);
                    array.set(start, endNum);
                    start += 1;
                }
                end -= 1;
            } else {
                start += 1;
            }
        }

        return array;
    }

    public static List<Integer> moveElementToEnd_method_2(List<Integer> array, int toMove) {

        // O(n) time | O(1) space

        int start = 0;
        int end = array.size() - 1;

        while (start < end) {
            int startNum = array.get(start);
            int endNum = array.get(end);

            if (endNum != toMove) {
                if (startNum == toMove) {
                    array.set(end, startNum);
                    array.set(start, endNum);
                    start += 1;
                    end -= 1;
                } else {
                    start += 1;
                }
            } else {
                end -= 1;
            }
        }

        return array;
    }

    public static List<Integer> moveElementToEnd_method_3(List<Integer> array, int toMove) {

        // O(n) time | O(1) space

        int start = 0;
        int end = array.size() - 1;

        while (start < end) {
            while (start < end &&  array.get(end) == toMove) end -= 1;

            int startNum = array.get(start);
            int endNum = array.get(end);

            if (startNum == toMove) {
                array.set(end, startNum);
                array.set(start, endNum);
            }
            start += 1;
        }

        return array;
    }
}
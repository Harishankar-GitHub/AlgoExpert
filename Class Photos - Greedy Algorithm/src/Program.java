import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Program {

    public static void main(String[] args) {

        ArrayList<Integer> redShirtHeights;
        ArrayList<Integer> blueShirtHeights;

        redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
        System.out.println(classPhotos_Method_1(redShirtHeights, blueShirtHeights));

        redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
        System.out.println(classPhotos_Method_2(redShirtHeights, blueShirtHeights));
    }

    public static boolean classPhotos_Method_1(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {

        // O(nlogn) time | O(1) space

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int redShirtBehindBlueShirt = 0;
        int blueShirtBehindRedShirt = 0;

        for (int i = 0; i < redShirtHeights.size(); i++) {

            int redShirtHeight = redShirtHeights.get(i);
            int blueShirtHeight = blueShirtHeights.get(i);

            if (redShirtHeight > blueShirtHeight) {
                redShirtBehindBlueShirt += 1;
            } else if (blueShirtHeight > redShirtHeight) {
                blueShirtBehindRedShirt += 1;
            }

            if (redShirtBehindBlueShirt != i+1 && blueShirtBehindRedShirt != i+1) {
                return false;
            }
        }
        return true;
    }

    public static boolean classPhotos_Method_2(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {

        // O(nlogn) time | O(1) space

        redShirtHeights.sort(Collections.reverseOrder());
        blueShirtHeights.sort(Collections.reverseOrder());

        String shirtColorInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUE";

        for (int i = 0; i < redShirtHeights.size(); i++) {
            int redShirtHeight = redShirtHeights.get(i);
            int blueShirtHeight = blueShirtHeights.get(i);

            if (shirtColorInFirstRow.equals("RED")) {
                if (redShirtHeight >= blueShirtHeight) {
                    return false;
                }
            } else {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            }
        }
        return true;
    }
}

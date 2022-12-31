import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        System.out.println("\nArray Implementation");
        sunsetViews_ArrayListImplementation(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST")
                .forEach(System.out::print);
        System.out.println();
        sunsetViews_ArrayListImplementation(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST")
                .forEach(System.out::print);
        System.out.println();
        sunsetViews_ArrayListImplementation(new int[]{}, "EAST")
                .forEach(System.out::print);
        System.out.println();
        sunsetViews_ArrayListImplementation(new int[]{}, "WEST")
                .forEach(System.out::print);

        System.out.println("\nStack Implementation");
        sunsetViews_StackImplementation(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST")
                .forEach(System.out::print);
        System.out.println();
        sunsetViews_StackImplementation(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST")
                .forEach(System.out::print);
        System.out.println();
        sunsetViews_StackImplementation(new int[]{}, "EAST")
                .forEach(System.out::print);
        System.out.println();
        sunsetViews_StackImplementation(new int[]{}, "WEST")
                .forEach(System.out::print);
    }

    public static ArrayList<Integer> sunsetViews_ArrayListImplementation(int[] buildings, String direction) {

        // O(n) time | O(n) space
        // ArrayListImplementation

        ArrayList<Integer> sunsetViews = new ArrayList<>();
        int currentTallest = 0;

        if (direction.equals("EAST")) {
            for (int buildingIndex = buildings.length - 1; buildingIndex >= 0; buildingIndex--) {
                currentTallest = updateSunsetViewsAndCurrentTallest(buildings[buildingIndex], sunsetViews, currentTallest, buildingIndex);
            }
            Collections.reverse(sunsetViews);   // O(n) time
        } else if (direction.equals("WEST")) {
            for (int buildingIndex = 0; buildingIndex < buildings.length; buildingIndex++) {
                currentTallest = updateSunsetViewsAndCurrentTallest(buildings[buildingIndex], sunsetViews, currentTallest, buildingIndex);
            }
        }

        return sunsetViews;
    }

    private static int updateSunsetViewsAndCurrentTallest(int currentBuilding, ArrayList<Integer> sunsetViews, int currentTallest, int currentBuildingIndex) {
        if (currentBuilding > currentTallest) {
            sunsetViews.add(currentBuildingIndex);
            currentTallest = currentBuilding;
        }
        return currentTallest;
    }

    public static ArrayList<Integer> sunsetViews_StackImplementation(int[] buildings, String direction) {

        // O(n) time | O(n) space
        // StackImplementation

        if (buildings.length == 0) return new ArrayList<>();

        ArrayList<Integer> sunsetViews = new ArrayList<>();
        int start = buildings.length - 1;
        int step = -1;

        if (direction.equals("EAST")) {
            start = 0;
            step = 1;
        }

        int index = start;
        while (index >= 0 && index < buildings.length) {
            int currentBuilding = buildings[index];

            while (sunsetViews.size() > 0
                    && buildings[sunsetViews.get(sunsetViews.size() - 1)] <= currentBuilding) {
                sunsetViews.remove(sunsetViews.size() - 1);
            }

            sunsetViews.add(index);
            index += step;
        }

        if (direction.equals("WEST")) {
            Collections.reverse(sunsetViews);   // O(n) time
        }

        return sunsetViews;
    }
}

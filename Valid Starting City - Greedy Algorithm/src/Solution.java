public class Solution {

    public static void main(String[] args) {
        System.out.println(validStartingCity(new int[]{5, 25, 15, 10, 15}, new int[]{1, 2, 1, 0, 3}, 10));
    }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

        // O(n) time | O(1) space
        // where n is the number of cities.

        int numberOfCities = distances.length;
        int milesRemaining = 0;

        int indexOfStartingCityCandidate = 0;
        int milesRemainingAtStartingCityCandidate = 0;

        for (int cityIndex = 1; cityIndex < numberOfCities; cityIndex++) {
            int distanceFromPreviousCity = distances[cityIndex-1];
            int fuelFromPreviousCity = fuel[cityIndex - 1];

            milesRemaining += fuelFromPreviousCity * mpg - distanceFromPreviousCity;

            if (milesRemaining < milesRemainingAtStartingCityCandidate) {
                milesRemainingAtStartingCityCandidate = milesRemaining;
                indexOfStartingCityCandidate = cityIndex;
            }
        }

        return indexOfStartingCityCandidate;
    }
}

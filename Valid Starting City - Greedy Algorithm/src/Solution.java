public class Solution {

    public static void main(String[] args) {
        System.out.println(validStartingCity(
                new int[]{5, 25, 15, 10, 15},
                new int[]{1, 2, 1, 0, 3},
                10));
    }

    // Note:
    // distances = 5, 25, 15, 10, 15
    // fuel = 1, 2, 1, 0, 3
    // milesPerGallon (mpg) = 10

    // We iterate all cities once.
    // For example:
    // We start from city in index 0.
    // We calculate the fuel remaining after travelling to city in index 1.
    // So in this case, distance travelled is 5 (to go to city 1 from city 0). And fuel available at city 0 is 1 unit (1 * 10 = 10 miles per gallon)
    // So in city 1, the fuel remaining is 5, and we get 2 units of fuel at city 1 and 25 is the distance that will take to travel to city 2
    // and so on and so forth.
    // We calculate this for all cities.
    // The city that we go to that has the minimum/negative amount of fuel at it (this could be a negative value) must be the city that we have to start at.
    // So that city is a valid starting city.

    // It doesn't matter which city at which we start at. If we start at any other city (apart from city 4 in this case),
    // we're always going to reach a city with the minimum/negative amount of fuel.

    // If we can find the city that we enter with the minimum number of fuel, it doesn't matter which city we started at
    // because this city will always have the minimum number of fuel when we enter it,
    // which means we must start at that city because if we don't start at that city, we won't be able to reach that city
    // because we'll have a minimum/negative amount of fuel in our gas tank.


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

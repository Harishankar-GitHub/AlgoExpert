import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                stableInternships(
                        new int[][]{
                                {0, 1, 2},
                                {1, 0, 2},
                                {1, 2, 0}},
                        new int[][]{
                                {2, 1, 0},
                                {1, 2, 0},
                                {0, 2, 1}})
        ));
    }

    public static int[][] stableInternships(int[][] interns, int[][] teams) {

        // O(n^2) time | O(n^2) space
        // where n is the number of interns and teams

        Map<Integer, Integer> teamsAndInterns = new HashMap<>();
        Stack<Integer> freeInterns = new Stack<>();
        int internsLength = interns.length;

        // Adding intern numbers to the stack.
        // 0th, 1st, 2nd, 3rd etc.
        for (int i = 0; i < internsLength; i++) {
            freeInterns.push(i);
        }

        List<Map<Integer, Integer>> teamMaps = new ArrayList<>();
        // Adding team details to teamMaps.
        // Example:
        // teamMaps index 0 will contain the details of team 0 like below.
        // 2 -> 0 i.e., Intern 2 is 1st preference
        // 1 -> 1 i.e., Intern 1 is 2nd preference
        // 0 -> 2 i.e., Intern 0 is 3rd preference

        for (int[] team : teams) {
            Map<Integer, Integer> rank = new HashMap<>();

            for (int i = 0; i < team.length; i++) {
                rank.put(team[i], i);
            }
            teamMaps.add(rank);
        }

        int[] teamsChosenByCurrentIntern = new int[internsLength];
        // All the elements in this array are going to be 0 because initially the interns are going to start
        // by choosing their first preferred team.

        while (!freeInterns.isEmpty()) {
            int internNum = freeInterns.pop();

            int[] teamPreferences = interns[internNum];
            int teamPreference = teamPreferences[teamsChosenByCurrentIntern[internNum]];
            teamsChosenByCurrentIntern[internNum]++;

            if (!teamsAndInterns.containsKey(teamPreference)) {
                teamsAndInterns.put(teamPreference, internNum);
                continue;
            }

            int previousIntern = teamsAndInterns.get(teamPreference);
            int previousInternRank = teamMaps.get(teamPreference).get(previousIntern);
            int currentInternRank = teamMaps.get(teamPreference).get(internNum);

            if (currentInternRank < previousInternRank) {
                freeInterns.push(previousIntern);
                teamsAndInterns.put(teamPreference, internNum);
            } else {
                freeInterns.push(internNum);
            }
        }

        int[][] matches = new int[internsLength][2];
        int index = 0;

        for (Map.Entry<Integer, Integer> teamAndIntern : teamsAndInterns.entrySet()) {
            matches[index] = new int[] {teamAndIntern.getValue(), teamAndIntern.getKey()};
            index++;
        }

        return matches;
    }
}

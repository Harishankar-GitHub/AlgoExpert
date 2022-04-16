import java.util.*;

class Program {

    public static void main(String[] args) {
        ArrayList<String> competition1 = new ArrayList<>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<>(Arrays.asList("Python", "HTML"));

        ArrayList<ArrayList<String>> competitions = new ArrayList<>();

        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));

        System.out.println(tournamentWinner(competitions, results));
    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // O(n) time | O(k) space
        // where n is the number of competitions
        // and O(k+1) = O(k) is the number of teams
        // and the extra 1 is the {"",0} added to the map to optimize.

        final int HOME_TEAM = 1;

        Map<String,Integer> scoreMap = new HashMap<>();
        String currentBestTeam = "";
        scoreMap.put(currentBestTeam, 0);

        int pointsForWinning = 3;

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> currentCompetition = competitions.get(i);

            String homeTeam = currentCompetition.get(0);
            String awayTeam = currentCompetition.get(1);
            int result = results.get(i);

            String winningTeam = (result == HOME_TEAM) ? homeTeam : awayTeam;
            scoreMap.put(winningTeam, scoreMap.getOrDefault(winningTeam, 0) + pointsForWinning);

            if (scoreMap.get(winningTeam) > scoreMap.get(currentBestTeam))
                currentBestTeam = winningTeam;
        }
        return currentBestTeam;
    }
}

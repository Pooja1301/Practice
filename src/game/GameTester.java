package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameTester {


    public static void main(String[] args) throws IOException {

        String inputLine;
        String[] splitLine;

        int numberOfSupporters;
        int numberOfReporters;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        splitLine = br.readLine().split(" ");

        Team team1 = new Team(splitLine[0]);
        Team team2 = new Team(splitLine[1]);

        FootballGame game = new FootballGame(team1, team2);

        splitLine = br.readLine().split(" ");
        numberOfSupporters = Integer.parseInt(splitLine[0]);
        numberOfReporters = Integer.parseInt(splitLine[1]);

        List<Fan> fans = getFansFromInput(numberOfSupporters, br, team1, team2);

        List<Reporter> reporters = getReportersFromInput(numberOfReporters, br);


        fans.forEach(game::addObserver);

        reporters.forEach(game::addObserver);

        while ((inputLine = br.readLine()) != null) {
            if (inputLine.contains("Goal:")) {

                splitLine = inputLine.split(" ");
                game.goal(getTeamByTeamName(splitLine[1], team1, team2));
            } else {
                game.gameOver();
            }
        }
    }

    private static List<Reporter> getReportersFromInput(int numberOfReporters, BufferedReader br) throws IOException {
        String[] splitLine;
        List<Reporter> reporters = new ArrayList<>();
        for (int i = 1; i <= numberOfReporters; i++) {

            String reporterName;
            String channelName;

            splitLine = br.readLine().split(", ");

            reporterName = splitLine[0];
            channelName = splitLine[1];

            Reporter reporter = new Reporter(reporterName, channelName);
            reporters.add(reporter);

        }
        return reporters;
    }

    private static List<Fan> getFansFromInput(int numberOfSupporters, BufferedReader br, Team team1, Team team2) throws IOException {
        String[] splitLine;
        List<Fan> fans = new ArrayList<>();
        for (int i = 1; i <= numberOfSupporters; i++) {

            String supporterName;
            Team supportedTeam;
            String teamName;


            splitLine = br.readLine().split(", ");

            supporterName = splitLine[0];
            teamName = splitLine[1];
            supportedTeam = getTeamByTeamName(teamName, team1, team2);

            Fan supporter = new Fan(supportedTeam, supporterName);
            fans.add(supporter);

        }
        return fans;
    }

    private static Team getTeamByTeamName(String teamName, Team team1, Team team2) {

        return teamName.equals(team1.getName()) ? team1 : team2;
    }

}

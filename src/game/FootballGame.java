package game;

import java.util.ArrayList;
import java.util.List;

public class FootballGame {

    private ScoreBoard scoreBoard;
    private List<GameObserver> observers;

    public FootballGame(Team team1, Team team2) {
        this.observers = new ArrayList<>();
        scoreBoard = new ScoreBoard(team1, team2);
    }

    public FootballGame addObserver(GameObserver observer) {
        this.observers.add(observer);
        return this;
    }

    public void goal(Team team) {

        scoreBoard.increaseScore(team);
        for (GameObserver observer : observers) {
            observer.goalResponse(team);
        }
    }

    public void gameOver() {

        for (GameObserver observer : observers) {
            observer.gameOverResponse(scoreBoard);
        }

    }
}

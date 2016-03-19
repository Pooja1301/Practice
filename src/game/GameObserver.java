package game;

public interface GameObserver {

    void goalResponse(Team team);

    void gameOverResponse(ScoreBoard scoreBoard);

}

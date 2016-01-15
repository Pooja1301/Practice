import java.util.ArrayList;
import java.util.List;

public class Football{

    private Team team1;
    private Team team2;

    private List<GameObserver> observers;

    public Football(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.observers = new ArrayList<>();
    }

    public Football addObserver(GameObserver observer){
        this.observers.add(observer);
        return this;
    }

    public void goal(Team team){

        for(GameObserver observer: observers) {
            observer.goalResponse(team);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class GameTester {
    public static void main(String[] args) {
        Team indianTeam = new Team("India");
        Team pakistan = new Team("Pakistan");
        Fan prateek = new Fan(indianTeam, "Prateek");
        GameObserver pooja = new Fan(pakistan, "Pooja");

        Reporter reporter1 = new Reporter("CNN");
        Reporter reporter2 = new Reporter("BBC");


        Football game = new Football(indianTeam,pakistan);
        game.addObserver(prateek)
                .addObserver(pooja)
                .addObserver(reporter1)
                .addObserver(reporter2);

        game.goal(pakistan);
    }
}

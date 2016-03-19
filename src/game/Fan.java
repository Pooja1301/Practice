package game;

public class Fan implements GameObserver {

    private final Team supportedTeam;
    private final String name;

    public Fan(Team supportedTeam, String name) {
        this.supportedTeam = supportedTeam;
        this.name = name;
    }

    public Team getSupportedTeam(){
        return this.supportedTeam;
    }


    public void goalResponse(Team goalTeam){

        if(goalTeam == this.getSupportedTeam())
            System.out.println(this.name + ": Hurrah!");
        else
            System.out.println(this.name+": Alas!");
    }

    public void gameOverResponse(ScoreBoard scoreBoard) {

        if(getSupportedTeam().equals(scoreBoard.getWinner())){
            System.out.println(this.name+" say Yes! "+supportedTeam.getName()+" won.");
        }
        else{
            System.out.println(this.name+" says Alas! "+supportedTeam.getName()+" lost.");
        }
    }


}

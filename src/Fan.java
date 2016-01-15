public class Fan implements GameObserver {

    private final Team supportTeam;
    private final String name;

    public Fan(Team supportTeam, String name) {
        this.supportTeam = supportTeam;
        this.name = name;
    }

    public Team getSupportTeam(){
        return this.supportTeam;
    }

    public void goalResponse(Team goalTeam){

        if(goalTeam == this.supportTeam)
            System.out.println(this.name + ": Hurrah :)");
        else
            System.out.println(this.name+": Alas :(");
    }
}

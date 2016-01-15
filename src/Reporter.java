public class Reporter implements GameObserver{

    private final String channelName;

    public Reporter(String channelName) {
        this.channelName = channelName;
    }

    public void goalResponse(Team team){
        System.out.println(channelName+" reports that team "+ team.getTeamName()+ " has scored a goal");
    }
}

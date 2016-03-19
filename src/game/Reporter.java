package game;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporter implements GameObserver{

    private final String reporterName;
    private final String channelName;

    public Reporter(String reporterName, String channelName) {
        this.reporterName = reporterName;
        this.channelName = channelName;
    }

    public void goalResponse(Team team){

        Date date = new Date();
        SimpleDateFormat time = new SimpleDateFormat("h:mm a");
        System.out.println(this.reporterName+" reports:"+ team.getName()+ " has scored a goal at "+time.format(date.getTime())+". Brought to you by "+this.channelName);
    }

    public void gameOverResponse(ScoreBoard sb) {
        System.out.println(this.reporterName+" reports: "+sb.getWinner().getName()+"" +
                " has won the game against "+sb.getLooser().getName()+" by "
                +sb.getScore(sb.getWinner())+"-"+sb.getScore(sb.getLooser())+
                ". Brought to you by "+this.channelName+".");
    }


}

package game;

public class ScoreBoard{

    TeamScore team1Score;
    TeamScore team2Score;

    public ScoreBoard(Team team1, Team team2) {

        team1Score = new TeamScore(team1,0);
        team2Score = new TeamScore(team2,0);
    }

    public void increaseScore(Team team){
        if(team.equals(team1Score.team))
            team1Score.score++;
        else
            team2Score.score++;
    }

    public int getScore(Team team){
        return getTeamScore(team).score;
    }

    public Team getLooser(){
        return (team1Score.score > team2Score.score ? team2Score.team : team1Score.team);
    }

    public Team getWinner(){
        return (team1Score.score > team2Score.score ? team1Score.team : team2Score.team);
    }

    private TeamScore getTeamScore(Team team){
        return  team.equals(team1Score.team)? team1Score : team2Score;
    }


    private class TeamScore{
        Team team;
        int score;

        public TeamScore(Team team, int score) {
            this.team = team;
            this.score = score;
        }
    }



}

import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {

    private int wins;
    private int draws;
    private int defeats;
    private int receivedgoals;
    private int scoredgoals;
    private double points;
    private int matchesplayed;

    public FootballClub(String name, String zone, int wins, int draws, int defeats, int receivedgoals, int scoredgoals, double points, int matchesplayed) {
        super(name, zone);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.receivedgoals = receivedgoals;
        this.scoredgoals = scoredgoals;
        this.points = points;
        this.matchesplayed = matchesplayed;
    }

    public FootballClub(){

    }
    @Override
    public String toString() {
        return "FootballClub{" + super.toString() +
                "wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", receivedgoals=" + receivedgoals +
                ", scoredgoals=" + scoredgoals +
                ", points=" + points +
                ", matchesplayed=" + matchesplayed +
                '}';
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getReceivedgoals() {
        return receivedgoals;
    }

    public void setReceivedgoals(int receivedgoals) {
        this.receivedgoals = receivedgoals;
    }

    public int getScoredgoals() {
        return scoredgoals;
    }

    public void setScoredgoals(int scoredgoals) {
        this.scoredgoals = scoredgoals;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getMatchesplayed() {
        return matchesplayed;
    }

    public void setMatchesplayed(int matchesplayed) {
        this.matchesplayed = matchesplayed;
    }
    public int compareTo(FootballClub o) {
        if (this.points == o.points) {
//          if goalsScored same check goal difference here
            if ((this.scoredgoals - this.receivedgoals) > ((o.scoredgoals - o.receivedgoals))) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.points > o.points) {
            return 1;
        } else {
            return -1;
        }
    }
}

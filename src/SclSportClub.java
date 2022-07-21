public class SclSportClub extends FootballClub{
    private String Sclname;
    private String scllocation;

    public SclSportClub(String name, String zone, int wins, int draws, int defeats, int receivedgoals, int scoredgoals, double points, int matchesplayed, String sclname, String scllocation) {
        super(name, zone, wins, draws, defeats, receivedgoals, scoredgoals, points, matchesplayed);
        Sclname = sclname;
        this.scllocation = scllocation;
    }

    public SclSportClub() {

    }

    public String getSclname() {
        return Sclname;
    }

    public void setSclname(String sclname) {
        Sclname = sclname;
    }

    public String getScllocation() {
        return scllocation;
    }

    public void setScllocation(String scllocation) {
        this.scllocation = scllocation;
    }

    @Override
    public String toString() {
        return "SclSportClub{" + super.toString() +
                "Sclname='" + Sclname + '\'' +
                ", scllocation='" + scllocation + '\'' +
                '}';
    }
}

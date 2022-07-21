public class UniSportClub extends FootballClub{
    private String uniname;
    private String unilocation;

    public UniSportClub(String name, String zone, int wins, int draws, int defeats, int receivedgoals, int scoredgoals, double points, int matchesplayed, String uniname, String unilocation) {
        super(name, zone, wins, draws, defeats, receivedgoals, scoredgoals, points, matchesplayed);
        this.uniname = uniname;
        this.unilocation = unilocation;
    }

    public UniSportClub() {

    }

    public String getUniname() {
        return uniname;
    }

    public void setUniname(String uniname) {
        this.uniname = uniname;
    }

    public String getUnilocation() {
        return unilocation;
    }

    public void setUnilocation(String unilocation) {
        this.unilocation = unilocation;
    }

    @Override
    public String toString() {
        return "UniSportClub{" + super.toString() +
                "uniname='" + uniname + '\'' +
                ", unilocation='" + unilocation + '\'' +
                '}';
    }
}

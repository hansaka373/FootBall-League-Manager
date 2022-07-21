import java.io.Serializable;
import java.util.Date;

public class Match  implements Serializable {
    private String name1;
    private String name2;
    private int scoredgoals1;
    private double points1;
    private int scoredgoals2;
    private double points2;
    private Date date;

    public Match() {

    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getScoredgoals1() {
        return scoredgoals1;
    }

    public void setScoredgoals1(int scoredgoals1) {
        this.scoredgoals1 = scoredgoals1;
    }

    public double getPoints1() {
        return points1;
    }

    public void setPoints1(double points1) {
        this.points1 = points1;
    }

    public int getScoredgoals2() {
        return scoredgoals2;
    }

    public void setScoredgoals2(int scoredgoals2) {
        this.scoredgoals2 = scoredgoals2;
    }

    public double getPoints2() {
        return points2;
    }

    public void setPoints2(double points2) {
        this.points2 = points2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Match(String name1, String name2, int scoredgoals1, double points1, int scoredgoals2, double points2, Date date) {
        this.name1 = name1;
        this.name2 = name2;
        this.scoredgoals1 = scoredgoals1;
        this.points1 = points1;
        this.scoredgoals2 = scoredgoals2;
        this.points2 = points2;
        this.date = date;
    }
}


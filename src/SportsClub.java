import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    private String name;
    private String zone;

    public SportsClub(String name, String zone) {
        this.name = name;
        this.zone = zone;
    }

    public SportsClub() {

    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SportsClub sportClub = (SportsClub) o;
        return name == sportClub.name;
    }
    public int hashCode() {
        return Objects.hash(name, zone);
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "name='" + name + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

}

import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    void addFootballClub(FootballClub footballClub);
    void deleteClub(String footballClub);
    void teamStatistics(String footballClub);
    void saveData(String file) throws IOException;
    void loadData(String file) throws IOException, ClassNotFoundException;
    void printDetails();
    void matchesplayed();

}

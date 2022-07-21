import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PremierLeagueManager implements LeagueManager{
    private ArrayList<FootballClub>footballClubs=new ArrayList<>();
            ArrayList<Match>matches=new ArrayList<>();

    @Override
    public void addFootballClub(FootballClub footballClub){
        boolean condition=false;

        for(FootballClub fb:footballClubs){
            if (footballClub.getName().equals(fb.getName())){
                condition=true;
                break;
            }

        }
        if(!condition){
            footballClubs.add(footballClub);
            System.out.println("Congrats!..Successfully Added...");
        }
        else {
            System.out.println("The team has already added");
        }
    }

    @Override
    public void deleteClub(String footballClub) {
        boolean b = false;

        for (FootballClub fb : footballClubs) {
            if (fb.getName().equals(footballClub)) {
                b=true;
                footballClubs.remove(fb);
                System.out.println("Team removed successfully. ");
                break;
            }
        }

        if (b==false){
            System.out.println("Team name not found. Try again");
        }
    }

    @Override
    public void teamStatistics(String footballClub){
        boolean b = false;

        for (FootballClub fb : footballClubs) {
            if (fb.getName().equals(footballClub)) {
                b=true;
                //System.out.println(fb);
                String name = "Name";
                String wins = "Wins";
                String draws = "Draws";
                String defeats =  "Defeats";
                String receivedgoals = "Recieved Goals";
                String scoredgoals = "Scored Goals";
                String points = "Points";
                String matchesplayed = "Matches Played";

                System.out.printf("| %-15s| %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-10s|\n",name,wins,draws,defeats,receivedgoals,scoredgoals,points,matchesplayed);
                System.out.println("......................................................................................................");

                    name = String.valueOf(fb.getName());
                    wins = String.valueOf(fb.getWins()) ;
                    draws = String.valueOf(fb.getDraws());
                    defeats = String.valueOf(fb.getDefeats());
                    receivedgoals = String.valueOf(fb.getReceivedgoals());
                    scoredgoals = String.valueOf(fb.getScoredgoals());
                    points = String.valueOf(fb.getPoints());
                    matchesplayed = String.valueOf(fb.getMatchesplayed()); //

                    System.out.printf("| %-15s| %-15s | %-15s | %-15s | %-15s | %-10s | %-13s | %-5s|\n",name,wins,draws,defeats,receivedgoals,scoredgoals,points,matchesplayed);
                    System.out.println("......................................................................................................................");
            }
        }

        if (b==false){
            System.out.println("Team not found... Try again");
        }
    }



    @Override
    public void printDetails() {

        if(footballClubs.isEmpty()){
            System.out.println("No Teams to Display...");
        }
        else{
            Collections.sort(footballClubs);

        }
        String name = "Name";
        String wins = "Wins";
        String draws = "Draws";
        String defeats =  "Defeats";
        String receivedgoals = "Recieved Goals";
        String scoredgoals = "Scored Goals";
        String points = "Points";
        String matchesplayed = "Matches Played";

        System.out.printf("| %-15s| %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-10s|\n",name,wins,draws,defeats,receivedgoals,scoredgoals,points,matchesplayed);
        System.out.println("......................................................................................................");

        for(FootballClub footballClub :footballClubs)
        {

             name = String.valueOf(footballClub.getName());
             wins = String.valueOf(footballClub.getWins()) ;
             draws = String.valueOf(footballClub.getDraws());
             defeats = String.valueOf(footballClub.getDefeats());
             receivedgoals = String.valueOf(footballClub.getReceivedgoals());
             scoredgoals = String.valueOf(footballClub.getScoredgoals());
             points = String.valueOf(footballClub.getPoints());
             matchesplayed = String.valueOf(footballClub.getMatchesplayed()); //

            System.out.printf("| %-15s| %-15s | %-15s | %-15s | %-15s | %-10s | %-13s | %-5s|\n",name,wins,draws,defeats,receivedgoals,scoredgoals,points,matchesplayed);
            System.out.println("......................................................................................................................");



        }
    }
    @Override
    public void saveData(String file) throws IOException {
        FileOutputStream fos = new  FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(FootballClub fb:footballClubs){
            oos.writeObject(fb);
        }
        oos.flush();
        oos.close();
        fos.close();
        System.out.println("Data has been Successfully Saved !");
    }

    @Override
    public void loadData(String file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        for(;;){
            try{
                FootballClub fb = (FootballClub) ois.readObject();
                footballClubs.add(fb);
            }
            catch (EOFException e){
                break;
            }
        }
        fis.close();
        ois.close();

        System.out.println("Data has been Successfully Loaded from the file !");
    }
    @Override
    public void matchesplayed() {
        if (footballClubs.isEmpty()) {
            System.out.println("No Clubs to Display");
        } else {
            FootballClub fb1 = null;
            FootballClub fb2 = null;
            int point1 = 0;
            int point2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Date below DD-MM-YY");
            System.out.println("Enter the Day");
            System.out.println("");
            String day = sc.nextLine();

            Date date;

            //Date format
            try {
                date = new SimpleDateFormat("DD-MM-YYYY").parse(day);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Invalid Format");
                return;
            }
            //getting the names of teams
            System.out.println("Enter the name of Team 1");
            String newname = sc.nextLine();
            FootballClub team = null;
            for (FootballClub fb : footballClubs) {

                if (fb.getName().equals(newname)) {
                    fb1 = fb;
                    team = fb;
                    break;
                }
            }
            System.out.println("Enter the name of Team 2");
            String newname2 = sc.nextLine();
            FootballClub team2 = null;
            for (FootballClub fb : footballClubs) {

                if (fb.getName().equals(newname2)) {
                    fb2 = fb;
                    team2 = fb;
                    break;
                }
            }

                if (!(fb1 == null || fb2 == null)) {
                    System.out.println("Enter the score of team 1");
                    int score1 = sc.nextInt();

                    System.out.println("Enter the score of team 2");
                    int score2 = sc.nextInt();

//after considering the scored goals calculate the wins, draws,defeats,points and add 1 to played match
                    if (score1 > score2) {
                        fb1.setWins(fb1.getWins() + 1);
                        fb1.setScoredgoals(fb1.getScoredgoals() + score1);
                        fb1.setPoints(fb1.getPoints() + 2);
                        fb1.setReceivedgoals(fb1.getReceivedgoals() + score2);
                        fb1.setMatchesplayed(fb1.getMatchesplayed() + 1);

                        fb2.setDefeats(fb2.getDefeats() + 1);
                        fb2.setScoredgoals(fb2.getScoredgoals() + score1);
                        fb2.setReceivedgoals(fb2.getReceivedgoals() + score1);
                        fb2.setMatchesplayed(fb2.getMatchesplayed() + 1);
                    } else if (score1 < score2) {
                        fb2.setWins(fb2.getWins() + 1);
                        fb2.setScoredgoals(fb2.getScoredgoals() + score2);
                        fb2.setPoints(fb2.getPoints() + 2);
                        fb2.setReceivedgoals(fb2.getReceivedgoals() + score1);
                        fb2.setMatchesplayed(fb2.getMatchesplayed() + 1);

                        fb1.setDefeats(fb1.getDefeats() + 1);
                        fb1.setScoredgoals(fb1.getScoredgoals() + score2);
                        fb1.setReceivedgoals(fb1.getReceivedgoals() + score2);
                        fb1.setMatchesplayed(fb1.getMatchesplayed() + 1);
                    } else {
                        fb2.setDraws(fb2.getDraws() + 1);
                        fb2.setScoredgoals(fb2.getScoredgoals() + score2);
                        fb2.setPoints(fb2.getPoints() + 1);
                        fb2.setReceivedgoals(fb2.getReceivedgoals() + score1);
                        fb2.setMatchesplayed(fb2.getMatchesplayed() + 1);

                        fb1.setDraws(fb1.getDraws() + 1);
                        fb1.setScoredgoals(fb1.getScoredgoals() + score2);
                        fb1.setPoints(fb1.getPoints() + 1);
                        fb1.setReceivedgoals(fb1.getReceivedgoals() + score2);
                        fb1.setMatchesplayed(fb1.getMatchesplayed() + 1);
                    }


                    Match match = new Match(newname, newname2, score1, point1, score2, point2, date);
                    matches.add(match);
                } else {
                    System.out.println("club not found");
                }
            }
        }

    void tableView() {
        Stage primaryStage=new Stage();
        Stage window=primaryStage;
        window.setTitle("Point Table");

        TableView<FootballClub> table = new TableView<>();
        //name Collum
        table.setStyle("-fx-background-color: transparent");
        TableColumn<FootballClub,String> nameColum = new TableColumn<>("Team Name");
        nameColum.setMinWidth(100);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));

        //zoneCollum
        TableColumn<FootballClub,String>zoneColum = new TableColumn<>("Team Zone");
        zoneColum.setMinWidth(100);
        zoneColum.setCellValueFactory(new PropertyValueFactory<>("zone"));

        //win collum
        TableColumn<FootballClub, Integer>winColum = new TableColumn<>("Win");
        winColum.setMinWidth(100);
        winColum.setCellValueFactory(new PropertyValueFactory<>("wins"));

        //drwasCollum
        TableColumn<FootballClub, Integer>drawsColum = new TableColumn<>("Draws");
        drawsColum.setMinWidth(100);
        drawsColum.setCellValueFactory(new PropertyValueFactory<>("draws"));

        //defeat Colm
        TableColumn<FootballClub, Integer>defeatColum = new TableColumn<>("Defeats");
        defeatColum.setMinWidth(100);
        defeatColum.setCellValueFactory(new PropertyValueFactory<>("defeats"));

        //recieved Goals
        TableColumn<FootballClub, Integer>rsColum = new TableColumn<>("Received Goals");
        rsColum.setMinWidth(100);
        rsColum.setCellValueFactory(new PropertyValueFactory<>("receivedgoals"));

        //Scored Goals
        TableColumn<FootballClub, Integer>scColum = new TableColumn<>("Scored Goals");
        scColum.setMinWidth(100);
        scColum.setCellValueFactory(new PropertyValueFactory<>("scoredgoals"));

        //poonts Table
        TableColumn<FootballClub, Double>pointColum = new TableColumn<>("Points");
        pointColum.setMinWidth(100);
        pointColum.setCellValueFactory(new PropertyValueFactory<>("points"));

        //MatchesPlayedColum
        TableColumn<FootballClub, Integer>mpColum = new TableColumn<>("Played Matches");
        mpColum.setMinWidth(100);
        mpColum.setCellValueFactory(new PropertyValueFactory<>("matchesplayed"));


        //adding button
        Button button1=new Button("Generate");
        button1.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-background-color: #2d3436; -fx-background-radius: 20; -fx-text-fill: white");
        Button button2=new Button("Sort by Goals");
        button2.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-background-color: #2d3436; -fx-background-radius: 20; -fx-text-fill: white");
        Button button3=new Button("Sort by Wins");
        button3.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-background-color: #2d3436; -fx-background-radius: 20; -fx-text-fill: white");

        button1.setOnAction(event -> {
            if(footballClubs.size()>1){
                Random rd = new Random();

                int team01Score=rd.nextInt(30);
                int team02Score=rd.nextInt(30);
                int team01g=rd.nextInt(footballClubs.size());
                int team02g=rd.nextInt(footballClubs.size());

                FootballClub footballClub01=footballClubs.get(team01g);
                FootballClub footballClub02=footballClubs.get(team02g);

                if(footballClub01.getName().equals(footballClub02.getName())){

                }else {
                    if (team01Score > team02Score) {
                        footballClub01.setWins(footballClub01.getWins() + 1);
                        footballClub01.setScoredgoals(footballClub01.getScoredgoals() + team01Score);
                        footballClub01.setPoints(footballClub01.getPoints() + 2);
                        footballClub01.setReceivedgoals(footballClub01.getReceivedgoals() + team02Score);
                        footballClub01.setMatchesplayed(footballClub01.getMatchesplayed() + 1);

                        footballClub02.setDefeats(footballClub02.getDefeats() + 1);
                        footballClub02.setScoredgoals(footballClub02.getScoredgoals() + team01Score);
                        footballClub02.setReceivedgoals(footballClub02.getReceivedgoals() + team02Score);
                        footballClub02.setMatchesplayed(footballClub02.getMatchesplayed() + 1);
                    } else if (team01Score < team02Score) {
                        footballClub02.setWins(footballClub02.getWins() + 1);
                        footballClub02.setScoredgoals(footballClub02.getScoredgoals() + team02Score);
                        footballClub02.setPoints(footballClub02.getPoints() + 2);
                        footballClub02.setReceivedgoals(footballClub02.getReceivedgoals() + team01Score);
                        footballClub02.setMatchesplayed(footballClub02.getMatchesplayed() + 1);

                        footballClub01.setDefeats(footballClub01.getDefeats() + 1);
                        footballClub01.setScoredgoals(footballClub01.getScoredgoals() + team02Score);
                        footballClub01.setReceivedgoals(footballClub01.getReceivedgoals() + team02Score);
                        footballClub01.setMatchesplayed(footballClub01.getMatchesplayed() + 1);
                    } else {
                        footballClub02.setDraws(footballClub02.getDraws() + 1);
                        footballClub02.setScoredgoals(footballClub02.getScoredgoals() + team02Score);
                        footballClub02.setPoints(footballClub02.getPoints() + 1);
                        footballClub02.setReceivedgoals(footballClub02.getReceivedgoals() + team01Score);
                        footballClub02.setMatchesplayed(footballClub02.getMatchesplayed() + 1);

                        footballClub01.setDraws(footballClub01.getDraws() + 1);
                        footballClub01.setScoredgoals(footballClub01.getScoredgoals() + team02Score);
                        footballClub01.setPoints(footballClub01.getPoints() + 1);
                        footballClub01.setReceivedgoals(footballClub01.getReceivedgoals() + team02Score);
                        footballClub01.setMatchesplayed(footballClub01.getMatchesplayed() + 1);
                    }
                    System.out.println(footballClub01);
                    System.out.println(footballClub02);

                    System.out.println(team01g);
                    System.out.println(team02g);



                    Match match = new Match();
                    matches.add(match);

                }

            }

        }
        );

        button2.setOnAction(event -> {
            Collections.sort(footballClubs);
            /*
            String[] strings = new String[footballClubs.size()];
            for(int i=0;i<footballClubs.size();i++)
            {
                strings[i]=String.valueOf( footballClubs.get(i).getScoredgoals());
            }

            for(int i=0;i<footballClubs.size();i++) {
                for (int j = 0; j < footballClubs.size() - 1 - i; j++) {
                    if (strings[j].compareTo(strings[j + 1]) < 0) {
                        String name = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = name;

                        FootballClub footballClub = footballClubs.get(j);
                        footballClubs.set(j, footballClubs.get(j + 1));
                        footballClubs.set(j + 1, footballClub);
                    }
                }
            }

             */
        });
        TableView<FootballClub> finalTable = table;
        button3.setOnAction(event -> {
            String[] strings = new String[footballClubs.size()];
            for(int i=0;i<footballClubs.size();i++)
            {
                strings[i]=String.valueOf( footballClubs.get(i).getWins());
            }

            for(int i=0;i<footballClubs.size();i++) {
                for (int j = 0; j < footballClubs.size() - 1 - i; j++) {
                    if (strings[j].compareTo(strings[j + 1]) < 0) {
                        String name = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = name;

                        FootballClub footballClub = footballClubs.get(j);
                        footballClubs.set(j, footballClubs.get(j + 1));
                        footballClubs.set(j + 1, footballClub);
                    }
                }
            }
        });



        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(100);
        hBox.getChildren().addAll(button1,button2,button3);


        table=new TableView<>();
        for (FootballClub fb : footballClubs) {
          table.getItems().addAll(fb);
        }
        // table.setItems();
        table.getColumns().addAll(nameColum,zoneColum,winColum,drawsColum,defeatColum,rsColum,scColum,pointColum,mpColum);

        VBox vbox = new VBox(hBox);
        vbox.getChildren().addAll(table);

        Scene scene=new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();

    }
}

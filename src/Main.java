import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    static PremierLeagueManager prelm = new PremierLeagueManager();

    public static void main(String[] args) {launch();}

    public void start(Stage primaryStage) throws Exception {
        Stage window;

        //load Data
        try {
            prelm.loadData("DataFile.txt");
        }catch (Exception e){
            System.out.println("Error");
        }

        //Creating a Scanner to take the input from the user
        Scanner sc = new Scanner(System.in);
        menu:
        while (true) {

            //Creating the console

            System.out.println(" ");
            System.out.println("***********************_ Main Menu_************************");
            System.out.println(" ");
            System.out.println("Enter \'A\' to add a new team");
            System.out.println("Enter \'D\' to delete a team");
            System.out.println("Enter \'T\' for team Statics");
            System.out.println("Enter \'O\' for print team details");
            System.out.println("Enter \'P\' for add matches played");
            System.out.println("Enter \'G\' for the Table View");
            System.out.println("Enter \'Q\' for exit");
            System.out.println(" ");
            System.out.print("Enter here : ");
            String userinput = sc.nextLine();
            System.out.println(" ");

            switch (userinput) {
                case "A":
                case "a":
                        addNewTeam();
                        break;
                case "D":
                case "d":
                        deleteClub();
                    break;
                case "T":
                case "t":
                        teamstatics();
                    break;
                case "O":
                case "o":
                        printdetails();
                    break;
                case "P":
                case "p":
                        matchesplayed();
                    break;
                case "G":
                case "g":
                        prelm.tableView();
                    break ;
                case "Q":
                case "q":
                    //save Data
                    try {
                        prelm.saveData("DataFile.txt");
                    } catch (Exception e){
                        System.out.println("Error");
                    }
                    Quit();
                    break menu;
                default:
                    System.out.println("Invalid input... Please Try Again");
            }
        }
    }



    private void addNewTeam() {
        Scanner sc = new Scanner(System.in);
        FootballClub fbclub=null;


                System.out.println("Enter the Club name");
                System.out.println("");
                String newuniname= sc.nextLine();

                System.out.println("Enter the location of the club");
                System.out.println("");
                String newunizone = sc.nextLine();

                fbclub = new FootballClub(newuniname, newunizone, 0,0,0,0,0,0,0);

        prelm.addFootballClub(fbclub);
    }


    private void Quit() {
        System.out.println("Thank you for using the system... Have a good day");
    }


    private void matchesplayed() {
        prelm.matchesplayed();
    }

    private void printdetails() {
        prelm.printDetails();
    }

    private void teamstatics() {
            Scanner sc = new Scanner(System.in);
            FootballClub fbclub = null;
            System.out.println("Enter the team name that you want to see the statistics");
            System.out.println("");
            String teamforsta = sc.nextLine();
            prelm.teamStatistics(teamforsta);
    }

    private void deleteClub() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter nam to delete");
        String inputfordel = sc.nextLine();
        prelm.deleteClub(inputfordel);
    }
}






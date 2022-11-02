package Menu;

import BattleArena.SingleBattle;
import BattleArena.TeamBattle;
import Droids.BaseDroid;
import Functions.CreateTeam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Functions.Value;

public class MainMenu {
    private final Value value = new Value();
    private final Scanner in = new Scanner(System.in);
    private final Table table = new Table();
    private final ArrayList<BaseDroid> droids = new ArrayList<>();
    private final String FilePath = "D:\\FilesSecCourse\\trash\\fight.txt.";

    public void Menu() throws FileNotFoundException {
        //table.MainMenuTable();
        while(true){
            table.MainMenuTable();
            switch (value.getInt("Choice")) {
                case 1:
                    CaseCreateDroid();
                    break;
                case 2:
                    CaseShowDroids();
                    break;
                case 3:
                    CaseDuel();
                    break;
                case 4:
                    CaseTeamBattle();
                    break;
                case 5:
                    CaseBattleFromFile();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Uncorrect");
                    break;
            }
            DeleteAllDeathDroid();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }



    private void CaseCreateDroid(){
        CreateDroidMenu createDroidMenu = new CreateDroidMenu();
        BaseDroid droid = createDroidMenu.CreateMenu();
        this.droids.add(droid);
    }

    private void CaseShowDroids(){
        int ID = 0;
        System.out.println("\n\n\n");
        table.ListDroidTable();
        for(BaseDroid droid : this.droids){
            System.out.print(" ID = " + ID++ +  " Type = " + droid.getType() + ", ");
            System.out.println(droid);
        }
        table.PrintLine();
        System.out.println("\n\n\n");
    }


    private void CaseDuel() throws FileNotFoundException {
        Random random = new Random();

        if (droids.size() < 2){
            System.out.println("You have less than 2 droids");
            return;
        }

        int ID;
        do{
            ID = value.getInt("ID droid");
        }while(ID > this.droids.size() || ID < 0);
        BaseDroid droid1 = this.droids.get(ID);

        int previous = ID;
        do {
            ID = value.getInt("ID droid");
        }while(ID >= this.droids.size() || ID < 0 || ID == previous);
        BaseDroid droid2 = this.droids.get(ID);

        PrintStream console = System.out;
        PrintStream fileOut = new PrintStream(FilePath);
        System.setOut(fileOut);
        String result = new SingleBattle(droid1,droid2).droidVsDroid();
        fileOut.flush();
        fileOut.close();
        System.setOut(console);
        System.out.println(result);
    }

    private void CaseTeamBattle() throws FileNotFoundException {
        if(this.droids.size() < 4){
            System.out.println("You don`t have enought droids for team battle");
            return;
        }
        int size;
        do {
            size = value.getInt("Size");
        }while(size < 2 || size > (this.droids.size() / 2));
        System.out.println();
        CreateTeam createTeam = new CreateTeam(this.droids);
        System.out.print("Team 1 name: ");
        String name1 = in.nextLine();
        ArrayList<BaseDroid> team1 =  createTeam.CreateDroidTeam(size);
        System.out.print("Team 2 name: ");
        String name2 = in.nextLine();
        ArrayList<BaseDroid> team2 = createTeam.CreateDroidTeam(size);


        PrintStream console = System.out;
        PrintStream fileOut = new PrintStream(FilePath);
        System.setOut(fileOut);
        String result = new TeamBattle(name1, name2, team1, team2).teamVsTeam();
        fileOut.flush();
        fileOut.close();
        System.setOut(console);
        System.out.println(result);
    }


    private void CaseBattleFromFile() throws FileNotFoundException {
        File file = new File(FilePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    private void DeleteAllDeathDroid(){
        this.droids.removeIf(droid -> !droid.isAlive());
    }
}


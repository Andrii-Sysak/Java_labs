package Functions;
import Droids.BaseDroid;

import java.util.ArrayList;

public class CreateTeam {
    private final ArrayList<BaseDroid> droids;
    private final Value value = new Value();
    public CreateTeam(ArrayList<BaseDroid> droids){
        this.droids = new ArrayList<>(droids);
    }
    public ArrayList<BaseDroid> CreateDroidTeam(int size){
        ArrayList<BaseDroid> team = new ArrayList<>();
        for(int i = 0; i < size; i++){
            EnableDroid();
            int ID;
            do {
                ID = value.getInt("ID droid");
            }while(ID >= this.droids.size() || ID < 0);
            BaseDroid droid = this.droids.get(ID);
            team.add(droid);
            this.droids.remove(droid);
        }
        return team;
    }

    private void EnableDroid(){
        int ID = 0;
        System.out.println("\t\t\tENABLE DROID");
        for(BaseDroid droid : this.droids){
            System.out.print(" ID = " + ID++ +  " Type = " + droid.getType() + ", ");
            System.out.println(droid);
        }
    }



}

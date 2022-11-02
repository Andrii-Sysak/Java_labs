package Functions;

import Droids.BaseDroid;
import Droids.Berserker;
import Droids.Healer;
import Droids.Tank;
import Droids.Terminator;

import java.util.Scanner;

public class CreateDroid {
    private final Scanner in = new Scanner(System.in);

    public BaseDroid CreateBaseDroid(){
        String name = getName();
        return new BaseDroid(name);
    }

    public Berserker CreateBerserker(){
        String name = getName();
        return new Berserker(name);
    }

    public Healer CreateHealer(){
        String name = getName();
        return new Healer(name);
    }

    public Tank CreateTank(){
        String name = getName();
        return new Tank(name);
    }

    public Terminator CreateTerminator(){
        String name = getName();
        return new Terminator(name);
    }

    private String getName(){
        System.out.print("Name of droid: ");
        String name = in.nextLine();
        return name;
    }
}

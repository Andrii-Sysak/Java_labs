package BattleArena;
import Droids.BaseDroid;
import Droids.Healer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TeamBattle {
    private String attackName;
    private ArrayList<BaseDroid> attackers;
    private String defendName;
    private ArrayList<BaseDroid> defenders;

    public TeamBattle(String teamName1, String teamName2, ArrayList<BaseDroid> team1, ArrayList<BaseDroid> team2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.attackers = team1;
            attackName = teamName1;
            this.defenders = team2;
            defendName = teamName2;
        } else {
            this.attackers = team2;
            attackName = teamName2;
            this.defenders = team1;
            defendName = teamName1;
        }
    }

    public String teamVsTeam() {
        while (attackers.size() != 0) {
            fighting();
            swap();
        }
        swap();
        return attackName + " - Win\n" + defendName + " - Lose";
    }

    private void fighting() {
        Random random = new Random();
        BaseDroid attacker = attackers.get(random.nextInt(attackers.size()));
        BaseDroid defender;
        if(attacker instanceof Healer){
            if(random.nextBoolean()) {
                defender = defenders.get(random.nextInt(defenders.size()));
                attacker.attack(defender);
                return;
            }
            defender = attackers.get(random.nextInt(attackers.size()));
            ((Healer) attacker).getHeal(defender);
            return;
        }
        defender = defenders.get(random.nextInt(defenders.size()));
        attacker.attack(defender);
        defenders.removeIf(droid -> !droid.isAlive());
    }

    private void swap() {
        ArrayList<BaseDroid> t = attackers;
        attackers = defenders;
        defenders = t;
        String tStr = attackName;
        attackName = defendName;
        defendName = tStr;
    }

    public List<BaseDroid> getAttackers() {
        return attackers;
    }

    public List<BaseDroid> getDefenders() {
        return defenders;
    }
}

package BattleArena;

import Droids.BaseDroid;

import java.util.Random;

public class SingleBattle {
    private BaseDroid attacker;
    private BaseDroid defender;



    public SingleBattle(BaseDroid droid1, BaseDroid droid2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.attacker = droid1;
            this.defender = droid2;
            return;
        }
        this.attacker = droid2;
        this.defender = droid1;
    }

    public String droidVsDroid() {
        while (attacker.isAlive()) {
            attacker.attack(defender);
            swap();
        }
        swap();
        return this.attacker.getName() + " - Win\n" + this.defender.getName() + " - Lose";
    }

    private void swap() {
        BaseDroid tmp = attacker;
        attacker = defender;
        defender = tmp;
    }
}

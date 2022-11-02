package Droids;

import java.util.Random;

public class Terminator extends BaseDroid{
    private static final int health = 4000;
    private static final int baseDamage = 1500;

    public Terminator(String name) {
        super(name,health,baseDamage);
    }

    @Override
    public void getHit(int hit){
        this.cur_health -= hit;
        Random random = new Random();
        if(cur_health <= 0){
            int chance = random.nextInt(10);
            if(chance >= 5)
                cur_health = 1;
        }
    }

    public String getType(){
        return "Terminator";
    }
}

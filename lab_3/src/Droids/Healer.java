package Droids;

import java.util.Random;

public class Healer extends BaseDroid{
    private static final int health = 4000;
    private static final int baseDamage = 500;
    private static final int healMaxPoint = 200;

    public Healer(String name){
        super(name, health, baseDamage);
    }



    public void getHeal(BaseDroid teammate){
        Random random = new Random();
        int healPoint = random.nextInt(healMaxPoint);

        if(this.equals(teammate)){
            System.out.println(this.name + " healed himself by " + healPoint + " health points");
            return;
        }

        if(teammate.max_Health - teammate.cur_health < healPoint)
            healPoint = teammate.max_Health - teammate.cur_health;
        teammate.cur_health += healPoint;

        System.out.println(this.name + " healed " + teammate.name + " by " + healPoint + " health points");
    }

    public String getType(){
        return "Healer";
    }


}

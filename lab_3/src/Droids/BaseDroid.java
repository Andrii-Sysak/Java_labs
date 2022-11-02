package Droids;

import java.util.Random;

public class BaseDroid {
    protected String name;
    protected int max_Health = 2000;
    protected int cur_health;

    protected int damage = 400;
    protected String type;

    public String getName() {
        return name;
    }

    public BaseDroid(String name){
        this.name = name;
        this.cur_health = max_Health;
        this.type = "Classic";
    }


    public BaseDroid(String name, int max_Health, int damage) {
        this.name = name;
        this.max_Health = max_Health;
        this.cur_health = max_Health;
        this.damage = damage;
        this.type = "Classic";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_Health() {
        return max_Health;
    }

    public void setMax_Health(int max_Health) {
        this.max_Health = max_Health;
    }

    public int getCur_health() {
        return cur_health;
    }

    public void setCur_health(int cur_health) {
        this.cur_health = cur_health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAlive() {
        return this.cur_health >0;
    }

    @Override
    public String toString() {
        return "" +
                "Name= '" + name + '\'' +
                ", Max health=" + max_Health +
                ", Current health= " + cur_health +
                ", Damage= " + damage;
    }

    public void attack(BaseDroid droiddef){
        Random random = new Random();
        int currentDamage = random.nextInt(this.damage) + 1;
        droiddef.getHit(currentDamage);
        System.out.println(this.name + " attacked " + droiddef.name + " and provide " + currentDamage + " damage");
        if(droiddef.cur_health <= 0){
            droiddef.cur_health = 0;
            System.out.println("OH NO!!! " + droiddef.name + " was defeated by " + this.name);
            System.out.println("""
                    (►.◄)︻デ═一 ────────────────────٩̶(̶×̶̶̯×̶)̶۶──
                    """);
        }
    }

    public void getHit(int hit){
        this.cur_health -= hit;
    }
}

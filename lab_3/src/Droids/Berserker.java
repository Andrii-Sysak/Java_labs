package Droids;

public class Berserker extends BaseDroid{
    private static final int health = 3000;
    private static final int baseDamage = 1200;

    public Berserker(String name) {
        super(name,health,baseDamage);
    }

    @Override
    public void getHit(int hit){
        this.cur_health -= hit;
        this.damage += hit;
    }
    public String getType(){
        return "Berserker";
    }
}

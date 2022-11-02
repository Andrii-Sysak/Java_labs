package Droids;

public class Tank extends BaseDroid{
    public static final float resistance = 0.5f;
    public static final int health = 8000;
    public static final int damage = 600;

    public Tank(String name) {
        super(name,health,damage);
    }

    @Override
    public void getHit(int hit){
        this.cur_health -= hit * resistance;
    }

    public String getType(){
        return "Tank";
    }
}

package jp.ac.uryukyu.ie.e165712;

public class Hero extends LivingThing {
    int hitPoint;
    String name;
    boolean dead;

    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        this.hitPoint = super.getHitPoint();
        this.name = super.getName();
        this.dead = super.getDead();
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            setDead(dead);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}

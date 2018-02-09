package jp.ac.uryukyu.ie.e165712;

public class Enemy extends LivingThing{
    int hitPoint;
    String name;
    boolean dead;

    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        this.hitPoint = super.getHitPoint();
        this.name = super.getName();
        this.dead = super.isDead();
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            super.setDead(true);
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}
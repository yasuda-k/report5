package jp.ac.uryukyu.ie.e165712;

public class Enemy extends LivingThing{
    int hitPoint;
    String name;
    boolean dead;
    int attack;

    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        this.hitPoint = super.getHitPoint();
        this.name = super.getName();
        this.dead = super.isDead();
        this.attack = super.getAttack();
    }

    public void attack(LivingThing opponent) {
        if (isDead() == false) { //report3の時の修正
            int damage = (int) (Math.random() * attack);

            if  (damage != 0) {
                if ((int) (Math.random() * 100) <= 30) {
                    damage *= 2;
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
                }
            }else {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", name, opponent.getName());
            }
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            setDead(true);
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}
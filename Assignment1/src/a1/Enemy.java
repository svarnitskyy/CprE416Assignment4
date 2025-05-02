package a1;

public class Enemy extends Character implements Attackable {

//    + Initialized at compile time
    private static final int ATTACK_COST = 1;
    private static final int ATTACK_DAMAGE = 8;

    public Enemy(String name, int health, int stamina) {
        super(name, health, stamina);
    }

    // Overriding attack
    @Override
    public void attack(Character target) {
        // + Extracted logic
        if (!canEnemyAttack()) return;

        System.out.println(name + " (the enemy) swipes at " + target.getName() + "!");
        target.takeDamage(ATTACK_DAMAGE); // Enemy deals 8 damage
//        + Extracted logic
        reduceStamina();
    }

    private boolean canEnemyAttack(){
        if (stamina < ATTACK_COST) {
            System.out.println(name + " is too exhausted to attack!");
            return false;
        }
        return true;
    }

    private void reduceStamina() {
        stamina -= ATTACK_COST;
    }
}

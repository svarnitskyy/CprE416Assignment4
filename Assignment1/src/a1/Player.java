package a1;

public class Player extends Character implements Attackable {

    //    + Initialized at compile time
    private static final int ATTACK_COST = 2;
    private static final int ATTACK_DAMAGE = 10;
    private static final int ITEM_HEAL_AMOUNT = 5;


    public Player(String name, int health, int stamina) {
        super(name, health, stamina);
    }

    @Override
    public void attack(Character target) {
//        + Extracted logic
        if (!canPlayerAttack()) return;

        System.out.println(name + " strikes " + target.getName() + " with a sword!");
        target.takeDamage(ATTACK_DAMAGE);   // Player deals 10 damage

        reduceStamina();           // Attack costs 2 stamina
    }

    public void useItem() {
        System.out.println(name + " uses a generic item. (No effect in this demo.)");
    }

    public void useItem(String itemName) {
        System.out.println(name + " uses the special item: " + itemName + "!");
        // For demonstration, let’s say it restores a bit of health
        health += ITEM_HEAL_AMOUNT;
        System.out.println(name + " feels slightly better! Health is now " + health + ".");
    }

    private boolean canPlayerAttack(){
        if (stamina < ATTACK_COST) {
            System.out.println(name + " is too tired to attack!");
            return false;
        }
        return true;
    }

    private void reduceStamina() {
        stamina -= ATTACK_COST;
    }
}

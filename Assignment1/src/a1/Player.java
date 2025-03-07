package a1;

public class Player extends Character implements Attackable {

    public Player(String name, int health, int stamina) {
        super(name, health, stamina);
    }

    @Override
    public void attack(Character target) {
        if (stamina < 2) {
            System.out.println(name + " is too tired to attack!");
            return;
        }
        System.out.println(name + " strikes " + target.getName() + " with a sword!");
        target.takeDamage(10);   // Player deals 10 damage
        stamina -= 2;           // Attack costs 2 stamina
    }

    public void useItem() {
        System.out.println(name + " uses a generic item. (No effect in this demo.)");
    }

    public void useItem(String itemName) {
        System.out.println(name + " uses the special item: " + itemName + "!");
        // For demonstration, let’s say it restores a bit of health
        health += 5;
        System.out.println(name + " feels slightly better! Health is now " + health + ".");
    }
}

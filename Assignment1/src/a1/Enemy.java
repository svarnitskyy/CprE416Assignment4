package a1;

public class Enemy extends Character implements Attackable {

    public Enemy(String name, int health, int stamina) {
        super(name, health, stamina);
    }

    // Overriding attack
    @Override
    public void attack(Character target) {
        if (stamina < 1) {
            System.out.println(name + " is too exhausted to attack!");
            return;
        }
        System.out.println(name + " (the enemy) swipes at " + target.getName() + "!");
        target.takeDamage(8); // Enemy deals 8 damage
        stamina -= 1;         // Attack costs 1 stamina
    }
}

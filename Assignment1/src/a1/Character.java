package a1;

public abstract class Character implements Attackable {
    protected String name;
    protected int health;
    protected int stamina;

    public Character(String name, int health, int stamina) {
        this.name = name;
        this.health = health;
        this.stamina = stamina;
    }

    // Abstract method (must be overridden by subclasses).
    public abstract void attack(Character target);

    // Concrete method (subclasses can override if they want).
    public void run(int distance) {
        System.out.println(name + " runs " + distance + " meters!");
        // Example of DATA COUPLING: pass a primitive distance to consumeStamina().
        consumeStamina(distance);
    }

    private void consumeStamina(int distance) {
        // Each 10m costs 1 stamina for simplicity
        int staminaCost = distance / 10;
        stamina -= staminaCost;
        if (stamina < 0) stamina = 0;
        System.out.println(name + " now has " + stamina + " stamina.");
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) health = 0;
        System.out.println(name + " takes " + dmg + " damage. Health is now " + health + ".");
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void showStatus() {
        System.out.println("[" + name + "] Health: " + health + " | Stamina: " + stamina);
    }

    public String getName() {
        return name;
    }
}
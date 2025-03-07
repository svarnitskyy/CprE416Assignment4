package a1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Player and Enemy
        Player hero = new Player("Hero", 30, 10);
        Enemy goblin = new Enemy("Goblin", 25, 10);

        // Put them in a list for stamp coupling demonstration
        List<Character> participants = new ArrayList<>();
        participants.add(hero);
        participants.add(goblin);

        GameEngine engine = new GameEngine();
        engine.showAllCharacters(participants); // stamp coupling call

        System.out.println("\nBattle start!");
        while (!hero.isDead() && !goblin.isDead()) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Use Item");
            System.out.println("3. Run");
            System.out.print("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // Attack
                    hero.attack(goblin);
                    break;
                case "2": // Use Item
                    System.out.println("Use generic item or named item?");
                    System.out.println("1. Generic item");
                    System.out.println("2. Named item");
                    System.out.print("> ");
                    String itemChoice = scanner.nextLine();
                    if (itemChoice.equals("1")) {
                        hero.useItem();
                    } else {
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        hero.useItem(itemName); // Overloaded method
                    }
                    break;
                case "3": // Run
                    hero.run(30); // Example: run 30 meters
                    break;
                default:
                    System.out.println("Invalid choice! Skip turn.");
                    break;
            }

            // Enemy turn (only if still alive)
            if (!goblin.isDead()) {
                goblin.attack(hero);
            }

            // Show statuses
            engine.showAllCharacters(participants);
        }

        // Result
        if (hero.isDead()) {
            System.out.println("\nYour hero has fallen... Game Over!");
        } else {
            System.out.println("\nYou defeated the " + goblin.getName() + "!");
        }

        scanner.close();
    }
}
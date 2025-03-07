package a1;

import java.util.List;

public class GameEngine {

    public void showAllCharacters(List<Character> characters) {
        System.out.println("\n*** Party/Enemy Info ***");
        for (Character c : characters) {
            c.showStatus();
        }
    }
}
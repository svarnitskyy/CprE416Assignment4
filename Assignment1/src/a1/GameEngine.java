package a1;

public class GameEngine {
// + Updated to use array instead of list
    public void showAllCharacters(Character[] characters) {
        System.out.println("\n*** Party/Enemy Info ***");
        for (Character c : characters) {
            c.showStatus();
        }
    }
}
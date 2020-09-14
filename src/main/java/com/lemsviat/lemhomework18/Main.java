package main.java.com.lemsviat.lemhomework18;

public class Main {
    public static void main(String[] args) {
        UserConsole userConsole = new UserConsole();

        while (!userConsole.isQuit()) {
            userConsole.renderRepositoryMenu();
            userConsole.readUserInput();
            userConsole.handleRepositoryMenuUserInput();
        }
    }
}
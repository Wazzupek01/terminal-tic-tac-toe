import java.util.Scanner;

public class Player {
    private final String playerName;
    private final char sign;

    public Player(char sign) {
        this.sign = sign;
        System.out.print("Choose the name for \"" + sign +"\": ");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine();
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getSign() {
        return sign;
    }
}

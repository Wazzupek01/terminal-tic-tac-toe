import java.util.Scanner;

public class Game {
    private final Board gameBoard;
    private final Player[] players = new Player[2];
    private int activePlayerId = 1;

    public Game() {
        this.gameBoard = new Board();
        players[0] = new Player('x');
        players[1] = new Player('o');
    }

    public void makeMove(Player activePlayer) {
        Scanner s = new Scanner(System.in);
        System.out.print("Choose number of field[0-9]: ");
        int fieldNumber = s.nextInt();
        if (!gameBoard.setField(fieldNumber, activePlayer)) {
            System.out.println("This field is not empty!");
            System.out.print("Choose number of field[0-9]: ");
            fieldNumber = s.nextInt();
            gameBoard.setField(fieldNumber, activePlayer);
        }
    }

    public void play() {
        boolean end = false;
        while (!end) {
            if (activePlayerId == 0) activePlayerId = 1;
            else activePlayerId = 0;
            gameBoard.drawBoard();
            System.out.println(players[activePlayerId].getPlayerName() + " move:");
            makeMove(players[activePlayerId]);
            end = isEnd(players[activePlayerId]);
        }
        gameBoard.drawBoard();
        System.out.println(players[activePlayerId].getPlayerName() + " won!");
    }

    public boolean isEnd(Player activePlayer) {

        for (int i = 0; i < 3; i++) {
            if (activePlayer.getSign() == gameBoard.getField(i).getValue()
                    && activePlayer.getSign() == gameBoard.getField(i + 3).getValue()
                    && activePlayer.getSign() == gameBoard.getField(i + 6).getValue())
                return true;
        }

        for (int i = 0; i < 7; i += 3) {
            if (activePlayer.getSign() == gameBoard.getField(i).getValue()
                    && activePlayer.getSign() == gameBoard.getField(i + 1).getValue()
                    && activePlayer.getSign() == gameBoard.getField(i + 2).getValue())
                return true;
        }

        if (activePlayer.getSign() == gameBoard.getField(0).getValue()
                && activePlayer.getSign() == gameBoard.getField(4).getValue()
                && activePlayer.getSign() == gameBoard.getField(8).getValue())
            return true;

        if (activePlayer.getSign() == gameBoard.getField(2).getValue()
                && activePlayer.getSign() == gameBoard.getField(4).getValue()
                && activePlayer.getSign() == gameBoard.getField(6).getValue())
            return true;
        return false;
    }
}

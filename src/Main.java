import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean playAgain = true;
        while(playAgain){
            Game game = new Game();
            game.play();
            System.out.print("Do you want to play again?(y/n): ");
            Scanner s = new Scanner(System.in);
            if(s.nextLine().equals("n")) {
                playAgain = false;
            }
        }
    }
}

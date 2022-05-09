import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        // Get random word
        RandomWord word = new RandomWord();

        // set up board
        Board board = new Board(word);
        System.out.print("TEST REMOVE: " + board.randomWord.word);
        System.out.print("\n5 Letter words only\n");
        String user_input = "";

        do {
            Scanner get_user_input;
            user_input = "";
            while (user_input.length() != 5){
                System.out.print("Attempt " + board.attempts + " Please enter your guess: ");
                get_user_input = new Scanner(System.in);
                user_input = get_user_input.nextLine();
            }
            board.Update_Board(user_input);
        } while(board.attempts != 6 && board.Get_Finished() == 0);

        if (board.Get_Finished() == 1){
            System.out.print("Congratulations, you have guessed correctly! \n");
        } else {
            System.out.print("Your attempts are up. You were close. \n");
        }
        System.out.print("The correct word was " + board.randomWord.word);
    }
}

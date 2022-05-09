import java.io.FileNotFoundException;

public class Board {

    RandomWord randomWord;
    String[] board;
    int attempts = 0;
    int finished = 0;


    public Board(RandomWord randomWord) throws FileNotFoundException {

        this.randomWord = randomWord;
        // Create board with x x x x x --> 5 x 6
        this.Print_Board();
    }

    // set up the board and print board:
    public void Print_Board(){
        if (this.board == null){
            this.board = new String[]{"x x x x x", "x x x x x", "x x x x x", "x x x x x", "x x x x x", "x x x x x"};
        }
        for(int i = 0; i < board.length; i++){
            System.out.print(this.board[i]);
            System.out.print("\n");
        }

        System.out.print("\nUsed Letters That Was Missed: " + randomWord.get_User_used_letters() + "\n\n");
    }



    public int Get_Finished(){
        return this.finished;
    }

    // update board:
    public void Update_Board(String word){
        this.board[attempts] = randomWord.Letter_Check(word);
        Print_Board();
        attempts++;
        if (word.equals(this.randomWord.word)){
            this.finished = 1;
        }
    }

    // Show alphabet

}

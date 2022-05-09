import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomWord {
    String word;
    String[] guess_words;
    String user_used_letters = "";

    public RandomWord() throws FileNotFoundException {
        String[] word_list = five_letter_words();
        int random_number_selected = random_number();
        this.word = word_list[random_number_selected];
    }

    public String[] five_letter_words() throws FileNotFoundException {
        File file = new File("/Users/gilberthopkins/Documents/programs/Java_Example/Wordle/src/word_list");
        Scanner scan = new Scanner(file);

        String[] list = new String[505];
        int count = 0;
        while (scan.hasNextLine()) {
            list[count] = scan.nextLine();
            count++;
        }
        return list;
    }

    public static int random_number(){
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt(0, 500);
//        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int Game_Over_Check(String user_guess){
        if (this.word == user_guess){
            return 1;
        } else {
            this.Letter_Check(user_guess);
            return 0;
        }
    }


    public String Letter_Check(String user_guess){
        String user_results = "";
        Boolean hit = false;
        for (int i = 0; i < this.word.length(); i++){
            for (int k = 0; k < user_guess.length(); k++){
                if (user_guess.charAt(i) == this.word.charAt(k)){
                    if (i == k){
                        user_results += Color_Print("green", user_guess.charAt(i));
                    } else {
                        user_results += Color_Print("yellow", user_guess.charAt(i));
                    }
                    hit = true;
                    break;
                }
            }
            if (hit){
                hit = false;
            } else {
                user_results += user_guess.charAt(i) + " "; // show on board in gray
                this.user_used_letters += user_guess.charAt(i) + " "; // board shows missed uses letters
            }
        }
        return user_results;
    }


    public String get_User_used_letters() {
        return user_used_letters;
    }

    // color code correct and misplaced characters
    public String Color_Print(String color_type, char message){
        switch (color_type) {
            case "yellow":
                return "\u001B[33m" + message + "\u001B[0m ";
            case "green":
                return "\u001B[32m" + message + "\u001B[0m ";
            default:
                return "\u001B[0m "; // reset
        }
    }



}

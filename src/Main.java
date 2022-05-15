import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.println("Welcome to Hangman");


        File dictionary = new File(""); //put your path in here from the english3.txt file

        Scanner scanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        int lives = 6;

        ArrayList<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine() );
        }

        String guess = words.get((int)(Math.random() * words.size()));
        char[] textArray = guess.toCharArray();

        char[] myAnswer = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswer[i] = '?';
        }

        boolean finish = false;

        while (finish == false) {
            System.out.println("**************************");

            String letter = input.next();

            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Not a valid input || try again");
                letter = input.next();
            }

            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswer[i] = textArray[i];
                    found = true;
                }
            }

            if (!found) {
                lives--;

                System.out.println("This letter is not in the word");
            }

            boolean done = true;
            for (int i = 0; i < myAnswer.length; i++) {
                if (myAnswer[i] == '?') {
                    System.out.print(" _");
                    done = false;
                } else {
                    System.out.print(" " + myAnswer[i]);
                }
            }

            System.out.println("\n" + "Lives left " + lives);
            drawHangman(lives);

            if (done) {
                System.out.println("You won congrats :D");
                finish = true;
            }

            if (lives <= 0) {
                System.out.println("You lost D:");
                System.out.printf("The word was: %s", guess);
                finish = true;
            }
        }
    }
    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}

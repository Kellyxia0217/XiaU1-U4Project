import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    private static int Guesses = 8;
    private static String lists;
    private static String letter;
    private static String W = "";


    static List<String> chars = new ArrayList<>();
    static String[] words = {"watermelon", "computer", "headphones", "window", "elephant"};
    private static String word = words[(int) (Math.random() * words.length)];




public static void SetW() {
    for (int j = 0; j < word.length(); j++) {
        W += "_";
        System.out.print("_");
    }
}
    public static void Checker(String letter) {


        if (chars.contains(letter)) {
            System.out.println("You have already guessed that letter! \n use a different one.");
        }
        else if (word.contains(letter)) {
                System.out.println(letter + " is present in the word");
            }

        else if (!word.contains(letter)) {
                Guesses--;
                System.out.println(letter + " is not present in the word");
                System.out.println("you have " + Guesses + " guesses remaining");
                 chars.add(letter);


        }


    }

    public static void play() {
        Scanner input = new Scanner(System.in);
        Hangman.SetW();
        while (Guesses > 0 && W.contains("_")) {
            System.out.println();
            System.out.print("------------- \n Your Guess: \n Input: "  );
            String first = input.nextLine();
            if (first.length() != 1) {
                System.out.print("sorry, you can only guess one letter words.");
                break;
            }
            Hangman.Checker(first);
            Hangman.revealword(first);
            if (Guesses == 0) {
                System.out.println("You have failed \n Here are the letters that you have guessed: ");
                System.out.println(chars);
            } else if (W.indexOf("_") == -1 ) {
                System.out.println("Congrats! \n You have won.");
                System.out.println("The word is: " + word);
            }
        }

    }
public static void revealword(String letter) {
        if (word.contains(letter)) {
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i ,i+1).equals(letter)) {
                    W = W.substring(0,i) + letter + W.substring(i+1);

                }

            }

        }
    System.out.println(W);
    }
 public static void guessIt() {
    Scanner input = new Scanner(System.in);
    System.out.println("Do you think you can guess the entire word?(Answer yes or no) ");
    if (input.nextLine().equals("yes")) {
        System.out.println("Answer your guess: ");
        String word1 = input.nextLine();
        if (word1.equals(word)){
            W.replace(W,word);
        } else {
            Guesses --;
        }
    }

 }
}





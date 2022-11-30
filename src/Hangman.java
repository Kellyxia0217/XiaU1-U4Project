import java.util.Scanner;

public class Hangman {
    private static int Guesses = 8;
    private static String lists;
    static String[] words = {"watermelon", "computer", "headphones", "window", "elephant"};
    private static String word = words[(int) (Math.random() * words.length)];



    public static void Checker(String letter) {
       lists = "";
       if (word.contains(letter)) {
           System.out.println(letter + " is present in the word");
       }
        else if (lists.contains(letter)) {
            System.out.println("You have already guessed that letter! \n use a different one.");
        }
        else if (!word.contains(letter)) {
                Guesses--;
                System.out.println(letter + " is not present in the word");
                System.out.println("you have " + Guesses + " guesses remaining");
                 lists += letter;

        }

    }

    public static void play() {
        Scanner input = new Scanner(System.in);
        while (Guesses > 0) {
            System.out.println("-------------");
            System.out.println("Your Guess:");
            System.out.print("Input: ");
            String first = input.nextLine();
            Hangman.Checker(first);
            if (Guesses == 0) {
                System.out.println("You have failed");
                System.out.println("Here are the letters that you have guessed");
                System.out.println(lists);
            }
        }

    }





}
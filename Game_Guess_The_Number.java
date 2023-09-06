import java.io.FileWriter;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class guess {
    void number() {
        try {
            Scanner sc = new Scanner(System.in);
            Random num = new Random();
            FileWriter fw = new FileWriter("guessTheNumber.txt");
            int number = num.nextInt(100);
            System.out.println("********** Game: Guessing the Number **********");
            Calendar cal = Calendar.getInstance();
            System.out.println(cal.getTime());
            int guess, numberOfGuesses = 1;
            do {
                System.out.print("Guess the number between 1 to 100: ");
                guess = sc.nextInt();
                if (guess > number) {
                    System.out.println("Lower number please!");
                } else if (guess < number) {
                    System.out.println("Higher number please!");
                } else {
                    System.out.println("You guessed it in " + numberOfGuesses + " attempts");
                }
                numberOfGuesses++;
            } while (guess != number);
            int fwScore = numberOfGuesses - 1;
            fw.write("High Score --> " + fwScore + " \ni.e., you guessed the computer generated number in " + fwScore + " attempts");
            System.out.println("The computer generated number was: " + number);
            fw.close();
        } catch (InputMismatchException ex) {
            System.out.println("You have given a wrong input.\nError --> " + ex);
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        }
    }
}

public class Game_Guess_The_Number {
    public static void main(String[] args) {
        try {
            guess g = new guess();
            g.number();
            System.out.println("Open guessTheNumber.txt to see score");
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        } finally {
            System.out.println("\n********** Thank you for playing **********");
        }
    }
}

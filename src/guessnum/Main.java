package guessnum;

import java.util.Random;
import java.util.Scanner;


public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);

        boolean userLost = true;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Try #" + i);
            int userNum = scan.nextInt();

            if (myNum < userNum) {
                System.out.println("my number is less then yours");
            } else if (myNum > userNum) {
                System.out.println("my number is greater then yours");
            } else {
                System.out.println("Yeeeh! You won!");
                userLost = false;
                break;
            }
        }
        if (userLost) {
            System.out.println("You lost, my friend!");
        }
    }
}

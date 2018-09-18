package guessnum;

import java.util.*;


public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();

    public static void main(String[] args) {
        String answer;
        do {
            System.out.println("What is your name?");
            String name = scan.next();

            int myNum = rand.nextInt(100) + 1;
            System.out.println(myNum);

            long t1 = System.currentTimeMillis();

            boolean userLost = true;
            for (int i = 1; i <= 10; i++) {
                System.out.println("Try #" + i);
                int userNum = askNum();

                if (myNum < userNum) {
                    System.out.println("my number is less then yours");
                } else if (myNum > userNum) {
                    System.out.println("my number is greater then yours");
                } else {
                    long t2 = System.currentTimeMillis();
                    System.out.println("Yeeeh! You won!");
                    userLost = false;
                    GameResult r = new GameResult();
                    r.name = name;
                    r.triesCount = i;
                    r.time = t2 - t1;
                    results.add(r);
                    break;
                }
            }
            if (userLost) {
                System.out.println("You lost, my friend!");
            }
            System.out.println("Do you want to play again? (y/n)");
            answer = askYN();
        } while (answer.equals("y"));

        showResults();

        System.out.println("Good bye!");
    }

    private static void showResults() {
        for (GameResult r : results) {
            System.out.println(r.name + " ----- " + r.triesCount + " ----- " + (r.time / 1000) + "sec");
        }
    }

    static String askYN() {
        String answer;
        do {
            answer = scan.next();
            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("You can enter only 'y' or 'n'!");
            } else {
                return answer;
            }
        } while (true);
    }

    static int askNum() {
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("This isn't a number!");
                scan.next();
                continue;
            }
            if (answer < 1 || answer > 100) {
                System.out.println("Please enter a number between 1 and 100");
            } else {
                return answer;
            }
        } while (true);
    }


}

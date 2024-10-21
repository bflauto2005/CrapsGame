import java.util.Random;
import java.util.Scanner;

public class CrapsGame
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuePlay = true;

        System.out.println("Welcome to the Craps Game!");

        while(continuePlay)
        {
            int dice1 = rollDie(random);
            int dice2 = rollDie(random);
            int sum = dice1 + dice2;

            System.out.println("Initial roll: Die 1 = " + dice1 + ", Die 2 = " + dice2 + ", Sum = " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Craps! You crapped out, you lose!");
            }
            else if (sum == 7 || sum == 11)
            {
                System.out.println("Natural, you win!");
            }
            else {
                int point = sum;

                System.out.println("Point is now: " + point);

                boolean continueRoll = true;
                while(continueRoll)
                {
                    dice1 = rollDie(random);
                    dice2 = rollDie(random);
                    sum = dice1 + dice2;

                    System.out.println("Trying for point: Die 1 = " + dice1 + ", Die 2 = " + dice2 + ", Sum = " + sum);

                    if (sum == point)
                    {
                        System.out.println("Made point! You win!");
                        continueRoll = false;
                    } else if (sum == 7)
                    {
                        System.out.println("Rolled a 7, you lose!");
                        continueRoll = false;
                    }
                }
            }
            System.out.println("Do you want to play again? (Y/N): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y"))
            {
                continuePlay = false;
            }


        }

        System.out.println("Thanks for playing!");
    }
    private static int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }


}
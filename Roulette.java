package rouletteCasino;

/**
 * A Roulette game which lets you pick the odds of playing the roulette game
 * uses a random generator and conditional flow based on decision and luck 
 * 
 * and consoles output the results
 * 
 * @version 1.0
 * 
 *@author Aaron
 */
import java.util.Random;
import java.util.Scanner;

public class Roulette {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random generator = new Random();
		String name;
		int win = 0, lose = 0, spin = 0, choice;
		double amount;
		int number;
		int rouletteNum;
		int result;
		double total = 500;
		char response = 'y';
		int resultArr[] = new int[36];

		System.out.println("Please enter your Name :");
		name = sc.nextLine();

		while (response == 'y' || response == 'Y' && total <= 0) {
			System.out.print("Enter your bet amount: ");
			amount = sc.nextDouble();
			System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
			choice = -1;
			while (choice < 0 || choice > 2) {
				System.out.print("Place your bet on: ");
				choice = sc.nextInt();
			}
			
			
			number = 0;
			if (choice == 2) {
				while (number < 1 || number > 36) {
					System.out.print("Place your bet on number(1-36): ");
					number = sc.nextInt();
				}
			}
			rouletteNum = generator.nextInt(37);
			spin++;
			System.out.println("Roulette number: " + rouletteNum);

			if (choice == 2) {
				if (rouletteNum == number)
					result = 35;
				else
					result = 0;
			} else {
				if (rouletteNum == 0 || rouletteNum % 2 != choice)
					result = 0;
				else
					result = 1;
			}

			// Print out game result, win/lose amount
			if (result > 0) {
				System.out.println("Congratulatons!!! You win!");
				System.out.printf("You have won R%.2f \n", result * amount);
				System.out.printf("Here's your money back: R%.2f \n", (result + 1) * amount);
				total = (result + 1) * amount + total;
				win++;
				resultArr[rouletteNum]++;

			} else {
				System.out.println("You lose. Better luck next time!");
				System.out.printf("You have lost R%.2f \n", (result + 1) * amount);
				total = total - (result + 1) * (amount);
				lose++;
				resultArr[rouletteNum]++;

				if (total <= 0) {
					break;
				}

			}

			// Ask for another game
			for (int totals = 1; totals < 36; totals++) {
				if (resultArr[totals] > 0) {
					System.out.println("The number " + totals + " won " + resultArr[totals] + " times.");
				}
			}

			System.out.println("You have R" + total + " remaining.");
			System.out.println("You have won " + win + " games.");
			System.out.println("You have lost " + lose + " games.");
			System.out.println("The wheel has been spun " + spin + " times.");
			System.out.print("\nWould you like to play another game? (y/n) ");
			response = sc.next().charAt(0);

		}

	}
}
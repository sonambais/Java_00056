package basic_code;

import java.util.Scanner;

public class Exception55 {
	private static String accountHolder = "Sonam";
	private static double balance = 5000.089;

	public static void deposit(Scanner sc) {
		try {
			System.out.print("Enter deposit amount: ");
			double amount = Double.parseDouble(sc.nextLine());
			if (amount <= 0) {
				throw new IllegalArgumentException("Deposit amount must be positive.");
			}
			balance = balance + amount;

			System.out.println("Deposit successful!");
			System.out.println("Deposited Amount: " + amount);
			System.out.println("Updated Balance: " + balance);
		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter a valid numeric amount.");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());

		} finally {
			System.out.println("Deposit operation completed.");

		}

	}

	public static void withdraw(Scanner sc) {
		try {
			System.out.print("Enter withdrawal amount: ");
			double amount = Double.parseDouble(sc.nextLine());
			if (amount <= 0) {
				throw new IllegalArgumentException("Withdrawal  amount must be positive.");
			}
			if (amount > balance) {
				throw new ArithmeticException("Insufficient balance.");

			}
			balance = balance - amount;
			System.out.println("Withdrawal successful!");
			System.out.println("Withdrawn Amount: " + amount);
			System.out.println("Remaining Balance: " + balance);
		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter a valid numeric amount.");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());

		} catch (ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out.println("Withdrawal operation completed.");
		}
	}

	public static void checkBalance() {
		try {
			System.out.println("Account Holder: " + accountHolder);
			System.out.println("Available Balance: " + balance);
		} catch (Exception e) {
			System.out.println("Unable to check balance.");
		} finally {
			System.out.println("Balance check completed.");
		}
	}

	public static void divideAmount(Scanner sc) {
		try {
			System.out.print("Enter an amount: ");
			double amount = Double.parseDouble(sc.nextLine());
			System.out.print("Enter divisor: ");
			int divisor = Integer.parseInt(sc.nextLine());
			if (divisor == 0) {
				throw new ArithmeticException("Division by zero is not allowed.");
			}
			double result = amount / divisor;
			System.out.println("Result: " + result);
		} catch (NumberFormatException e) {

			System.out.println("Error: Please enter valid numeric values.");

		} catch (ArithmeticException e) {

			System.out.println("Error: " + e.getMessage());

		} finally {

			System.out.println("Division operation completed.");
		}
	}

	public static void main(String[] args) {
		System.out.println("================================");
		System.out.println("     BANKING MANAGEMENT SYSTEM");
		System.out.println("================================");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Account Holder: " + accountHolder);
			System.out.println("Opening Balance: " + balance);
			boolean running = true;
			while (running) {
				System.out.println("\n1. Deposit Money");
				System.out.println("2. Withdraw Money");
				System.out.println("3. Check Balance");
				System.out.println("4. Divide Amount");
				System.out.println("5. Exit");

				System.out.print("Enter your choice: ");
			}

			try {
				// unboxing
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					deposit(sc);
					break;
				case 2:
					withdraw(sc);
					break;

				case 3:
					checkBalance();
					break;

				case 4:
					divideAmount(sc);
					break;

				case 5:
					running = false;
					System.out.println("Thank you!");
					break;

				default:
					System.out.println("Invalid choice. Enter 1 to 5.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Please enter a valid number.");
			} finally {
				System.out.println("Menu operation completed...");
			}

		}

		catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		} finally {
			sc.close();
			System.out.println("Application closed...");
		}

	}

}

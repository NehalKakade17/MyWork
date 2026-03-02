package assign.pending;
import java.util.Scanner;
class BankAccount{
	static Scanner sc = new Scanner(System.in);
	protected double balance;
	BankAccount(){
		this.balance = 0.0;
	}
	public void deposit() {
		System.out.println("Enter amount to deposit: ");
		double new_amm = sc.nextDouble();
		this.balance += new_amm;
	}
	public void withdraw() {
		System.out.println("Enter amount to withdraw: ");
		double wit_amm = sc.nextDouble();
		if(wit_amm>this.balance) {
			System.out.println("Maximum Limit Reach!");
		}
		else {
			this.balance -= wit_amm;
			System.out.println("Withdrawn: "+wit_amm);
		}
	}
	public void displayRecord() {
		System.out.println("Your balance is: "+this.balance);
	}
	public int menuList() {
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Print Record");
		System.out.println("4.Exit");
		System.out.print("Enter your choice: ");
		 return sc.nextInt();
	}
}
class SavingsAccount extends BankAccount{
	public void withdraw() {
		System.out.println("Enter amount to withdraw: ");
		double wit_amm = sc.nextDouble();
		double max_limit = 5000.00;
		if (wit_amm > this.balance) {
            System.out.println("Insufficient Balance!");
        } else if (wit_amm > max_limit) {
            System.out.println("Withdrawal exceeds maximum limit of " + max_limit);
        } else {
            this.balance -= wit_amm;
        }
	}
}

public class Program {

	public static void main(String[] args) {
		BankAccount b = new SavingsAccount();
		int choice;
		do {
			choice = b.menuList();
			switch(choice) {
			case 1:
				b.deposit();
				break;
			case 2:
				b.withdraw();
				break;
			case 3:
				b.displayRecord();
				break;
			case 4: 
				System.out.println("EXIT");
				BankAccount.sc.close();
				return;
			default:
				System.out.println("Invalid choice");
			
			}
		}while (choice != 4);
		BankAccount.sc.close();
	}

}

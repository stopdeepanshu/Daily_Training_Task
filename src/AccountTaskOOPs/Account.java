package AccountTaskOOPs;

public abstract class Account {

	long accountNum;
	int balance=65000;
	
	public abstract void withdraw(int a);
	public abstract void deposit(int b);
	public void currentBalance() {
		System.out.println("Your current balance is :"+ balance);
	}
	
}

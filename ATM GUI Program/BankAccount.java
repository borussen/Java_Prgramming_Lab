/**
 * Class name is BankAccount. This is source code for the project.
 * It contains the information of bank account. 
 * 
 * @version JavaSE-16 25 October 2021
 * @author KIM HOJIN (2016314786)
 */
public class BankAccount {
	private String bankNumber;
	private int pinCode;
	private double balance;
	private User bankUser;
	/**
	 * @param bankNumber - Instance variable for storing user bank account number
	 * @param pinCode - Instance variable for storing user PIN code
	 * @param balance - Instance variable for storing user balance
	 * @param bankUser - Instantiate User object
	 */
	
	public BankAccount(String bankNumber, int pinCode, double balance, User bankUser) {
		setBankNumber(bankNumber);
		setPinCode(pinCode);
		setBalance(balance);
		setBankUser(bankUser);
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getBankUser() {
		return bankUser;
	}

	public void setBankUser(User bankUser) {
		this.bankUser = bankUser;
	}
}

package ex1;

public class BankAccount {

    private final int id;
    private static int lastId = 1000;
    private double balance;

    /**
     * Constructor for BankAccount class
     * Sets initial balance to provided parameter
     * Sets ID to next available ID
     * Pre: must provide a double >= to 0
     * @param balance
     */
    public BankAccount(double balance) {
        lastId++;
        id = lastId;
        this.balance = balance;
    }

    /**
     * Adds amount to balance
     * Pre: must provide a double >= to 0
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Subtracts amount from balance
     * Pre: must provide a double >= to 0
     * @param amount
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Returns the balance of the account
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the ID of the account
     * @return id
     */
    public int getId() {
        return id;
    }

}

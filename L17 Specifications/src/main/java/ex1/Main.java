package ex1;

public class Main {

    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(100.0);
        BankAccount ba2 = new BankAccount(500.0);

        ba1.deposit(100.0);
        ba2.withdraw(200.0);

        System.out.println("BA1 - Id: " + ba1.getId() + " Balance: " + ba1.getBalance());
        System.out.println("BA2 - Id: " + ba2.getId() + " Balance: " + ba2.getBalance());
    }
}

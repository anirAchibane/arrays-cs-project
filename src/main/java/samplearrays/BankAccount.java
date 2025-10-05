package samplearrays;

public class BankAccount {

    private String name;
    private double currentBalance;
    private Double[] transactions = new Double[1000];
    private int currentTransaction = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount > 0){
            currentBalance += amount;

            transactions[currentTransaction] = amount;
            currentTransaction++;

            System.out.println(amount + "MAD has been deposited in " + name + "'s account" +
                               "\nNew balance: " + currentBalance +"MAD");
        }
        else{
            System.out.println("invalid transaction! (Negative amount)");
        }

    }

    public void withdraw(double amount){
        if (amount < 0 || amount > currentBalance){
            System.out.println("Invalid transaction!");
        }
        else{
            transactions[currentTransaction] = - amount;
            currentTransaction++;

            currentBalance -= amount;
            System.out.println(amount + "MAD withdrawn from " + name  + "'s account"
                             + "\nNew balance: " + currentBalance + "MAD");
        }

    }

    public void displayTransactions(){
        for (Double amount: transactions){
            if (amount == null){
                break;
            }
            else if (amount < 0){
                System.out.println("Withdrawal: " + amount + "MAD");
            }
            else if(amount > 0){
                System.out.println("Deposit: " + amount + "MAD");
            }
        }
    }

    public void displayBalance(){
        System.out.println("Current Balance: " + currentBalance + "MAD");
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}

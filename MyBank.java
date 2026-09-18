import java.util.*;
class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
     
    BankAccount(int accountNumber, String accountHolder, double balance){
        this.accountNumber= accountNumber;
        this.accountHolder= accountHolder;
        this.balance=balance;
    }
    //Deposit//
    void deposit(double amount){
        if( amount>0 ){
            balance+= amount;
            System.out.println("Amount deposited successfully");

        }
        else{
            System.out.println("Invalid amount");
        }
    }
    //Withdraw//
    void withdraw (double amount){
        if( amount<=0){
            System.out.println("Invalid amount");
        } else if(amount> balance){
            System.out.println("Insufficient balance");
        } else{
            balance-= amount;
            System.out.println("Amount withdrawn successfully");
        }
    }
    //Display Account Details//
    void displayAccount(){
        System.out.println("...ACCOUNT DETAILS...");
        System.out.println("Account Number:"+ accountNumber);
        System.out.println("Account holder:"+ accountHolder);
        System.out.println("Balance:"+ balance);
    }
    int getAccountNumber(){
        return accountNumber;
    }
}
public class MyBank{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        BankAccount account= null;

        int choice;
        do{
            System.out.println("WELCOME");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = sc.nextDouble();

                    account = new BankAccount(
                        accNo,
                        name,
                        initialDeposit
                    );

                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (account != null) {
                        account.displayAccount();
                    } else {
                        System.out.println("No account exists.");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();

                        account.deposit(deposit);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;

                case 4:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();

                        account.withdraw(withdraw);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;

                case 5:
                    if (account != null) {
                        account.displayAccount();
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using the Bank Management System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
        
    


import java.util.*;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter ur Name: ");
        String cname = cin.nextLine();
        System.out.print("Enter ur Customer ID: ");
        String cid = cin.nextLine();
        System.out.println();
        BankAccount obj1 = new BankAccount(cname, cid);
        obj1.showMenu();
        cin.close();
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount)
    {
        if(amount > 0)
        {
            balance += amount;
            previousTransaction = amount;
        }
        else
        {
            System.out.println("Invalid Amount!!");
        }
    }

    void withdraw(int amount)
    {
        if(amount > 0)
        {
            if(balance>amount)
            {
                balance -= amount;
                previousTransaction = -amount;
            }
            else
            {
                System.out.println("Not Enough Balance, Transaction Terminated");
            }
        }
        else
        {
            System.out.println(" Invalid Amount!!");
        }
    }

    void getPreviousTransaction()
    {
        if(previousTransaction>0)
        {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if(previousTransaction <0)
        {
            System.out.println("Withdrawn: " +Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No transaction occured");
        }
    }

    void showMenu()
    {
        char option ='\0';
        Scanner cin = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your Customer ID is " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("================================================================");
            System.out.print("Enter an option: ");
            option = cin.next().charAt(0);
            System.out.println();

            switch(option)
            {
                case 'A':
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Balance = "+balance);
                    System.out.println("----------------------------------------------------------------");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Enter an amount to deposit: ");
                    int amount = cin.nextInt();
                    deposit(amount);
                    System.out.println("----------------------------------------------------------------");
                    System.out.println();
        
                    break;
                case 'C':
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Enter an amount to withdraw: ");
                    int amount2 = cin.nextInt();
                    withdraw(amount2);
                    System.out.println("----------------------------------------------------------------");
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("----------------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------------------------------------");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("================================================================");
                    break;
                default:
                    System.out.println("Invalid option!! Please enter again");
                    break;
            }
        } while (option != 'E');

        System.out.println("ThankYou for using our services");
        cin.close();
    }
}

package bank.projekt;

import java.util.ArrayList;
import java.util.Date;


public abstract class Account {
    //skapa object av class Date
    static Date date = new Date();
    //instans variable
    protected double balance;
    private String acct_type;
    private int accountNumber;
    private static int interestRate = 1;
    private static int accountNumberCounter = 1000;
    protected int ammountOfWithdraws =0;

    //instance variable av typ String som hÃ¥ller en list av transaction
       protected ArrayList<String> transactionsList;
  //abstact method som Ã¤r tom
    public abstract boolean withdraw(double value);

    //konstruktor med arrayList som parameter
    public Account(ArrayList<String> transactionsList) {
        this.transactionsList = transactionsList;
    }
//konstruktor
    public Account(String accountType, double balance) {
        this.balance = balance;
        acct_type = accountType;
        accountNumberCounter++;
        accountNumber = accountNumberCounter;
    }
//konstruktor
    public Account() {
        accountNumber = accountNumberCounter;
          accountNumberCounter++;
    }

    public static int getAccountNumberCounter() {
        return accountNumberCounter;
    }

    public static void setAccountNumberCounter(int accountNumberCounter) {
        Account.accountNumberCounter = accountNumberCounter;
    }

    public void setAcct_type(String acct_type) {
        this.acct_type = acct_type;
    }

    public ArrayList<String> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(ArrayList<String> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAcct_type() {
        return acct_type;
    }
    public void deposit(double value) {
        balance += value;
        System.out.println("Deposit: " + value);
        transactionsList.add("Time: " + date.toString() + " Deposit value: " + value + " New balance: " + balance);
        System.out.println("New balance: " + balance + "\n");
    }
    public int getAcc_num() {
        return accountNumber;
    }
    public static void setInterestRate(int newInterestRate) {
        interestRate = newInterestRate;
    }
    public static int getInterestRate() {
        return interestRate;
    }
    public double calculate_MonthlyInterest() {
        double month_Interest = balance * interestRate / 12;
        balance += month_Interest;
        System.out.println("Your interest rate is: " + balance);
        return month_Interest;
    }

    public String getAccount() {
        return "Account type: " + acct_type + ", Account number: " + accountNumber + ", Balance: " + balance
                + ", Interest rate: " + interestRate;
    }
    
    public String toString() {
        String info = "";
        for (int i = 0; i < transactionsList.size(); i++) {
            String s = transactionsList.get(i);
            info += s + "\n";
        }
        return info;
    }

    public void closeCurrentAccount() {
        // TODO Auto-generated method stub

    }

    public int getAmmountOfWithdraws() {
        return ammountOfWithdraws;
    }

    public void setAmmountOfWithdraws(int ammountOfWithdraws) {
        this.ammountOfWithdraws = ammountOfWithdraws;
    }
    
  

}

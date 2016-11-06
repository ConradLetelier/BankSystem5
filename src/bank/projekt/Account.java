
package bank.projekt;

import java.util.ArrayList;
import java.util.Date;


public abstract class Account {
    //skapa object av class Date
    static Date date = new Date();
    //instans variable
    protected double balance = 900;
    private String acct_type;
    private int accountNumber;
    private static int interestRate = 1;
    private static int accountNumberCounter = 1000;
    protected int ammountOfWithdraws =0;

    //instance variable av typ String som hÃ¥ller en list av transaction
       protected ArrayList<String> transactionsList = new ArrayList<String>();
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
        
        transactionsList.add("Time: " + date.toString() + "\nDeposit: " + value + "kr. New balance: " + balance + " kr.");
        
    }
    public int getAccountNumber() {
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
       
        return month_Interest;
    }

    public String getAccount() { //kontonummer, saldo, kontotyp, räntesats)
        return acct_type + "(KontoNummer: " + accountNumber + ", Saldo: " + balance + " kr, "
                + "Ränta: " + interestRate + "%) ";
    }
    
    public String toString() {
        String info = "";
        for (int i = 0; i < transactionsList.size(); i++) {
            String s = transactionsList.get(i);
            info += s + "\n";
        }
        return info;
    }

    public static String closeCurrentAccount(Account acc) {
        String SomethingReturn = "";
        System.out.println("Your saldo when you had no interest applied, was: " + acc.getBalance() + " kr.");
        if(acc instanceof CreditAccount){
            //presentation av kontots saldo samt ränta på pengarna ska genereras.
            
            //number is the Interest rate
            double number = (acc.getBalance() < 0) ? acc.getBalance()*1.07 : acc.getBalance()*1.005;
            
            
            //roundOff is to calculate the total interest
            double roundOff;

            //ToReturn is what you should return
 
            
            if(acc.getBalance() < 0){
                System.out.println("Your total interest is: -" + (acc.getBalance() - acc.getBalance()*1.07) + " kr.");
                SomethingReturn += "Your interest is: -" + (acc.getBalance() - acc.getBalance()*1.07) + " kr.";
                
            }
            else{
                roundOff = Math.round(((acc.getBalance()*1.005) - acc.getBalance()) * 100.0) / 100.0;
                System.out.println("Your total interest is: " + roundOff + " kr.");
                SomethingReturn += "Your interest is: " + roundOff + " kr.";
            }
            roundOff = Math.round(number * 100.0) / 100.0;
            System.out.println("Your saldo when interest was applied on this account is: " + (roundOff) + " kr.");
            SomethingReturn += " Your total Saldo upon closure is : " + roundOff + " kr.";
            
            return SomethingReturn;
            
        }
        if(acc instanceof SavingsAccount){
            
            
            System.out.println("Your total interest is: " + ((acc.getBalance()*1.01) - acc.getBalance()) + " kr.");
            
            SomethingReturn += "Your total interest is: " + ((acc.getBalance()*1.01) - acc.getBalance()) + " kr.";
            
            System.out.println("Your saldo when interest was applied on this account is: " +  acc.getBalance()*1.01 + " kr.");
            
            SomethingReturn += " Your total Saldo upon closure is : " + acc.getBalance()*1.01 + " kr.";
            
            
        }
        
        return SomethingReturn;

    }

    public int getAmmountOfWithdraws() {
        return ammountOfWithdraws;
    }

    public void setAmmountOfWithdraws(int ammountOfWithdraws) {
        this.ammountOfWithdraws = ammountOfWithdraws;
    }
    
    public String specialtoString(){
        return "temp";
    }
  

}

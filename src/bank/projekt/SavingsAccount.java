/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

/**
 *
 * @author Micke
 */
public class SavingsAccount extends Account{
    
     private boolean  firstWithdrawal=false;
     
    private boolean withdrawn = false;
    private double  interest = 1.01;
    private String accountType = "Savingsaccount";
     //Ett sparkonto ska ha ; saldo, interest,kontoNummer, kontoTyp, withdrawn
    
        public SavingsAccount(String accountType, double balance) { 
//parameter från super class Account
           super (accountType, balance);
            firstWithdrawal=false;
            transactionsList.add("Savings account named: " + accountType + " was created: " + date.toString() + " Balance: " + balance);

      
        setAcct_type("Savingsaccount");
        

    }
     public SavingsAccount(){

        super();
        setAcct_type("Savingsaccount");

          }
        public void closeCurrentAccount() {

        System.out.println( "Ending balance: " + balance +  " Interest: " + balance*0.01);

        }
        public boolean withdraw(double value) {
            if(balance >= value){
              if(firstWithdrawal==false){
                balance-=value;
                System.out.println("Cash value out: " + value);
                System.out.println("New balance: " + balance + "\n");
                transactionsList.add("Time: " + date.toString() + " Withdrawal: " + value + " New balance: " + balance);
                firstWithdrawal=true;
                return true;
              }else{
                if (balance>=1.02*value){
                  balance-=1.02*value;
                  System.out.println("Cash value out: " + value);
                  System.out.println("New balance: " + balance + "\n");
                  System.out.println(" some sum of amount money has been debited from your account");
        transactionsList.add("Time: " + date.toString() + " Withdrawal: " + value + " New balance: " + balance);
        return true;
                } else{
                  System.out.println("Not enough balance amount. Deposit some value.\n");
                }
              }
            }else {
              System.out.println("Not enough balance amount. Deposit some value.\n");
              return false;
            }
            return false;
          }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

   

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

  

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public boolean getWithdrawn(){
        return this.withdrawn;
    }

 

    @Override
    public String toString() {
        return "SavingsAccount{" + ", interest=" + interest + ", accountType=" + accountType + '}';
    }
    
}

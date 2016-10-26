/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ULTRA
 */
public class Transactions {
    
 private int accountID; 
 private Date time; 
 private String transactionType; 
 private double amount; 
 private double balance; 
 
 
public Transactions(int accountID, String transactionType, double amount, double balance){

this.accountID = accountID; 
this.amount = amount; 
this.balance = balance;
this.transactionType = transactionType;

} 

public String Date(){
Date currentdate = new Date(); 
SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd"); 
String s = sdf.format(currentdate); 
return s;
}

public String toString(){

return(Date() + this.transactionType + this.amount + this.balance);

}

    public int getAccountID() {
        return accountID;
    }

    public Date getTime() {
        return time;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }



}


    
    


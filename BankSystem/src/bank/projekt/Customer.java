/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import bank.projekt.Database.DBConnection;
import java.util.ArrayList;
/**
 *
 * @author Micke
 */
public class Customer {
    private String name;
    long pNr;
    private int uniqueID;
    
     private ArrayList<Account> accounts = new ArrayList<Account>();
    public Customer(){
        
        
    }
    
    public Customer(String name, long pNr){
        
        this.name = name;
        this.pNr = pNr;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPnr() {
        return pNr;
    }

    public void setPnr(long pNr) {
        this.pNr = pNr;
    }
       public String getCustomer(){
     return "Name: "+getName()+", Personal number: "+ getPnr();
   }
  
    public ArrayList<Account> getAllAccounts() {
              ArrayList<Account> something = accounts;
     return something;
   }
    
           public void addAccounts(Account s) {
     this.accounts.add(s);
     if(s.getAcct_type().equals("CreditAccount")){
         DBConnection.addAcc(s.getAccountNumber(), s.getBalance(), 0, 1, s.getAmmountOfWithdraws(), getPnr());
     }else{
         DBConnection.addAcc(s.getAccountNumber(), s.getBalance(), 1, 0, s.getAmmountOfWithdraws(), getPnr());
     }
   }
           public void addAccountToList(Account s){
               this.accounts.add(s);
           }
             public int getLastAccountNr() {
     return accounts.get(accounts.size()-1).getAccountNumber();
   }
             
             public Account getLastAccount(){
                 return accounts.get(accounts.size()-1);
             }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }
             


}

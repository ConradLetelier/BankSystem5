/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import java.util.ArrayList;
/**
 *
 * @author Micke
 */
public class Customer {
    String name;
    long pNr;
    
     private ArrayList<Account> accounts;
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

    public void setpNr(long pNr) {
        this.pNr = pNr;
    }
       public String getCustomer(){
     return "Name: "+getName()+", Personal number: "+ getPnr();
   }
  
          public ArrayList<Account> getAllAccounts() {
     return accounts;
   }
    
           public void addAccounts(Account s) {
     accounts.add(s);
   }
             public int getLastAccountNr() {
     return accounts.get(accounts.size()-1).getAcc_num();
   }


}

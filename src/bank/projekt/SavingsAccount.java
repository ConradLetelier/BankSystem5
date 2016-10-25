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
public class SavingsAccount {
    

    private boolean withdrawn = false;
    private double saldo , interest = 1.01;
    private int kontoNummer;
    private String accountType = "Sparkonto";
     //Ett sparkonto ska ha ; saldo, interest,kontoNummer, kontoTyp, withdrawn
    public SavingsAccount(int kontoNummer){
        this.saldo = saldo;
     
        this.kontoNummer = kontoNummer;
        this.accountType = accountType;
        
        this.withdrawn = withdrawn;
        

    }
    
    public boolean getWithdrawn(){
        return this.withdrawn;
    }
}

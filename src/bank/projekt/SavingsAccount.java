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

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getKontoNummer() {
        return kontoNummer;
    }

    public void setKontoNummer(int kontoNummer) {
        this.kontoNummer = kontoNummer;
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
}

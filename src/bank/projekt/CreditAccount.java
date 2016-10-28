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
public class CreditAccount{
    private String accountType = "KreditKonto";
    private int kontoNummer;
   
    private double saldo , interest, debt_interest;
    private double limit = 5000.0;
    
    
    //Ett kreditkonto ska ha ; saldo, kontoNummer, interest, skuldInterest,  kontoTyp, kreditGräns
    public CreditAccount(Double saldo, double interest, String name, int kontoNummer, String accountType){
        this.saldo = saldo;
        this.accountType = accountType;
        this.debt_interest = debt_interest;
        this.interest = interest;
        this.limit = limit;
        this.kontoNummer = kontoNummer;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getKontoNummer() {
        return kontoNummer;
    }

    public void setKontoNummer(int kontoNummer) {
        this.kontoNummer = kontoNummer;
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

    public double getDebt_interest() {
        return debt_interest;
    }

    public void setDebt_interest(double debt_interest) {
        this.debt_interest = debt_interest;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
    
    
}

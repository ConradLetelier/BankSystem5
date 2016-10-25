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
    
}

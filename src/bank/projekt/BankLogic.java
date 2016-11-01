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
public class BankLogic {
    
    public static ArrayList<Customer> kunder = new ArrayList<Customer>();
    
    
    
    public static ArrayList<String> getCustomers(){
        //Returnerar en ArrayList<String> som innehåller en presentation av bankens alla kunder (personnummer och namn)

 ArrayList<String> customer_data = new ArrayList<String>();
        for (int i = 0; i < kunder.size(); i++) {
            customer_data.add(kunder.get(i).getCustomer());
        }
        return customer_data;
    }
    public static boolean addCustomer(String name, long pNr){
        //Skapar upp en ny kund med namnet name samt personnumer pNr, kunden skapas endast om det inte 
        //finns någon kund med personnummer pNr. Returnerar true om kund skapades annars returneras false.
        if(kunder.size() == 0){
            Customer kund = new Customer(name, pNr);
            kunder.add(kund);
            return true;
        }
        else if(kunder.size() > 0){
            for(Customer e : kunder){
                if(e.pNr == pNr){
                    System.err.println("En person med det person nummret finns redan!");
                    
                    return false;
                }
            }
            Customer kund = new Customer(name, pNr);
            kunder.add(kund);
            
        }
        
        return true;
    }
    public static ArrayList<String> getCustomer(long pNr){
        //Returnerar en List<String> som innehåller informationen om kunden inklusive dennes konton. 
        //Första platsen i listan är förslagsvis reserverad för kundens namn och personnummer sedan följer informationen om kundens konton.
        ArrayList<String> shit = new ArrayList<String>();
        if(kunder.size() > 0){
            for(Customer e : kunder){
                if(e.pNr == pNr){
                shit.add(e.name);
                shit.add(Long.toString(e.pNr));
                }
            }
        }
        
        return shit;
        
    }
    public static boolean changeCustomerName(String name, long pNr){
        //Byter namn på kund med personnummer pNr till name, returnerar true om namnet ändrades annars returnerar false (om kunden inte fanns).
        if(kunder.size() > 0){
            for(Customer e : kunder){
                System.out.println(e.name);
                if(e.pNr == pNr){
                    e.name = name;
                    
                    return true;
                    
                }
            }
        }
        return false;
    }
    
    public ArrayList<String> removeCustomer(long pNr){
        //Tar bort kund med personnummer pNr ur banken, alla kundens eventuella konton tas också bort och resultatet returneras.
        //Listan som returneras ska innehålla information om alla konton som togs bort, saldot som kunden får tillbaka samt vad räntan blev.
           ArrayList<String> intro = new ArrayList<String>();
        Customer deletedCustomer = new Customer();
        for (int i = 0; i < kunder.size(); i++) {
            if (kunder.get(i).getPnr()== pNr) {
                deletedCustomer = kunder.remove(i); // The deleted
                intro.add(deletedCustomer.getCustomer());
                for (Account list : deletedCustomer.getAllAccounts()) {
                    intro.add(list.getAccount());
                }
                return intro;
            }
        }
        return null;
    }
    
    public static int addSavingsAccount(long pNr){
        //Skapar ett konto till kund med personnummer pNr, returnerar kontonumret som 
        //det skapade kontot fick alternativt returneras –1 om inget konto skapades.
             for (int i = 0; i < kunder.size(); i++) {
            if (kunder.get(i).getPnr()== pNr) {
                kunder.get(i).addAccounts(new SavingsAccount());
                return kunder.get(i).getLastAccountNr();
            }
        }
        return -1;
    }
    
    public String getAccount(long pNr, int accountId){
        //Returnerar en String som innehåller presentation av kontot med kontonnummer accountId som tillhör kunden pNr 
        //(kontonummer, saldo, kontotyp, räntesats).
           for (Customer client : kunder) {
            if (client.getPnr()== pNr) {
                for (Account account : client.getAllAccounts()) {
                    if (account.getAccountNumber()== accountId) {
                        return account.getAccount();
                    }
                }
            }
        }
        return null;
    }
    
    public boolean deposit(long pNr, int accountId, double amount){
        //Gör en insättning på konto med kontonnummer accountId som tillhör kunden pNr, returnerar true om det gick bra annars false.
         for (Customer person : kunder) {
            if (person.getPnr()== pNr) {
                for (Account account : person.getAllAccounts()) {
                    if (account.getAccountNumber()== accountId) {
                        account.deposit(amount);
                        return true;
                    }
                }
            }
 
        }
        return false;
    }
    
    public boolean withdraw(long pNr, int accountId, double amount){
        //Gör ett uttag på konto med kontonnummer accountId som tillhör kunden pNr, returnerar true om det gick bra annars false.
         for (Customer client : kunder) {
            if (client.getPnr()== pNr) {
                for (Account account : client.getAllAccounts()) {
                    if (account.getAccountNumber()== accountId) {
                        account.setAmmountOfWithdraws(account.getAmmountOfWithdraws()+1);
                        return account.withdraw(amount);
                    }
                }
            }
        }
        return false;
    }
    
    public String closeAccount(long pNr, int accountId){
        //Stänger ett konto med kontonnummer accountId som tillhör kunden pNr, presentation av kontots saldo samt ränta på pengarna ska genereras.
        for (Customer client : kunder) {
            if (client.getPnr()== pNr)
                for (Account account : client.getAllAccounts()) {
                    if (account.getAccountNumber()== accountId) {
                        String data = account.getAccount();
                        account.closeCurrentAccount();
                        client.getAllAccounts().remove(account);
                        System.out.println("");
                        return "Account close" + data;
                    }
                }
        }
        return "Account does not exist ";
    }
    
    public int addCreditAccount(long pNr){
        //Skapar ett kreditkonto till kund med personnummer pNr och returnerar kontonumret som det skapade 
        //kontot fick (alternativt returneras -1 om inget konto skapades)
         for (int i = 0; i < kunder.size(); i++) {
            if (kunder.get(i).getPnr()== pNr) {
                kunder.get(i).addAccounts(new CreditAccount());
                return kunder.get(i).getLastAccountNr();
            }
        }
        return -1;
    }
    
    public ArrayList<String> getTransactions(long pNr, int accountId){
         for (Customer client : kunder) {
            if (client.getPnr()== pNr)
                for (Account account : client.getAllAccounts()) {
                    if (account.getAccountNumber()== accountId) {
                        return account.getTransactionsList();
                    }
                }
        }
        return new ArrayList<String>();
    }
     public static void InitilizeList(){
          
      
        for(int i = 0; i < BankLogic.kunder.size();i++){
            MainpageController.data.add(BankLogic.kunder.get(i));
            
        }
           
        }
    
    
    //Programmet ska göras så stabilt som möjligt, även om användaren missförstår instruktionerna ska han/hon inte lyckas krascha programmet i första taget. 
    //Glöm heller inte att hantera om man försöker spara till en fil som är skrivskyddad eller om man försöker öppna en korrupt fil.
    
    //Fix writing method
    
    //När man tar bort ett konto skall räntan beräknas som saldo multiplicerat med ränta/100. Saldo och ränta ska visas på skärmen vid avslutande av kontot.
    //OBS! Enda gången ränta läggs på är alltså när kontot tas bort eftersom årsskiften inte hanteras i denna version av systemet. 
    //Alla transaktioner förutsätts ske under ett och samma kalenderår.
}

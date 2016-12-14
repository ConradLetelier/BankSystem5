/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import bank.projekt.Database.DBConnection;
import static bank.projekt.MainpageController.data;
import java.util.ArrayList;

/**
 *
 * @author Micke
 */
public class BankLogic {

    public static ArrayList<Customer> kunder = new ArrayList<Customer>();
    public static ArrayList<Integer> accountNumbers = DBConnection.getAllAccountNumbers();

    public static ArrayList<String> getCustomers() {
        //Returnerar en ArrayList<String> som innehåller en presentation av bankens alla kunder (personnummer och namn)

        ArrayList<String> customer_data = new ArrayList<String>();
        for (int i = 0; i < kunder.size(); i++) {
            customer_data.add(kunder.get(i).getCustomer());
        }

        return customer_data;
    }

    public static boolean addCustomer(String name, long pNr) {
        //Skapar upp en ny kund med namnet name samt personnumer pNr, kunden skapas endast om det inte 
        //finns någon kund med personnummer pNr. Returnerar true om kund skapades annars returneras false.
        if (kunder.size() > 0) {
            for (Customer e : kunder) {

                if (e.getPnr() == pNr) {
                    //Fixa label med Error
                    return false;
                }
            }
            Customer kund = new Customer(name, pNr);
            data.add(kund);
            kunder.add(kund);
            DBConnection.addCust(name, pNr);

            return true;
        } else {
            Customer kund = new Customer(name, pNr);
            data.add(kund);
            kunder.add(kund);
            DBConnection.addCust(name, pNr);

        }

        return true;
    }

    public static void resetSearch() {
        data.clear();

        MainpageController.data2.clear();
        for (Customer e : kunder) {
            data.add(e);

        }
    }

    public static boolean searchCustomer(String name, long pNr) {
        data.clear();
        boolean added = false;
        MainpageController.data2.clear();

        if (kunder.size() > 0) {

            if (name.equals("") && pNr != 0) { //Search on pNr
                for (Customer e : kunder) {
                    if (e.getPnr() == pNr) {
                        data.add(e);
                        if (e.getAllAccounts().size() > 0 && added == false) {
                            MainpageController.data2.addAll(e.getAllAccounts());
                        }
                        added = true;

                    }
                }
            } else if (!name.equals("") && pNr == 0) { //Search on name
                for (Customer e : kunder) {
                    if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                        data.add(e);
                        if (e.getAllAccounts().size() > 0 && added == false) {
                            MainpageController.data2.addAll(e.getAllAccounts());
                        }
                        added = true;

                    }
                }
            } else if (!name.equals("") && pNr != 0) { //Search on name and Pnr
                for (Customer e : kunder) {
                    if (e.getName().toLowerCase().contains(name.toLowerCase()) || e.getPnr() == pNr) {
                        data.add(e);
                        if (e.getAllAccounts().size() > 0 && added == false) {
                            MainpageController.data2.addAll(e.getAllAccounts());
                        }
                        added = true;
                    }
                }
            }
        }
        if (data.size() == 0) {
            return false;

        }
        return true;
    }

    public static ArrayList<String> getCustomer(long pNr) {
        //Returnerar en List<String> som innehåller informationen om kunden inklusive dennes konton. 
        //Första platsen i listan är förslagsvis reserverad för kundens namn och personnummer sedan följer informationen om kundens konton.
        ArrayList<String> Customers = new ArrayList<String>();
        String toFormat = "";
        if (kunder.size() > 0) {
            for (Customer e : kunder) {

                if (e.pNr == pNr) {
                    toFormat += "Customer name: " + e.getName() + ", pNr: " + Long.toString(e.pNr);
//                Customers.add("Customer name: " + e.getName());
//                Customers.add("pNr: " + Long.toString(e.pNr));
                    if (e.getAllAccounts().size() > 0) {
//                    Customers.add("Accounts:");
                        toFormat += ", Accounts: ";
                        for (Account acc : e.getAllAccounts()) {
                            toFormat += acc.getAccount();

                        }
                    }

                }
            }
        }

        Customers.add(toFormat);

        return Customers;

    }

    public static boolean changeCustomerName(String name, long pNr) {
        //Byter namn på kund med personnummer pNr till name, returnerar true om namnet ändrades annars returnerar false (om kunden inte fanns).
        if (kunder.size() > 0) {
            for (Customer e : kunder) {

                if (e.pNr == pNr) {
                    e.setName(name);
                    DBConnection.updateStatic(name, pNr);
                    return true;

                }
            }
        }
        return false;
    }

    public static ArrayList<String> removeCustomer(long pNr) {
        //Tar bort kund med personnummer pNr ur banken, alla kundens eventuella konton tas också bort och resultatet returneras.
        //Listan som returneras ska innehålla information om alla konton som togs bort, saldot som kunden får tillbaka samt vad räntan blev.
        ArrayList<String> intro = new ArrayList<String>();

        Customer deletedCustomer = new Customer();
        ArrayList<Account> Safety = new ArrayList<>();
        ArrayList<Customer> duplicate = new ArrayList<>();
        ArrayList<String> removed = new ArrayList<>();

        String toReturn = "";

        Customer[] test = new Customer[kunder.size()];

        Customer temp = new Customer();

        int count = 0;

        //To Avoid a Exception that is explicit to Trying to modify a list that we are currently iterating upon
        //We have to conver to Arrays and then handle the values there of
        for (int i = 0; i < test.length; i++) {

            test[i] = kunder.get(i);
        }

        for (int i = 0; i < test.length; i++) {
            if (test[i].getPnr() == pNr) {
                temp = test[i]; //Temp is the Customer
                break;
            }
            count += 1;
        }

        Account[] test2 = new Account[temp.getAllAccounts().size()]; //test2 holds all the Accounts
        for (int i = 0; i < temp.getAllAccounts().size(); i++) {
            test2[i] = temp.getAllAccounts().get(i);

//            removed.add(temp.getAllAccounts().get(i).toString());
        }

        for (int i = 0; i < test2.length; i++) {

            String something = "";

            int withdrawn = test2[i].getAmmountOfWithdraws();

            something += withdrawn;

            removed.add(test2[i].toString() + " " + closeAccount(pNr, test2[i].getAccountNumber()) + "You have withdrawn: " + something + " times from this account");

            if (test2[i] instanceof CreditAccount) {
                double balance = test2[i].getBalance();
                removed.add((balance < 0) ? "Debt Interest Rate: 7%)" : "Interest Rate: 0.5%)\n");

            } else {
                removed.add("Interest Rate: 1%)\n");
            }

        }

        System.out.println();
        System.out.println(removed + " This is the Returned value for Removed Customer");

        kunder.remove(temp);

        data.remove(temp);
        int custID = DBConnection.getID(pNr);
        for (int i = 0; i < accountNumbers.size(); i++) {
            int owner = DBConnection.getAccountOwner(i);
            if (owner == custID) {
                DBConnection.removeTransaction(i);
                DBConnection.removeAccount(i);
            }
        }
        DBConnection.removeStatic(pNr);

        return removed;
    }

    public static int addSavingsAccount(long pNr) {
        //Skapar ett konto till kund med personnummer pNr, returnerar kontonumret som 
        //det skapade kontot fick alternativt returneras –1 om inget konto skapades.
        for (Customer e : BankLogic.kunder) {

            if (e.getPnr() == pNr) {

                e.addAccounts(new SavingsAccount());

                return 1;
            }
        }

        return -1;
    }

    public static String getAccount(long pNr, int accountId) {
        //Returnerar en String som innehåller presentation av kontot med kontonnummer accountId som tillhör kunden pNr 
        //(kontonummer, saldo, kontotyp, räntesats).
        for (Customer client : kunder) {
            if (client.getPnr() == pNr) {
                for (Account account : client.getAllAccounts()) {
                    if (account.getAccountNumber() == accountId) {
                        if (account instanceof SavingsAccount) {
                            return account.getAccount();
                        } else {
                            CreditAccount to_return = ((CreditAccount) account);
                            String something = to_return.getAccount();
                            return something;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean deposit(long pNr, int accountId, double amount) {
        //Gör en insättning på konto med kontonnummer accountId som tillhör kunden pNr, returnerar true om det gick bra annars false.
        try {
            for (Customer person : kunder) {
                if (person.getPnr() == pNr) {

                    for (Account account : person.getAllAccounts()) {
                        if (account.getAccountNumber() == accountId) {

                            account.deposit(amount);
                            int uniqueID = DBConnection.getID(pNr);
                            DBConnection.addTransaction(amount, account.getBalance(), Transactions.Date(), "Deposit", accountId, uniqueID);
                            return true;
                        }
                    }
                }

            }
            return false;
        } catch (Exception e) {
            System.out.println("Deposit error");
            return false;
        }
    }

    public static boolean withdraw(long pNr, int accountId, double amount) {
        //Gör ett uttag på konto med kontonnummer accountId som tillhör kunden pNr, returnerar true om det gick bra annars false.
        boolean check = false;
        for (Customer client : kunder) {

            if (client.getPnr() == pNr) {

                for (Account account : client.getAllAccounts()) {

                    if (account.getAccountNumber() == accountId) {

                        if (account instanceof CreditAccount) {

                            if (((CreditAccount) account).withdraw(amount)) {
                                int uniqueID = DBConnection.getID(pNr);
                                DBConnection.addTransaction(amount, account.getBalance(), Transactions.Date(), "Withdraw", accountId, uniqueID);
                                check = true;
                                break;
                            } else {
                                check = false;
                            }

                        }
                        if (account instanceof SavingsAccount) {

                            if (((SavingsAccount) account).withdraw(amount)) {
                                int uniqueID = DBConnection.getID(pNr);
                                DBConnection.addTransaction(amount, account.getBalance(), Transactions.Date(), "Withdraw", accountId, uniqueID);
                                check = true;
                                break;
                            } else {
                                check = false;
                            }
                        }
                    }
                }
            }
        }

        if (check) {
            return true;
        }
        return false;
    }

    public static String closeAccount(long pNr, int accountId) {
        //Stänger ett konto med kontonnummer accountId som tillhör kunden pNr, presentation av kontots saldo samt ränta på pengarna ska genereras.
        String SomethingReturn = "";
        Double roundOff;
        for (Customer client : kunder) {
            if (client.getPnr() == pNr) {
                for (Account acc : client.getAllAccounts()) {

                    if (acc.getAccountNumber() == accountId) {
                        try {

//                        String data = account.getAccount();
                            //acc.closeCurrentAccount(acc); returns String
//                        client.getAllAccounts().remove(account);
                            if (acc instanceof CreditAccount) {
                                //presentation av kontots saldo samt ränta på pengarna ska genereras.

                                //number is the Interest rate
                                double number = (acc.getBalance() < 0) ? acc.getBalance() * 1.07 : acc.getBalance() * 1.005;

                                if (acc.getBalance() < 0) {

                                    SomethingReturn += "Your interest is: -" + (acc.getBalance() - acc.getBalance() * 1.07) + " kr,";

                                } else {
                                    roundOff = Math.round(((acc.getBalance() * 1.005) - acc.getBalance()) * 100.0) / 100.0;

                                    SomethingReturn += "Your interest is: " + roundOff + " kr,";
                                }
                                roundOff = Math.round(number * 100.0) / 100.0;

                                SomethingReturn += " Your total Saldo upon closure is : " + roundOff + " kr. ";

                                client.getAllAccounts().remove(acc);

                                MainpageController.data2.remove(acc);
                                DBConnection.removeTransaction(accountId);
                                DBConnection.removeAccount(accountId);
                                System.out.println(SomethingReturn);

                                return SomethingReturn;

                            }
                            if (acc instanceof SavingsAccount) {

                                roundOff = Math.round(((acc.getBalance() * 1.01) - acc.getBalance()) * 100.0) / 100.0;
                                SomethingReturn += "Your total interest is: " + ((acc.getBalance() * 1.01) - acc.getBalance()) + " kr,";

                                SomethingReturn += " Your total Saldo upon closure, is : " + acc.getBalance() * 1.01 + " kr.";

                            }

                            client.getAllAccounts().remove(acc);

                            MainpageController.data2.remove(acc);
                            DBConnection.removeTransaction(accountId);
                            DBConnection.removeAccount(accountId);
//                        return "Account close" + data;
                            System.out.println(SomethingReturn);
                            return SomethingReturn;
                        } catch (Exception e) {
                            System.out.println(e + " This was the error");
                        }
                    }
                }
            }

        }
        return "Account does not exist";
    }

    public int addCreditAccount(long pNr) {
        //Skapar ett kreditkonto till kund med personnummer pNr och returnerar kontonumret som det skapade 
        //kontot fick (alternativt returneras -1 om inget konto skapades)
        for (int i = 0; i < kunder.size(); i++) {
            if (kunder.get(i).getPnr() == pNr) {
                kunder.get(i).addAccounts(new CreditAccount());
                return kunder.get(i).getLastAccountNr();
            }
        }
        return -1;
    }

    public static ArrayList<String> getTransactions(long pNr, int accountId) {
        int count = 0;
        ArrayList<String> toReturn = new ArrayList<String>();
        for (Customer client : kunder) {
            if (client.getPnr() == pNr) {
                for (Account account : client.getAllAccounts()) {
                    if (account.getAccountNumber() == accountId) {

                        if (account instanceof SavingsAccount) {
                            MainpageController.isSavingsAccount = true;

                            toReturn.add("Kontonummer: " + account.getAccountNumber() + " " + SavingsAccount.getAccountType());
                        } else {

                            MainpageController.isCreditAccount = true;
                            double interest = (account.getBalance() < 0) ? -7 : 0.5;
                            toReturn.add("Kontonummer: " + account.getAccountNumber() + " " + CreditAccount.getAccountType());
                        }
                        for (Transactions a : account.getTransactionsList()) {
                            if (count > 0) {
                                if (account instanceof CreditAccount) {
                                    double interest = (account.getBalance() < 0) ? -7 : 0.5;
                                    toReturn.add("Kontonummer: " + account.getAccountNumber() + " " + CreditAccount.getAccountType());
                                }
                            }
                            toReturn.add(a.toString());
                            count += 1;
                        }
                        return toReturn;
                    }
                }
            }
        }
        toReturn.add("There have been no transactions for this account, yet.");
        return toReturn;
    }

    public static void InitilizeList() {

        for (int i = 0; i < BankLogic.kunder.size(); i++) {
            MainpageController.data.add(BankLogic.kunder.get(i));

        }

//        for (int i = 1; i <= 50; i++) {
//            String a = DBConnection.getName(i);
//            if (a.equals("null")) {
//                continue;
//            }
//            long b = DBConnection.getPNR(i);
//
//            String newB = String.valueOf(b);
//            if (newB.equals("0")) {
//                continue;
//            }
//            Customer input = new Customer(a, b);
//            BankLogic.kunder.add(input);
//        }
        DBConnection.initilizeCustomerList();
        for (int i = 0; i < BankLogic.kunder.size(); i++) {
            kunder.get(i).setUniqueID(DBConnection.getID(kunder.get(i).getPnr()));
        }

        //  ArrayList<Integer> accountNumbers = DBConnection.getAllAccountNumbers();
        for (int i = 0; i < accountNumbers.size(); i++) {
            int accNumber = accountNumbers.get(i);
            int id = DBConnection.getAccountOwner(accNumber);

            for (int j = 0; j < kunder.size(); j++) {
                if (id == kunder.get(j).getUniqueID()) {
                    if (DBConnection.getAccountType(accNumber) == 1) {
                        SavingsAccount s = new SavingsAccount();
                        s.setBalance(DBConnection.getBalance(accNumber));
                        s.setAmmountOfWithdraws(DBConnection.getWithdraws(accNumber));
                        s.setAccountNumber(accNumber);
                        //   Account.addCounter();
                        ArrayList list = DBConnection.getTransactions(accNumber);
                        for (int k = 0; k < list.size(); k++) {
                            String ss = (String) list.get(k);
                            String[] parts = ss.split(",");
                            String type = parts[3];
                            double amount1 = Double.valueOf(parts[1]);
                            double balance1 = Double.valueOf(parts[2]);
                            String day1 = parts[4];
                            s.addTransaction(accNumber, type, balance1, amount1, day1);
                        }
                        kunder.get(j).addAccountToList(s);
                    } else {
                        CreditAccount s = new CreditAccount();
                        s.setBalance(DBConnection.getBalance(accNumber));
                        s.setAmmountOfWithdraws(DBConnection.getWithdraws(accNumber));
                        s.setAccountNumber(accNumber);
                        //    Account.addCounter();
                        ArrayList list = DBConnection.getTransactions(accNumber);
                       for (int k = 0; k < list.size(); k++) {
                            String ss = (String) list.get(k);
                            String[] parts = ss.split(",");
                            String type = parts[3];
                            double amount1 = Double.valueOf(parts[1]);
                            double balance1 = Double.valueOf(parts[2]);
                            String day1 = parts[4];
                            s.addTransaction(accNumber, type, balance1, amount1, day1);
                        }

                        kunder.get(j).addAccountToList(s);
                    }

                }
            }
        }

        //Programmet ska göras så stabilt som möjligt, även om användaren missförstår instruktionerna ska han/hon inte lyckas krascha programmet i första taget. 
        //Glöm heller inte att hantera om man försöker spara till en fil som är skrivskyddad eller om man försöker öppna en korrupt fil.
        //Fix writing method
        //När man tar bort ett konto skall räntan beräknas som saldo multiplicerat med ränta/100. Saldo och ränta ska visas på skärmen vid avslutande av kontot.
        //OBS! Enda gången ränta läggs på är alltså när kontot tas bort eftersom årsskiften inte hanteras i denna version av systemet. 
        //Alla transaktioner förutsätts ske under ett och samma kalenderår.
    }
}

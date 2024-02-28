package Model.Other;

import Model.Accounts.Account;
import Model.Banks.CommercialBank;
import Model.Enums.AccountType;

import java.util.List;

public class AccountRep {

    public List<Account> getAccountByID (int clientID, CommercialBank bank, AccountType accountType){
        return bank.getAccounts().stream().filter(account -> account.getUserID() == clientID && account.getAccountType() == accountType).toList();
    }

}

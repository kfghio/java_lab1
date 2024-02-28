package Model.Other;

import Model.Accounts.Account;
import Model.Banks.CommercialBank;
import Model.Enums.AccountType;

import java.util.List;

public class AccountRep {

     /**
      * Retrieves a list of accounts based on the client ID, bank, and account type.
      *
      * @param clientID    The ID of the client whose accounts are to be retrieved.
      * @param bank        The CommercialBank instance from which accounts are retrieved.
      * @param accountType The type of account to retrieve.

      * @return A list of Account objects matching the criteria.
      */

    public List<Account> getAccountByID (int clientID, CommercialBank bank, AccountType accountType){
        return bank.getAccounts().stream().filter(account -> account.getUserID() == clientID && account.getAccountType() == accountType).toList();
    }

}

package Service.BankCreaterService;

import Model.Accounts.Account;
import Model.Banks.CommercialBank;
import Entity.Clients.Client;
import Model.Procent.Commission;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BankCreater {
    private final CommercialBank bank;

    void userAdd(Client user){
        bank.getUsers().add(user);
    }
    void accountAdd(Account account){
        bank.getAccounts().add(account);
    }
    void commissionAdd(Commission commission){
        bank.getCommissions().add(commission);
    }
}

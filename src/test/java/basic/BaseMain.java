package basic;

import Model.Accounts.Account;
import Model.Banks.CentralBank;
import Model.Banks.CommercialBank;
import Model.Enums.AccountType;
import Model.Other.Cortege;
import Model.Procent.Commission;
import Model.Subs.SubCentralBank;
import Service.CentralBankCreaterService.Commission.CentralBankService;
import Service.CommercialBankService.CommercialBankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AppTest {
    @Tag("AAA")
    @Test
    void testOne(){
        CentralBank centralBank = new CentralBank();
        SubCentralBank subCentralBank = new SubCentralBank();
        CommercialBank commercialBank = new CommercialBank(1,-15000,15000,subCentralBank);
        CentralBankService centralBankService = new CentralBankService(centralBank);
        centralBankService.createBank(commercialBank);
        CommercialBankService commercialBankService = new CommercialBankService(commercialBank);
        Account account1 = new Account(1,1,10, AccountType.DEBIT);
        commercialBankService.createAccount(account1);
        Cortege cortege = new Cortege<>(0,100000);
        Commission commission = new Commission(2.5, cortege,AccountType.DEBIT);
        commercialBankService.createCommission(commission);
        centralBankService.validation(20, account1,commercialBank);
        Assertions.assertEquals(10,account1.getMoneySum());

    }
}

import Entity.Clients.Client;
import Model.Accounts.Account;
import Model.Banks.CentralBank;
import Model.Banks.CommercialBank;
import Model.Enums.AccountType;
import Model.Enums.StatusTransactionType;
import Model.Enums.StatusType;
import Model.Enums.TransactionType;
import Model.Other.Cortege;
import Model.Procent.Commission;
import Model.Subs.SubCentralBank;
import Model.Transaction.Transaction;
import Service.CentralBankCreaterService.Commission.CentralBankService;
import Service.CommercialBankService.CommercialBankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AppTest {
    @Tag("AAA")
    @Test
    void testClientValidation(){
        Client user1 = new Client(1,"Gon", "Jojo","jj",190234 );
        Assertions.assertEquals(StatusType.NOTQUESTIONABLE,user1.getStatusType());

    }

    @Tag("AAA")
    @Test
    void testCreateBankSub(){
        CentralBank centralBank = new CentralBank();
        SubCentralBank subCentralBank = new SubCentralBank();
        CommercialBank bank1 = new CommercialBank(1,-1,10000,subCentralBank);
        Assertions.assertEquals(bank1,subCentralBank.getBanks().get(0));

    }

    @Tag("AAA")
    @Test
    void testCommericalBankService(){
        CentralBank centralBank = new CentralBank();
        SubCentralBank subCentralBank = new SubCentralBank();
        CommercialBank bank1 = new CommercialBank(1,-1,10000,subCentralBank);
        CommercialBankService commercialBankService = new CommercialBankService(bank1);

        Client user1 = new Client(1,"Gon", "Jojo","jj",190234 );
        Account account1 = new Account(1,1,10,AccountType.DEBIT);
        Cortege cortege1 = new Cortege(0,1000);
        Commission commission = new Commission(1.5,cortege1,AccountType.DEBIT);

        commercialBankService.createCommission(commission);
        commercialBankService.createAccount(account1);
        commercialBankService.createClient(user1);

        Assertions.assertEquals(account1,bank1.getAccounts().get(0));
        Assertions.assertEquals(user1,bank1.getUsers().get(0));
        Assertions.assertEquals(commission,bank1.getCommissions().get(0));

    }
    @Tag("BBB")
    @Test
    void testCommericalBankServiceTransactionTransfer(){
        CentralBank centralBank = new CentralBank();
        SubCentralBank subCentralBank = new SubCentralBank();
        CommercialBank bank1 = new CommercialBank(1,-100,10000,subCentralBank);
        CommercialBankService commercialBankService = new CommercialBankService(bank1);

        Client user1 = new Client(1,"Gon", "Jojo","jj",190234 );
        Account account1 = new Account(1,1,10,AccountType.DEBIT);
        Account account2 = new Account(2,1,10,AccountType.DEBIT);
        Cortege cortege1 = new Cortege(0,1000);
        Commission commission = new Commission(1.5,cortege1,AccountType.DEBIT);
        Transaction transaction1 = new Transaction(1,account1,account2,5, TransactionType.TRANSFER, StatusTransactionType.SUCCEED);

        commercialBankService.createCommission(commission);
        commercialBankService.createAccount(account1);
        commercialBankService.createAccount(account2);
        commercialBankService.createClient(user1);
        commercialBankService.createTransaction(transaction1);

        Assertions.assertEquals(15,account2.getMoneySum());

    }
    @Tag("BBB")
    @Test
    void testCommericalBankServiceTransactionWithdraw(){
        CentralBank centralBank = new CentralBank();
        SubCentralBank subCentralBank = new SubCentralBank();
        CommercialBank bank1 = new CommercialBank(1,-100,10000,subCentralBank);
        CommercialBankService commercialBankService = new CommercialBankService(bank1);

        Client user1 = new Client(1,"Gon", "Jojo","jj",190234 );
        Account account1 = new Account(1,1,10,AccountType.DEBIT);
        Account account2 = new Account(2,1,10,AccountType.DEBIT);
        Cortege cortege1 = new Cortege(0,1000);
        Commission commission = new Commission(1.5,cortege1,AccountType.DEBIT);
        Transaction transaction1 = new Transaction(1,account1,account2,5, TransactionType.WITHDRAW, StatusTransactionType.SUCCEED);

        commercialBankService.createCommission(commission);
        commercialBankService.createAccount(account1);
        commercialBankService.createAccount(account2);
        commercialBankService.createClient(user1);
        commercialBankService.createTransaction(transaction1);

        Assertions.assertEquals(5,account1.getMoneySum());
        Assertions.assertEquals(10,account2.getMoneySum());

    }

}
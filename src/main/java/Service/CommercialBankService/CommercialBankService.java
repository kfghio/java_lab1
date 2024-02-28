package Service.CommercialBankService;

import Commands.AddCommand;
import Commands.GettingCommand;
import Commands.TransferCommand;
import Entity.Clients.Client;
import Model.Accounts.Account;
import Model.Banks.CommercialBank;
import Model.Enums.AccountType;
import Model.Enums.StatusType;
import Model.Enums.TransactionType;
import Model.Procent.Commission;
import Model.Transaction.Transaction;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommercialBankService {
    private double questionableLimit;
    private final CommercialBank bank;
    private final Map<TransactionType, Transaction> map = new HashMap<>();

    /**
     * @param commercialBank
     */
    public CommercialBankService(CommercialBank commercialBank){
        this.bank = commercialBank;
    }

    /**
     * Adding an account to the current bank
     * @param account Existing account
     */
    public void createAccount(Account account){
        bank.getAccounts().add(account);
    }

    /**
     * Adding a client to the current bank
     * @param client Existing client
     */
    public void createClient(Client client){
        bank.getUsers().add(client);
    }

    /**
     * Adding a commission(percent) to the current bank
     * @param commission Existing commission(percent)
     */
    public void createCommission(Commission commission){
        bank.getCommissions().add(commission);
    }

    /**
     * Transaction Processing
     * @param transaction Existing pending transaction
     */
    public void createTransaction(Transaction transaction){
        Client client = bank.getUsers().stream().filter(client1 -> client1.getClientID() == transaction.getAccount().getUserID()).findFirst().get();

        if (client.getStatusType() == StatusType.QUESTIONABLE)
            questionableLimit = bank.getQuastionableLimit();
        else if (transaction.getAccount().getAccountType() == AccountType.CREDIT)
            questionableLimit = bank.getCreaditLimit();
        else
            questionableLimit = Double.MAX_VALUE;

        if(transaction.getTransactionType() == TransactionType.TRANSFER)
            map.put(TransactionType.TRANSFER, new TransferCommand(transaction).execute(questionableLimit));
        if(transaction.getTransactionType() == TransactionType.REPLENISHMENT)
            map.put(TransactionType.REPLENISHMENT, new AddCommand(transaction).execute(questionableLimit));
        if(transaction.getTransactionType() == TransactionType.WITHDRAW)
            map.put(TransactionType.WITHDRAW, new GettingCommand(transaction).execute(bank.getCreaditLimit()));

        map.get(transaction.getTransactionType());
    }


    public Transaction back(Transaction transaction){
        transaction.repair();
        return transaction;
    }
}

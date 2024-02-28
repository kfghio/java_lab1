package Model.Transaction;

import Model.Accounts.Account;
import Model.Enums.StatusTransactionType;
import Model.Enums.TransactionType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Transaction {

    @NonNull
    private int id;
    @NonNull
    private Account account;
    private Account aimAccount;
    private double money;
    private TransactionType transactionType;
    private StatusTransactionType statusTransactionType;
    private final MementoStorage mementoStorage;

    public Transaction(@NonNull int id, @NonNull Account account, Account aimAccount, double money, TransactionType transactionType, StatusTransactionType statusTransactionType) {
        this.id = id;
        this.account = account;
        this.aimAccount = aimAccount;
        this.money = money;
        this.transactionType = transactionType;
        this.statusTransactionType = statusTransactionType;
        this.mementoStorage = new MementoStorage();
    }

    public void repair(){
        TransactionMemento transactionMemento = mementoStorage.getStorage().pop();
        Transaction transaction = TransactionMap.mapTransaction(transactionMemento);
        id = transaction.getId();
        money = transaction.getMoney();
        aimAccount = transaction.getAimAccount();
        account = transaction.getAccount();
        statusTransactionType = transaction.getStatusTransactionType();
        transactionType = transaction.getTransactionType();
    }

    public void createMemento(){
        mementoStorage.getStorage().push(TransactionMap.mapTransactionMemento(this));
    }
}

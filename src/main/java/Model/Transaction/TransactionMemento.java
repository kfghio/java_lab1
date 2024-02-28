package Model.Transaction;

import Model.Accounts.Account;
import Model.Enums.StatusTransactionType;
import Model.Enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class TransactionMemento {
    @NonNull
    private int id;
    @NonNull
    private Account account;
    private Account aimAccount;
    private double money;
    private TransactionType transactionType;
    private StatusTransactionType statusTransactionType;
}

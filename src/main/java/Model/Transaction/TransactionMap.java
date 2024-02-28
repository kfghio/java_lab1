package Model.Transaction;

public class TransactionMap {
    public static Transaction mapTransaction(TransactionMemento transactionMemento){
        return Transaction.builder()
                .transactionType(transactionMemento.getTransactionType())
                .id(transactionMemento.getId())
                .statusTransactionType(transactionMemento.getStatusTransactionType())
                .money(transactionMemento.getMoney())
                .account(transactionMemento.getAccount())
                .aimAccount(transactionMemento.getAimAccount())
                .build();
    }
    public static TransactionMemento mapTransactionMemento(Transaction transaction){
        return TransactionMemento.builder()
                .account(transaction.getAccount())
                .transactionType(transaction.getTransactionType())
                .statusTransactionType(transaction.getStatusTransactionType())
                .aimAccount(transaction.getAimAccount())
                .id(transaction.getId())
                .money(transaction.getMoney())
                .build();
    }
}

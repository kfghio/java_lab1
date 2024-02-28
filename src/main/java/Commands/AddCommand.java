package Commands;

import Model.Enums.StatusTransactionType;
import Model.Transaction.Transaction;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddCommand implements Command
{
    @NonNull
    private Transaction transaction;
    @Override
    public Transaction execute(double limit){
        if(transaction.getAccount().getMoneySum()+transaction.getMoney() > limit)
            throw new ArithmeticException("Out of limit");
        transaction.getAccount().setMoneySum(transaction.getAccount().getMoneySum()+transaction.getMoney());
        transaction.setStatusTransactionType(StatusTransactionType.SUCCEED);
        transaction.createMemento();

        return transaction;
    }
}

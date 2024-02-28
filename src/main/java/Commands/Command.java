package Commands;

import Model.Transaction.Transaction;

public interface Command {
    Transaction execute(double limit);
}

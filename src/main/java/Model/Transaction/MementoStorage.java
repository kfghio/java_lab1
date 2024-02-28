package Model.Transaction;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Stack;

@Getter
@NoArgsConstructor
public class MementoStorage {
    private final Stack<TransactionMemento> storage = new Stack<>();
}

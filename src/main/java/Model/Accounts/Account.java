package Model.Accounts;

import Model.Enums.AccountType;
import lombok.*;

@Builder
@Getter
@Setter

public class Account {
    private int accountID;
    private double moneySum;
    private AccountType accountType;
}

package Model.Accounts;

import Model.Enums.AccountType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class Account {
    private int accountID;
    private int userID;
    private double moneySum;
    private AccountType accountType;

    public Account(int accountID, int userID, double moneySum, AccountType accountType) {
        this.accountID = accountID;
        this.userID = userID;
        this.moneySum = moneySum;
        this.accountType = accountType;
    }
}

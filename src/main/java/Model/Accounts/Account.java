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

    /**
     * @param accountID Account ID
     * @param userID User ID that links the client and account
     * @param moneySum Amount on account
     * @param accountType What type of account: deposit, credit, debit
     */
    public Account(int accountID, int userID, double moneySum, AccountType accountType) {
        this.accountID = accountID;
        this.userID = userID;
        this.moneySum = moneySum;
        this.accountType = accountType;
    }
}

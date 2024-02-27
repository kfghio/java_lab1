package Model.Accounts;

import Model.Enums.AccountType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private int accountID;
    private AccountType accountType;
}

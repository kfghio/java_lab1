package Model.Banks;

import Model.Accounts.Account;
import Model.Clients.Client;
import Model.Procent.Commission;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
public class CommercialBank {

    private final List<Client> users = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();
    private final List<Commission> commissions = new ArrayList<>();
}

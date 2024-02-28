package Model.Banks;

import Model.Accounts.Account;
import Entity.Clients.Client;
import Model.Procent.Commission;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommercialBank {

    private int bankID;
    private final List<Client> users = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();
    private final List<Commission> commissions = new ArrayList<>();
}

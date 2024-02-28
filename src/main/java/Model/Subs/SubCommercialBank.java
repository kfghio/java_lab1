package Model.Subs;

import Entity.Clients.Client;
import Model.Banks.CommercialBank;
import Model.Notice.ClientNotice;
import Model.Other.AccountRep;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SubCommercialBank {
    @NonNull
    private ClientNotice clientNotice;
    @NonNull
    private CommercialBank bank;
    private  final List<Client> clients = new ArrayList<>();

    private final AccountRep accountRep = new AccountRep();

    public void clientRemove(Client client){
        clients.remove(client);
    }

    public void regClient(Client client){
        clients.add(client);
    }

    public void clientNotify(){
        clients.stream().filter(client -> !accountRep.getAccountByID(client.getClientID(), bank,clientNotice.getAccountType()).isEmpty()).forEach(client -> client.update(clientNotice));
    }
}

package Model.Banks;

import Model.Accounts.Account;
import Entity.Clients.Client;
import Model.Notice.BankNotice;
import Model.Other.Limits;
import Model.Procent.Commission;
import Model.Subs.SubCentralBank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter

public class CommercialBank {

    private int bankID;
    private final List<Client> users = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();
    private final List<Commission> commissions = new ArrayList<>();
    private double creaditLimit = Limits.creditLimit;
    private double quastionableLimit = Limits.questionableLimit;
    private final List<BankNotice> notices = new ArrayList<>();

    /**
     * @param bankID The ID of bank that was created
     * @param creaditLimit The amount below which the client cannot go into minus
     * @param quastionableLimit The amount above which the dubious client cannot carry out transactions
     * @param subCentralBank Subscribe to central bank notifications
     */
    public CommercialBank(int bankID, double creaditLimit, double quastionableLimit, SubCentralBank subCentralBank) {
        this.bankID = bankID;
        this.creaditLimit = creaditLimit;
        this.quastionableLimit = quastionableLimit;
        subCentralBank.regBank(this);
    }
    public void updateNotice (BankNotice bankNotice){
        notices.add(bankNotice);
    }
}

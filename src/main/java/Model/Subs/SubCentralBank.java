package Model.Subs;

import Model.Banks.CommercialBank;
import Model.Notice.BankNotice;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SubCentralBank {
    @NonNull
    private BankNotice bankNotice;
    private final List<CommercialBank> banks = new ArrayList<>();

    public void notifyBank(){
        banks.forEach(bank -> bank.updateNotice(bankNotice));
    }

    public void setBankNotice(BankNotice bankNotice){
        this.bankNotice = bankNotice;
        notifyBank();
    }

    public void regBank(CommercialBank bank){
        banks.add(bank);
    }

    public void removeBank(CommercialBank bank){
        banks.remove(bank);
    }
}

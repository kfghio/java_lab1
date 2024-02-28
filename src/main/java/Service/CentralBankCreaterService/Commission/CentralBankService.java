package Service.CentralBankCreaterService.Commission;

import Model.Accounts.Account;
import Model.Banks.CentralBank;
import Model.Banks.CommercialBank;
import Model.Enums.AccountType;
import Model.Other.DatesCommission;
import Model.Procent.Commission;
import Model.Transaction.Transaction;
import lombok.Getter;

@Getter
public class CentralBankService {

    private final CentralBank centralBank;
    private double money;

    /**
     * central bank sevice initialization
     * @param centralBank
     */
    public CentralBankService(CentralBank centralBank) {
        this.centralBank = centralBank;
    }

    public void createBank(CommercialBank commercialBank){
        centralBank.getCommercialBanks().add(commercialBank);
    }

    /**
     * the method provides a transaction between accounts from different banks (transaction between banks)
     * @param transaction
     * @param bank
     * @param aimbank
     */
    public void bankWithBankTransaction(Transaction transaction, CommercialBank bank, CommercialBank aimbank ){
        transaction.getAccount().setMoneySum(transaction.getAccount().getMoneySum() - transaction.getMoney());
        transaction.getAimAccount().setMoneySum(transaction.getAimAccount().getMoneySum() + transaction.getMoney() );
    }

    /**
     * the method skips days and calculates account changes
     * @param days
     * @param account
     * @param bank
     */
    public void validation(int days,Account account, CommercialBank bank ){
        double moneyResult;
        int monthsNumber = days / DatesCommission.month;

        Commission percent = bank.getCommissions().stream().filter(commission -> commission.getAccountType() == account.getAccountType() && commission.getCortege().getFirst() <= money && commission.getCortege().getSecond() >= money).findAny().get();

        double dayPercent = percent.getPercent() / DatesCommission.year;

        for(int i = 0; i < monthsNumber; i++){

            moneyResult = dayPercent * DatesCommission.month * account.getMoneySum();

            if(account.getAccountType() == AccountType.CREDIT)
                money = account.getMoneySum() - moneyResult;
            else
                money = account.getMoneySum() + moneyResult;

            account.setMoneySum(money);
        }

    }

}

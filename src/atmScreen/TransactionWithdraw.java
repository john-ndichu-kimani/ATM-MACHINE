package atmScreen;//This is where the actual transaction of withdrawing occurs

import atmScreen.AtmBankDatabase;
import atmScreen.AtmScreen;
import atmScreen.AtmKeyPad;
import atmScreen.CashDispenser;




public class TransactionWithdraw extends Transaction {
    private AtmKeyPad keyPad;
    private CashDispenser cashDispenser;
    public TransactionWithdraw(AtmKeyPad keyPad,CashDispenser cashDispenser, AtmScreen atmScreen, AtmBankDatabase atmBankDatabase) {
        super(atmScreen, atmBankDatabase);

        this.keyPad=keyPad;
        this.cashDispenser=cashDispenser;

    }
    public TransactionWithdraw(AtmKeyPad atmKeyPad) {

    }

    @Override
    public void execute(){
        //invoking a class to do the concrete transaction withdraw
   new AtmKeyPad();
    }
}
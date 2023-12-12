package org.levelingup;

public class AutomatedTellerMachine implements IAutomatedTellerMachine{
    @Override
    public String checkAccountBalance(String accountNumber) {
        return null;
    }

    @Override
    public String widthdrawMoney(String accountNumber, int amountToWithdraw) {
        return null;
    }

    @Override
    public boolean transferCreditTo(String to) {
        return false;
    }

    @Override
    public boolean transferCreditFrom(String from) {
        return false;
    }
}

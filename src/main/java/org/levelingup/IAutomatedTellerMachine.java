package org.levelingup;

public interface IAutomatedTellerMachine {
    public String checkAccountBalance(String accountNumber);

    public String widthdrawMoney(String accountNumber, int amountToWithdraw);

    public boolean transferCreditTo(String to);

    public boolean transferCreditFrom(String from);
}

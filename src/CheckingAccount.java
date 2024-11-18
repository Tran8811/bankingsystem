
public class CheckingAccount extends Account{
    public CheckingAccount(long accountNumber, double balance) {
         super(accountNumber,balance);
    }


    @Override
    public void deposit(double amount) {
        try {
            super.doDepositing(amount);
            Transaction transaction = new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount,
                    balance - amount, balance);
            super.addTransaction(transaction);
        }  catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            super.doWithdrawing(amount);
            Transaction transaction = new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount,
                    balance + amount, balance);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }

    }
}

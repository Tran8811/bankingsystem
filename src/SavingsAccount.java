public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 1000) {
                throw new InvalidFundingAmountException(amount);
            } else if (balance < 500) {
                throw new InsufficientFundsException(amount);
            } else {
                super.doWithdrawing(amount);
                Transaction transaction = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount,
                        balance + amount, balance);
                super.addTransaction(transaction);
            }
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            super.doDepositing(amount);
            Transaction transaction = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount,
                    balance - amount, balance);
            super.addTransaction(transaction);
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}

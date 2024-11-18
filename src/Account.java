
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList;
    public Account() {
        transactionList = new ArrayList<Transaction>();
    }
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
    public void doWithdrawing(double amount) throws InsufficientFundsException, InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (amount > balance) {
            throw new InsufficientFundsException(amount);
        } else {
            balance -= amount;
        }
    }
    public void doDepositing(double amount) throws  InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }
    public String getTransactionHistory() {
        StringBuilder res = new StringBuilder("Lich su giao dich cua tai khoan " + accountNumber + ":\n");
        for (Transaction t : transactionList) {
            res.append(t.getTransactionSummary());
            res.append("\n");
        }
        return res.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Account) {
            Account another = (Account) o;
            return accountNumber == another.getAccountNumber();
        }
        return false;
    }
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
}

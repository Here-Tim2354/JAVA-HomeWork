package Practice.Practice3.task2.bank;

import java.text.DecimalFormat;

public class CreditAccount extends Account {
    final private double limit;
    public CreditAccount(String id, String name, double balance,double limit) {
        super(id, name, balance);
        this.limit=limit;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "[" + getId() + ", " + getName() + ", " + getBalance() + ", " + limit + "]";
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + limit)) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
}

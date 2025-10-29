package Practice.Practice3.task2.bank;
import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accountlist;
    private int size;

    public AccountManager() {
        this.accountlist = new ArrayList<>();
        this.size = 0;
    }

    public Account[] getAllAccounts() {
        return accountlist.toArray(new Account[0]);
    }

    public int getSize() {
        return size;
    }

    public boolean addAccount(Account account){
        for(Account accountCheck:accountlist){
            if(accountCheck.getId().equals(account.getId())){
                return false;
            }
        }
        accountlist.add(account);
        size++;
        return true;
    }

    public boolean removeAccount(String id){
        Account toRemove=null;
        if(!accountlist.isEmpty()){
            for(Account accountCheck:accountlist){
                if(accountCheck.getId().equals(id)&&(accountCheck.getBalance()==0)){
                    toRemove=accountCheck;
                    break;
                }
            }
            accountlist.remove(toRemove);
            size--;
            return true;
        }
        return false;
    }

    public Account getAccount(String id){
        for(Account accountCheck:accountlist){
            if(accountCheck.getId().equals(id)){
                return accountCheck;
            }
        }
        return null;
    }

    public double getTotalBalance(){
        double sum=0;
        for(Account accountCheck:accountlist){
            sum+=accountCheck.getBalance();
        }
        return sum;
    }

    public int getNumberOfCreditAccount(){
        int count=0;
        for(Account accountCheck:accountlist){
            if(accountCheck instanceof CreditAccount){
                count++;
            }
        }
        return count;
    }
}

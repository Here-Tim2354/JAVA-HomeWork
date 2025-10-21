package Practice.Practice3.task2;
// 将包名修改成自己的包

import Practice.Practice3.task2.bank.Account;
import Practice.Practice3.task2.bank.AccountManager;
import Practice.Practice3.task2.bank.CreditAccount;
import Practice.Practice3.task2.bank.SavingAccount;

public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager(); // 创建

        // 初始账户
        manager.addAccount(new CreditAccount("C001", "Alan", 0, 1000));
        manager.addAccount(new CreditAccount("C002", "Bob", 1000, 2000));
        manager.addAccount(new CreditAccount("C003", "Cat", 2000, 1000));
        manager.addAccount(new SavingAccount("S001", "张三", 1000));
        manager.addAccount(new SavingAccount("S002", "李四", 500));
        manager.addAccount(new SavingAccount("S003", "王五", 2000));
        manager.addAccount(new SavingAccount("S004", "刘六", 100));

        showAccounts(manager.getAllAccounts());
        System.out.printf("共%d个账户，其中信用卡账户%d个，合计余额：%.2f元。\n\n",
                manager.getSize(), manager.getNumberOfCreditAccount(),
                manager.getTotalBalance());

        // 以下测试添加账户
        Account[] newAccounts = {
                new CreditAccount("C001", "CTest01", 0, 1000),
                new CreditAccount("C004", "CTest02", 1234, 1000),
                new SavingAccount("S001", "STest01", 100),
                new SavingAccount("S005", "STest02", 100),
        };
        for (Account account : newAccounts) {
            if (manager.addAccount(account)) {
                System.out.println(account + "添加成功.");
            } else {
                System.out.println(account + "添加失败.");
            }
        }

        showAccounts(manager.getAllAccounts());
        System.out.printf("共%d个账户，其中信用卡账户%d个，合计余额：%.2f元。\n\n",
                manager.getSize(), manager.getNumberOfCreditAccount(),
                manager.getTotalBalance());

        // 测试存款和取款操作
        Account account = manager.getAccount("C003");
        System.out.println("取款前：" + account);
        if (account.withdraw(2000)) {
            System.out.println("取款[2000.00]后，" + account);
        } else {
            System.out.println("取款[2000.00]余额不足.");
        }
        if (account.withdraw(500)) {
            System.out.println("取款[500.00]后，" + account);
        } else {
            System.out.println("取款[500.00]余额不足.");
        }
        if (account.withdraw(800)) {
            System.out.println("取款[800.00]后，" + account);
        } else {
            System.out.println("取款[800.00]余额不足.");
        }
        account.deposit(1500);
        System.out.println("存入[1500.00]后，" + account);
        showAccounts(manager.getAllAccounts());
        System.out.printf("共%d个账户，其中信用卡账户%d个，合计余额：%.2f元。\n\n",
                manager.getSize(), manager.getNumberOfCreditAccount(),
                manager.getTotalBalance());

        if (manager.removeAccount("C008")) {
            System.out.println("账号为[C008]的账户删除成功.");
        } else {
            System.out.println("账号为[C008]的账户删除失败.");
        }
        if (manager.removeAccount("S001")) {
            System.out.println("账号为[S001]的账户删除成功.");
        } else {
            System.out.println("账号为[S001]的账户删除失败.");
        }
        showAccounts(manager.getAllAccounts());

        System.out.printf("共%d个账户，其中信用卡账户%d个，合计余额：%.2f元。\n\n",
                manager.getSize(), manager.getNumberOfCreditAccount(),
                manager.getTotalBalance());
    }

    public static void showAccounts(Account[] list) {
        System.out.println("所有账户：");
        for (Account account : list) {
            System.out.println(account);
        }
        System.out.println("-".repeat(50));
    }
}

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    // 无参数构造方法，创建默认账户
    public Account() {
        this(0, 0); // 调用另一个构造方法
    }

    // 创建指定id和初始余额的账户的构造方法
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    // 访问器和修改器
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // 返回月利率的方法
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // 从账户提取特定数额的方法
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    // 向账户存储特定数额的方法
    public void deposit(double amount) {
        this.balance += amount;
    }
}

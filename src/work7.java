public class work7{
    public static void main(String[] args) {
        // 创建账户对象
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);

        // 进行交易
        account.withdraw(2500);
        account.deposit(3000);

        // 打印信息
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest Rate: " + account.getMonthlyInterestRate() + "%");
        System.out.println("Date Created: " + account.getDateCreated());
    }
}

import java.util.Date;
import java.util.Scanner;

public class work8{
    public static void main(String[] args) {
        Account[] accounts = new Account[10];

        // 初始化账户
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(100 + i, 100);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Account id: ");
            int id = scanner.nextInt();

            // 验证账户ID
            if (id < 100 || id >= 110) {
                System.out.println("Invalid ID. Please try again.");
                continue;
            }

            Account currentAccount = accounts[id - 100];

            // 显示主菜单
            boolean exit = false;
            while (!exit) {
                System.out.println("\nMain menu:");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: // 查看余额
                        System.out.println("The balance is " + currentAccount.getBalance());
                        break;
                    case 2: // 取钱
                        System.out.print("Enter an amount to withdraw: ");
                        currentAccount.withdraw(scanner.nextDouble());
                        break;
                    case 3: // 存钱
                        System.out.print("Enter an amount to deposit: ");
                        currentAccount.deposit(scanner.nextDouble());
                        break;
                    case 4: // 退出菜单
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}

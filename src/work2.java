import java.util.Scanner;

public class work2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter profit amount (in yuan): ");
        double profit = scanner.nextDouble();
        double bonus = 0;
        double test2 = 4;
        if (profit <= 100000) {
            bonus = profit * 0.10;
        } else if (profit <= 200000) {
            bonus = 100000 * 0.10 + (profit - 100000) * 0.075;
        } else if (profit <= 400000) {
            bonus = 100000 * 0.10 + 100000 * 0.075 + (profit - 200000) * 0.05;
        } else if (profit <= 600000) {
            bonus = 100000 * 0.10 + 100000 * 0.075 + 200000 * 0.05 + (profit - 400000) * 0.03;
        } else if (profit <= 1000000) {
            bonus = 100000 * 0.10 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + (profit - 600000) * 0.015;
        } else {
            bonus = 100000 * 0.10 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 400000 * 0.015 + (profit - 1000000) * 0.01;
        }

        // 输出奖金
        System.out.println("The bonus is: " + bonus + " yuan");
    }
}
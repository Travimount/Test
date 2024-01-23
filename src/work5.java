import java.util.Random;

public class work5{
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];

        // 生成并打印原始数组
        System.out.println("Original Array:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // 生成0到99之间的随机整数
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n");

        // 打印偶数索引的元素
        System.out.println("Elements at even indexes:");
        for (int i = 0; i < numbers.length; i += 2) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n");

        // 打印所有偶数元素
        System.out.println("Even elements:");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println("\n");

        // 打印逆序数组
        System.out.println("Array in reverse order:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n");

        // 打印第一个和最后一个元素
        System.out.println("First and last elements:");
        if (numbers.length > 0) {
            System.out.println("First element: " + numbers[0]);
            System.out.println("Last element: " + numbers[numbers.length - 1]);
        }
    }
}

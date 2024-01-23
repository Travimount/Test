public class work3 {
    public static void main(String[] args) {
        int totalPrizes = 50;
        int totalWinners = 30;

        System.out.println("All possible distributions of awards:");
        for (int firstPrize = 0; firstPrize <= totalWinners; firstPrize++) {
            for (int secondPrize = 0; secondPrize <= totalWinners - firstPrize; secondPrize++) {
                int thirdPrize = totalWinners - firstPrize - secondPrize;
                if (firstPrize * 3 + secondPrize * 2 + thirdPrize == totalPrizes) {
                    System.out.println("First Prize: " + firstPrize + ", Second Prize: " + secondPrize + ", Third Prize: " + thirdPrize);
                }
            }
        }
    }
}

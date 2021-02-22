public class PrimeNumbers1 {
    public static void main(String[] args) {
        int maxNumber = 100;

        for (int i = 2; i < maxNumber; i++) {
            int numberOfDividers = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    numberOfDividers++;
                }
            }
            if (numberOfDividers == 0) {
                System.out.println(i + " is a prime number");
            }
        }
    }
}

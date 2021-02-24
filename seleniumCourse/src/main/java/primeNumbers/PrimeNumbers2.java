package primeNumbers;

public class PrimeNumbers2 {
    public static void main(String[] args) {
        int maxNumber = 100;

        for (int i = 2; i < maxNumber; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                System.out.println(i + " is a prime number");
            }
        }
    }
}

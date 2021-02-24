package primeNumbers;

public class PrimeNumbers0 {
    public static void main(String[] args) {

        for (int i = 2; i < 10; i++) {
            int x = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    x = x + 1;
                }
            }
            if (x == 0) {
                System.out.println(i + " is a prime number");
            }
        }
    }
}

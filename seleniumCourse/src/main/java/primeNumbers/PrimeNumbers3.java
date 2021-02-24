package primeNumbers;

import com.sun.xml.internal.bind.v2.TODO;

public class PrimeNumbers3 {
    public static void main(String[] args) {
        int maxNumber = 100;

        for (int i = 2; i < maxNumber; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j < Math.round(i/2); j++) {

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

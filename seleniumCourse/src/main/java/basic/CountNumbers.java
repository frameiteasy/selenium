package basic;

public class CountNumbers {
    public static void main(String[] args) {

        CountNumbers cn = new CountNumbers();
        cn.run();
    }

    public void run(){
        int divFirst = 7;
        int divSecond = 5;

        int limit = 200;

        for (int i = 1; i <= limit; i++){
            if ((isDivided(i, divFirst)) && (isDivided(i, divSecond))) {
                System.out.println(i + " jest podzielne przez " + divFirst + " i przez " + divSecond);
            }
        }
    }

    private boolean isDivided(int number, int div){
        return (((number % div) == 0));
    }
}

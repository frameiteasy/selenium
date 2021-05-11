package basic;

import java.util.ArrayList;

public class CountNumbers {
    public static void main(String[] args) {

        CountNumbers cn = new CountNumbers();
        ArrayList<Integer> finalResult = cn.run(5, 7, 200);
        System.out.println(finalResult.toString());
        System.out.println(cn.toString());
        cn.printResults(finalResult, 5, 7);
    }

    public ArrayList<Integer> run(int divFirst, int divSecond, int limit){

        ArrayList<Integer> listOfResults = new ArrayList<Integer>();

        for (int i = 1; i <= limit; i++){
            if ((isDivided(i, divFirst)) && (isDivided(i, divSecond))) {
                listOfResults.add(i);
            }
        }
        return listOfResults;
    }

    public void printResults(ArrayList<Integer> results, int div1, int div2){
        if (results.isEmpty()){
            System.out.println("There are no results");
        } else {
            for (int i = 0; i < results.size(); i++ ){
                //System.out.println(results.get(i));
                System.out.println(formatString(results.get(i), div1, div2));
            }
        }
    }

    private boolean isDivided(int number, int div){
        return (((number % div) == 0));
    }

    private String formatString(int number, int div1, int div2){
        return number + " jest podzielne przez " + div1 + " i przez " + div2;
    }


}

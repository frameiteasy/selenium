package basic;

public class ChristmasTree {
    public static void main(String[] args) {
        drawHalfTree(3);
        drawTree(5);
    }
    private static void drawHalfTree(int height){

        for(int i=1; i<= height; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void drawTree(int height){
        for(int i = 1; i <= height; i++){
            for(int j = height - i; j >= 0; j--){
                System.out.print(" ");
            }
            for(int k = 1; k <= 2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

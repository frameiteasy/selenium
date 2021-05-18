package basic;

public class Triangle {
    public static void main(String[] args) {
        drawTriangle(5);
    }

    public static void drawTriangle(int height){
        for(int i = 1; i <= height; i++){
            for(int j = height - i; j >= 0; j-- ){
                System.out.print(" ");
            }
            System.out.print("*");

            for(int l = 1; l <= 2*i-1; l++){
                System.out.print(" ");

            }
            System.out.println("*");
        }
    }
}

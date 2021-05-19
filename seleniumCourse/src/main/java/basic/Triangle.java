package basic;

public class Triangle {
    public static void main(String[] args) {
        drawTriangle(7);
    }
    public static void drawTriangle(int height) {
        int z = -1;
        for (int i = 1; i <= height; i++) {
            for (int j = height - i; j >= 0; j--) {
                System.out.print(" ");
            }
            System.out.print("*");

            if (i > 1) {
                for (int l = 1; l <= i + z; l++) {
                    if (i == height) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                z++;
                System.out.println("*");
            } else {
                System.out.println();
            }
        }

    }
}

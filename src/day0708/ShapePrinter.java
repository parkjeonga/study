package day0708;


  public class ShapePrinter {
    public void printPyramid(int height) {
        // 코드를 입력하세요.
        for (int i = 1; i <= height;i++){
        for (int j = 1; j < height; i++){
            System.out.print(" ");
        } 
        for (int j = 1; j <= i; i++){
            System.out.print("*");
        }
        System.out.println();
        }
    }

}
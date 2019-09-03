public class Stars {
      public static void main(String[] args) {
            line(13);
            line(7);
            line(35);
            box(10, 3);
            box(5, 4);
            repeat("$", 11);
      }
      
      public static void line(int length) {
            for(int i = 1; i <= length; i++){
                  System.out.print("*");
            }
            System.out.println();
      }
      
      public static void line() {
            line(10);
      }
      
      public static void repeat(String character, int length){
            for (int i = 1; i <= length; i++){
                  System.out.print(character);
            }
            System.out.println();
      }
      
      public static void box(int width, int height) {
            line(width);
            for(int h = 1; h <= height-2; h++) {
                  System.out.print("*");
                  
                  for(int i = 1; i <= width-2; i++){
                        System.out.print(" ");
                  }
                  
                  System.out.println("*");
            }
            line(width);
      }

      public static void box() {
            box(5, 5);
      }
}
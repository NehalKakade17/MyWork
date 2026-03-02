public class PatternPrinter {
      public static void main(String[] args) {
            int counter = 1;
            int currentRow = 1;
            int rows = 5;
            System.out.println(" Printing the Pattern : ");
            System.out.println("0");
            for (int i = rows; i >= 1; i--) {
                  for (int j = i; j <= rows; j++) {
                        System.out.print(j);
                  }
                  System.out.print("0");
                  for (int k = rows; k >= i; k--) {
                        System.out.print(k);
                  }
                  System.out.println();
            }
      }
}

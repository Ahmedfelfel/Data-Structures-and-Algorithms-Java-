import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      /* read the name of the user */
      String name = scan.nextLine();
      /* print out "Hello, " followed by the name (see description) */
      System.out.println("Hello, "+name);
   }
}
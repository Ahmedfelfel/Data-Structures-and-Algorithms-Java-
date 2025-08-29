public class Main {
   public static void main(String[] args) {
      System.out.println("fib(20) is " + fib(20));
      System.out.println("fib(48) is " + fib(48));
   }

   static long fib(long n) {
      // implement the recursive Fibonacci here
      if (n<=1)
         return n;
      else
         return fib(n-1)+fib(n-2);
   }
}
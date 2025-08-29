import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read all numbers
        int N = sc.nextInt();

        // For each number,
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();

            // Convert num to binary using stack
            Stack<Integer> binary = new Stack<>();
            /* TODO: modulo and divide by 2 (see task descirption) */
            while (num > 0){
            binary.push(num % 2);
            num /= 2;}
            // Print the binary out
            while (!binary.isEmpty()) {
                System.out.print(binary.pop());
            }
            System.out.println();
        }

        sc.close();
    }
}

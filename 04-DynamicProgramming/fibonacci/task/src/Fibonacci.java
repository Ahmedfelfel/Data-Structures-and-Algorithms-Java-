import java.util.Arrays;

public class Fibonacci {
    private final Long [] fib;

    public Fibonacci(int n) {
        fib = new Long[n];

        Arrays.fill(fib, null);
        fib[0] = 0L;
        fib[1] = 1L;
    }

    public long of(int n) {
        if (fib[n] != null ) return fib[n];
        else {
            /* TODO: implement a top-down DP Fibonacci using memoization technique */
            fib[n]=of(n-1)+of(n-2);
            return fib[n];
        }
    }
}
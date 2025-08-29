
We have once learnt the recurrence relation of Fibonacci, that is
$$
\text{fib}(n)~=~\begin{cases}
n & , \text{if}\ n \leq 1 \\\\
\text{fib}(n-1)+\text{fib}(n-2) & , \text{otherwise.}
\end{cases}
$$

Now, try implement it (once again).

Notice that the method signature is now `private static long of(int n)`, 
so it is aesthetically called by `Fibonacci.of(10)`, for instance.


Implement the 0-1 knapsack algorithm from the recurrence relation below.

$$
F(i,c)=\begin{cases}
0 & , c \leq 0~\text{or}~i < 0 \\\\
F(i-1, c) & , w_i > c \\\\
\max(v_i+F(i-1, c-w_i), F(i-1,c)) & , \text{otherwise,}
\end{cases}
$$

where $i$ is the item number, $c$ is remaining capacity, $v_i$ is value of the item and $w_i$ is weight of the item.
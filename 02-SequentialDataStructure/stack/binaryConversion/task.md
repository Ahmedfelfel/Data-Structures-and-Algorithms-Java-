
To convert any integer into binary,
you will need to do modulo and divide by 2 until the number cannot be further divided.

For example, 12 in base-10

- 12 % 2 is 0
- 6 % 2 is 0
- 3 % 2 is 1
- 1 % 2 is 1

Notice that the result of modulo operations are 0, 0, 1 and 1
which can be written in reversed order as 1100.
Also,

$$ (1\times2^3) + (1\times2^2) + (0\times2^1) + (0\times2^0) = 8 + 4 = 12 $$

thus 12 in base-10 is 1100 in base-2.

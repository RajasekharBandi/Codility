import java.util.*;
/*
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:

class Solution { public int solution(int N, int M); }

that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

Assume that:

N and M are integers within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(log(N+M));
expected worst-case space complexity is O(log(N+M)).
 */

public class ChocolatesByNumbers {

	public static int solution(int N, int M) {
        if (N == 1) return 1;
        
        int m = M % N;
        if (m == 0) return 1;
        if (m == 1) return N;
        
        return (N / gcd(N, m));
    }
    
    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        
        return b;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(10,4));
    }

    public static int solution2(int N, int M) {
        Set<Integer> set = new HashSet<>();
        int i=0;
        while (!set.contains(i)){
            set.add(i);
            i= (i+M)%N;
        }
        return set.size();
    }
}

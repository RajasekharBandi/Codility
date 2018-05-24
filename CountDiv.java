import java.util.*;
/*
 * Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Assume that:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Complexity:

expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).
 */
public class CountDiv {
	
	 public int solution(int A, int B, int K){
	       return (int) Math.ceil((double) (B-A)/(double) K);
	    }
	 public int solution2(int A, int B, int K) {
	        if (B < K) {
	            return (A == 0) ? 1 : 0;
	        }
	        
	        int firstRemainder = A % K;
	        int firstPossibleDivisible = A + (K - firstRemainder) % K;
	        return (firstPossibleDivisible > B) ? 0 : ((B - firstPossibleDivisible) / K + 1);
	    }

	 public int solution5(int A, int B, int K) {
	        int first = A % K == 0 ? A : A + (K - A % K);
	        int last = B % K == 0 ? B : B - B % K; //B/K behaves this way by default.
	        return (last - first) / K + 1;
	    }
}

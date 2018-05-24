/*
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */

public class PassingCarss {
	 public static int solution(int[] A) {
	        int mul = 0;
	        int sum = 0;
	        for (int i = 0; i < A.length; i++) {
	            if (A[i] == 0) {
	                mul++;
	            } else {
	                sum = sum + mul;
	            }

	            if (sum > 1000000000) {
	                return -1;
	            }
	        }
	        return sum;
	    }
	 public static int solution2(int[] A) {
	        int pairCount = 0;
	        int zeroCount = 0;
	        
	        for (int i = 0; i < A.length; i++) {
	            if (A[i] == 0) {
	                zeroCount++;
	            } else {
	                pairCount += zeroCount;
	                
	                if (pairCount > 1000000000) return -1;
	            }
	        }
	        
	        return pairCount;
	    }

	  public int solution5(int[] A) {
	        int factor = 0;
	        int pairSum = 0;

	        for (int i = 0; i < A.length; i++) {
	            if (A[i] == 0) factor++;
	            else if (A[i] == 1) pairSum += factor;
	        }

	        if (pairSum > 1000000000) return -1;
	        return pairSum;
	    }
	  
	    public static void main(String[] args){
	        int[] arr1={0,1,0,1,1};
	        int[] arr2={1,3,4};
	        System.out.println(solution(arr1));
//	        System.out.println(solution(arr2));
	    }

}

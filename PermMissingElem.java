import java.util.Arrays;

/*
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
public class PermMissingElem {
	 public static int solution(int[] A) {
	        int length = A.length;
	        
	        if (length == 0) return 1;
	        if (length == 1) {
	            return (A[0] == 1) ? 2 : 1; 
	        }
	        
	        Arrays.sort(A);
	        if (A[0] != 1) return 1;
	        if (A[length - 1] != (length + 1)) return (length + 1);
	        
	        int missed = 0;
	        for (int i = 1; i < length; i++) {
	            if (A[i - 1] + 1 != A[i]) {
	                missed = A[i - 1] + 1;
	            }
	        }
	        
	        return missed;
	    }

	 public static int solution2(int[] A){
	        int sumAll=0;
	        int sumMiss=0;
	        for(int i=0;i<A.length;i++){
	            sumAll=sumAll+i;
	            sumMiss=sumMiss + A[i];
	        }
	        sumAll=sumAll+A.length+A.length+1;
	        return sumAll-sumMiss;
	    }

	 public int solution5(int[] A) {
	        int minSum = Integer.MAX_VALUE;

	        for (int p = 0; p < A.length; p++) {
	            int first = 0;
	            int last = 0;
	            for (int i = 0; i < A.length; i++) {
	                if (i <= p) first += A[i];
	                else last += A[i];
	            }
	            int sum = Math.abs(first - last) > 0 ? Math.abs(first - last) : minSum;
	            if (sum < minSum) minSum = sum;

	        }

	        return minSum;
	    }
	 
	    public static void main(String[] args){
	        int[] arr1={1,2,3,4,5};
	        int[] arr2={2,3,4,5,6};
	        int[] arr3={1,2,3,4,6};
	        int[] arr4={1,2,4,5,6};
	        System.out.println(solution(arr1));
	        System.out.println(solution(arr2));
	        System.out.println(solution(arr3));
	        System.out.println(solution(arr4));
	    }
	    
}

import java.util.*;
/*
 * A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:

double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.

Assume that:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MaxDoubleSliceSum {

	public static int solution(int[] A) {
        int length = A.length;
        if (length == 3) return 0;
        
        int[] sumFromLeft = new int[length];
        int[] sumFromRight = new int[length];
        
        for (int i = 1; i < length - 1; i++) {
            sumFromLeft[i] = Math.max(sumFromLeft[i - 1] + A[i], 0);
        }
        
        for (int i = length - 2; i > 0; i--) {
            sumFromRight[i] = Math.max(sumFromRight[i + 1] + A[i], 0);
        }
        
        int maxSum = 0;
        for (int i = 1; i < length - 1; i++) {
            maxSum = Math.max(maxSum, sumFromLeft[i - 1] + sumFromRight[i + 1]);
        }
        
        return maxSum;
    }
	 public static int solution2(int[] A) {
	        int max_ending=0;
	        int max_slice=0;
	        for(int a:A){
	            max_ending=Math.max(0,max_ending+a);
	            max_slice=Math.max(max_slice,max_ending);

	            System.out.println("max_ending: " + max_ending +" max_slice: "+ max_slice);
	        }

	        return max_slice;
	    }

	    public static void main(String[] args) {
//	        int[] arr={3,1,2,4,3};
	        int[] arr = {4, 2, 2, 3, 5, 1, 5, 8};
//	        int[] arr = {-1,-2,-3,-4};
	        System.out.println(solution(arr));
	    }

	    public int solution5(int[] A) {//CodilityJavaSolutions
	        int N = A.length;
	        int[] K1 = new int[N];
	        int[] K2 = new int[N];

	        for(int i = 1; i < N-1; i++){
	            K1[i] = Math.max(K1[i-1] + A[i], 0);
	        }
	        for(int i = N-2; i > 0; i--){
	            K2[i] = Math.max(K2[i+1]+A[i], 0);
	        }

	        int max = 0;

	        for(int i = 1; i < N-1; i++){
	            max = Math.max(max, K1[i-1]+K2[i+1]);
	        }

	        return max;
	    }
}

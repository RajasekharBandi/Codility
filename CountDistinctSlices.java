import java.util.*;
/*
 * An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A are less than or equal to M.

A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q].
 A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.

For example, consider integer M = 6 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2
There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).

The goal is to calculate the number of distinct slices.

Write a function:

class Solution { public int solution(int M, int[] A); }

that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.

If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.

For example, given integer M = 6 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2
the function should return 9, as explained above.

Assume that:

N is an integer within the range [1..100,000];
M is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..M].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(M) (not counting the storage required for input arguments).
 */
public class CountDistinctSlices {
	public static void main(String[] args) {
        int[] test = new int[]{10,10};

        /* some lambda test */
        Integer[] testIntegers = new Integer[test.length];
        for(int i = 0; i < testIntegers.length; i++) testIntegers[i] = test[i];
        int val = Integer.MIN_VALUE;
        List<Integer> list = Arrays.asList(testIntegers);
        Integer maxval = list.stream()
                                    .max(Comparator.comparing(i -> i))
                                    .get();
        System.out.println("MaxVal: " + maxval);
        /* end of lamda tests */


        /* find max val from input array */
        for (int x = 0; x < test.length; x++) {
            if (test[x] > val) {
                val = test[x];
            }
        }

        CountDistinctSlices countDistinctSlices = new CountDistinctSlices();
        int result = countDistinctSlices.solution(val, test);
        System.out.println("Result: " + result);
    }

    private int solution(int M, int[] A) {
        int N = A.length;
        if(N==1) return 1;
        if(N==0) return 0;
        boolean[] flag = new boolean[M+1];
        int left = 0;
        int right = 0;
        int counter = 0;

        while(left < N && right < N) {
            if(flag[A[right]] == false) {
                counter += (right - left + 1); // @+1 stands for possible of 1 element slice (i,i);
                if(counter >= 1000000000) return 1000000000;

                flag[A[right]] = true;
                right++;
            } else {
                flag[A[left]] = false;
                left++;
            }
        }
        return counter;
    }
}

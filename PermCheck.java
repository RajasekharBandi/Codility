import java.util.*;
/*
 * A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class PermCheck {
    public static int solution(int[] A) {
        Arrays.sort(A);
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] - 1 != i) return 0;
        }
        
        return 1;
    }
    
    public static int solution2(int[] A){
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1){
                return 0;
            }
        }
        return 1;
    }
    public static int solution3(int[] a) {//Codility-solutions

		int arraySize = a.length;
		boolean[] elemPresent = new boolean[arraySize];

		for (int i = 0; i < elemPresent.length; i++) {

			int x = a[i];

			if (a[i] > arraySize) {
				return 0;
			}

			if (elemPresent[x - 1]) {
				return 0;
			} else {
				elemPresent[x - 1] = true;
			}

		}
		return 1;
	}

    public int solution5(int[] A) {
        Arrays.sort(A);

        for (int i = 0 ; i < A.length ; i++){
            if (i+1 != A[i]) return 0;
        }

        return 1;
    }
    public static void main(String[] args){
        int[] arr1={1,2,3,4};
        int[] arr2={1,3,4};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

}

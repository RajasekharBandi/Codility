/*
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

The sequence should be returned as:

a Results structure (in C), or
a vector of integers (in C++), or
a Results record (in Pascal), or
an array of integers (in any other programming language).
For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Assume that:

N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P, Q is an integer within the range [0..N − 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
Complexity:

expected worst-case time complexity is O(N+M);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

public class GenomicRangeQuery {
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
	
	public int solution5(int[] A) {
        double minAvgValue = (A[0] + A[1]) / 2.0;   // The mininal average
        int minAvgPos = 0;    // The begin position of the first
        // slice with mininal average

        for (int i = 0; i < A.length - 2; i++) {
            //Try the next 2 - element slice
            if ((A[i] + A[i + 1]) / 2.0 < minAvgValue) {
                minAvgValue = (A[i] + A[i + 1]) / 2.0;
                minAvgPos = i;
            }

            //Try the next 3 - element slice
            if ((A[i] + A[i + 1] + A[i + 2]) / 3.0 < minAvgValue) {
                minAvgValue = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                minAvgPos = i;
            }

        }

        //try the last 2 - element slice
        if ((A[A.length - 1] + A[A.length - 2]) / 2.0 < minAvgValue) {
            minAvgValue = (A[A.length - 1] + A[A.length - 2]) / 2.0;
            minAvgPos = A.length - 2;
        }

        return minAvgPos;
    }

    public static void main(String[] args){
        int[] arr1={0,1,0,1,1};
        int[] arr2={1,3,4};
        System.out.println(solution(arr1));
//        System.out.println(solution(arr2));
    }

}

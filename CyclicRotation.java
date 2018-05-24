import java.util.*;

/*
 * An array A consisting of N integers is given. 
 * Rotation of the array means that each element is shifted right by one index, 
 * and the last element of the array is moved to the first place.
 *  For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
 *  (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:
class Solution { public int[] solution(int[] A, int K); }
that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given
    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:
    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given
    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]
Given
    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]
Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 */
public class CyclicRotation {
	public static void main(String arg[])
	{
		int[]A={3, 8, 9, 7, 6};
		System.out.println(Arrays.toString(CyclicRotation.solution2(A,3)));
		int[]A2={0,0,0};
		System.out.println(Arrays.toString(CyclicRotation.solution2(A2,1)));
		int[]A3={1,2,3,4};
		System.out.println(Arrays.toString(CyclicRotation.solution2(A3,4)));
		System.out.println(Arrays.toString(CyclicRotation.solution2(A3,11)));
	}
	
    public static int[] solution(int[] A, int K)
    {
    	K=K%A.length;
        K=A.length-K;
        System.out.println("Updated Rotations:"+K);
        List<Integer> list=new ArrayList();
        for(int i=K;i<A.length;i++)
        {
            list.add(A[i]);
        }

        for(int i=0;i<K;i++){
            list.add(A[i]);
        }
       return list.stream().mapToInt(i->i).toArray();
    }
    public static int[] solution2(int[] A, int K) {
        if (A.length == 0) { return A; }

        int length = A.length;
        int rotations = K % length;
        

        if (rotations == 0) {
            return A;
        } else {
            int[] rotated = new int[length];

            int[] latter = Arrays.copyOfRange(A, (length - rotations), length);
            
            int[] former = Arrays.copyOfRange(A, 0, (length - rotations));

            for (int i = 0; i < latter.length; i++) {
                rotated[i] = latter[i];
            }

            for (int i = 0; i < former.length; i++) {
                rotated[i + latter.length] = former[i];
            }

            return rotated;
        }
    }
    
    public static int[] solution3(int[] a, int n) {//codility-solutions

		int[] copy = new int[a.length];
		System.arraycopy(a, 0, copy, 0, a.length);

		int rotation = n - 1;
		int newIndex;
		for (int i = 1; i <= a.length; i++) {
			newIndex = (i + rotation) % a.length;
			a[newIndex] = copy[i - 1];
		}
		return a;
	}
    
    public int[] solution4(int[] A, int K) {//Codility-lessons

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[(i + K) % A.length] = A[i];
        }
        return result;
    }
    
    public int[] solution5(int[] A, int K) {
        int[] response = new int[A.length];

        try {
            int pos = -1;
            if (K > A.length) {
                K = K % A.length;
            }

            for (int i = 0; i < A.length; i++) {

                if ((i + K) > A.length - 1) {
                    pos = Math.abs(A.length - K - i);
                } else {
                    pos = i + K;
                }
                response[pos] = A[i];
            }
        } catch (Exception e) {
            return response;
        }


        return response;
    }
}
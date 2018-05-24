import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * A non-empty array A consisting of N integers is given. 
 * The array contains an odd number of elements, and each element of the array can be paired with another element
 *  that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Assume that:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */

public class OddOccurrencesInArray {
	
	 public int solution1(int[] A) {
	        int[] array = A;
	        Arrays.sort(array);

	        int candidate = array[0];

	        for (int i = 1; i < array.length; i++) {
	            if (candidate == -1) {
	                candidate = array[i];
	            } else if (array[i] == candidate) {
	                candidate = -1;
	            } else {
	                break;
	            }
	        }

	        return candidate;
	    }
	 
	public static int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int a : A) {
        	System.out.println(a);
            boolean b = set.contains(a) ? set.remove(a) : set.add(a);
        }
        return set.iterator().next();
    }
	
	public static int solution3(int[] array) {//Codility Solutions

		HashMap<Integer, Integer> occurances = new HashMap<>();

		for (int e : array) {
			if (occurances.containsKey(e)) {
				occurances.remove(e);
			} else {
				occurances.put(e, 1);
			}
		}

		List<Integer> oddList = new ArrayList<Integer>(occurances.keySet());
		return oddList.get(0);
	}
	
	public int solution4(int[] A) {//Codility-lessons
        int val = 0;
        for (int item : A) {
            val = val ^ item;
        }
        return val;
    }
	
	public int solution5(int[] A) {
        HashSet<Integer> items = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (items.contains(A[i])) {
                items.remove(A[i]);
            } else {
                items.add(A[i]);
            }
        }

        int itemToReturn = -1;
        for (Integer a : items) {
            itemToReturn = a;
        }
        return itemToReturn;
    }
    public static void main(String[] args){
        int[] arr={9,3,9,3,7,9,9};
        System.out.println(solution(arr));
    }
    

}

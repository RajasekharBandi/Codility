import java.util.*;
import java.util.HashSet;
import java.util.Set;
/*
 * This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MissingInteger {
	
	   public int solution(int[] A){
	        Set<Integer> set = new HashSet<>();
	        for(int a:A){
	            set.add(a);
	        }
	        int i=1;
	        while (set.contains(i)){
	            i++;
	        }
	        return i;
	    }
	   
	    public int solution2(int[] A) {
	        Set<Integer> set = new HashSet<>();
	        for (int i: A) {
	            set.add(i);
	        }
	        Integer[] newA = set.toArray(new Integer[set.size()]);
	        Arrays.sort(newA);
	        
	        int firstPositiveIndex = -1;
	        for (int i = 0; i < newA.length; i++) {
	            if (newA[i] > 0) {
	                firstPositiveIndex = i;
	                break;
	            }
	        }
	        
	        if (firstPositiveIndex == -1) return 1;
	        
	        int smallest= 0;
	        for (int i = firstPositiveIndex; i < newA.length; i++) {
	            if (i == firstPositiveIndex && newA[i] > 1) {
	                smallest = 1;
	                break;
	            }
	            
	            if (i == newA.length - 1 || newA[i] + 1 != newA[i + 1]) {
	                smallest = newA[i] + 1;
	                break;
	            }
	        }
	        
	        return smallest;
	    }
	    
	    public static int solution3(int[] a) {//Codility-solutions

			HashSet<Integer> elements = new HashSet<>();
			for (int i : a) {
				elements.add(i);
			}

			int count = 1;
			while (elements.contains(count)) {
				count++;
			}
			return count;
		}

	    public static int solution4(int[] A) {//Codility-lessons

	        Integer[] array = Arrays.stream(A).boxed().toArray(Integer[]::new);
	        HashSet<Integer> set = new HashSet(Arrays.asList(array));

	        int minValue = 1;

	        while (set.contains(minValue)) {
	            minValue++;
	        }

	        return minValue;
	    }
	    
	    public int solution5(int[] A) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i : A) {
	            if (map.get(new Integer(i)) == null) {
	                map.put(new Integer(i), 1);
	            } else {
	                map.put(new Integer(i), map.get(new Integer(i)) + 1);
	            }
	        }
	        int c = 1;
	        while (map.get(new Integer(c)) != null) {
	            c++;
	        }
	        return c;
	    }
	    
}

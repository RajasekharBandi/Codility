import java.util.Stack;

/*
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.



Assume that:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class StoneWall {

	   public static int solution(int[] A){

	        return 0;
	    }

	    public static void main(String[] args) {
//	        int[] arr={3,1,2,4,3};
//	        int[] arr = {4, 2, 2, 3, 5, 1, 5, 8};
	        int[] arr = {5, -7, 3, 5, -2,4,-1};
	        System.out.println(solution(arr));
	    }
	    
	    public int solution2(int[] H) {
	        Stack<Integer> stack = new Stack<>();
	        int blocks = 0;
	        
	        for (int i: H) {
	            while (!stack.isEmpty() && stack.peek() > i) {
	                stack.pop();
	            }
	            
	            if (!stack.isEmpty() && stack.peek() == i) {
	                continue;
	            } else {
	                blocks++;
	                stack.push(i);
	            }
	        }
	        
	        return blocks;
	    }
}

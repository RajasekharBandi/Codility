import java.util.*;
/*
 * An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Assume that:

N is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).
 */
public class MinPerimeterRectangle {

	public int solution(int N) {
        double sqrt = Math.sqrt(N);
        int minHalfPeri = 0;
        int i = 1;
        
        while (i <= sqrt) {
            if (N % i == 0) {
                minHalfPeri = i + (N / i);
            }
            i++;
        }
        
        return (minHalfPeri * 2);
    }
	
	 public int solution2(int N){
	        int i=1;
	        int min=Integer.MAX_VALUE;
	        while (i*i<N){
	            if(N%i==0){
	                int other=N/i;
	                min=Math.min(min,2*(i+other));
	            }
	            i+=1;
	        }
	        if(i*i==N){
	            min=Math.min(min,2*(i+i));
	        }
	        return min;
	    }
	 
	 public int solution5(int N) {//CodilityJavaSolutions
	        // write your code in Java SE 8
	        int minPerimeter = Integer.MAX_VALUE;
	        int curPerimeter = Integer.MAX_VALUE;
	        int result = 0;
	        for(int i = 1; i * i <= N; i++) {
	            if(N % i == 0) {
	                int A = i;
	                int B = N / i;
	                curPerimeter = (A + B) * 2;
	                minPerimeter = Math.min(minPerimeter, curPerimeter);
	            }
	        }
	        return minPerimeter;
	    }
}

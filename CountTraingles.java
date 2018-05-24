import java.util.*;

public class CountTraingles {
	
	 public static void main(String[] args) {
	        int[] test = new int[]{5,6,7,8};

	        CountTraingles countTriangles = new CountTraingles();
	        int result = countTriangles.solution(test);
	        System.out.println("Using sticks from given array you could build: " + result + " triangles.");
	    }
	 
	 public int solution(int[] A) {
	        // write your code in Java SE 8
	        Arrays.sort(A);
	        int counter = 0;
	        int N = A.length;
	        if (N < 3) return 0;
	        for (int back = 0; back < N - 2; back++) {
	            int front = 0;
	            for (int middle = back + 1; middle < N - 1; middle++) {
	                while (front < N && A[back] + A[middle] > A[front]) {
	                    front++;
	                }
	                // here we add dist between last and middle element
	                // (front-1) stands for overlooping in @while
	                counter += (front - 1) - middle;
	            }
	        }
	        return counter;
	    }

}

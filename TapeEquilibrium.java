import java.util.Arrays;
import java.util.HashMap;

/*
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7 
P = 2, difference = |4 − 9| = 5 
P = 3, difference = |6 − 7| = 1 
P = 4, difference = |10 − 3| = 7 
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class TapeEquilibrium {

	
	public static int solution(int[] A){
//      int sumRight= Arrays.stream(A).sum();
      int sumRight = 0;
      for (int number : A) {
          sumRight += number;
      }
      int min=2000;
      int sumLeft=0;
      for(int i=0;i<A.length-1;i++){
          sumLeft+=A[i];
          sumRight-=A[i];
          min=Math.min(min,Math.abs(sumLeft-sumRight));
//          int diff=Math.abs(sumLeft-sumRight);
//          if(min>diff){
//              min=diff;
//          }
      }
      return min;
  }

  public static void main(String[] args){
//      int[] arr={3,1,2,4,3};
      int[] arr={1000,-1000};
      System.out.println(solution(arr));
  }
  
  public int solution2(int[] A) {
      int length = A.length;
      if (length == 2) return Math.abs(A[0] - A[1]);
      
      HashMap<Integer, Integer> map = new HashMap<>();
      int sum = 0;
      for (int i = 0; i < length; i++) {
          sum += A[i];
          map.put(i, sum);
      }
      
      int minDiff = Math.abs(map.get(0) * 2 - sum);
      for (int i = 1; i < length - 1; i++) {
          int possibleDiff = Math.abs(map.get(i) * 2 - sum);
          if (possibleDiff < minDiff) minDiff = possibleDiff;
      }
      
      return minDiff;
  }
  public int solution5(int[] A) {
      if (A.length == 0) return 1;
      Arrays.sort(A);
      int i = 0;

      while (i < A.length) {
          if (i + 1 != A[i]) return i + 1;
          i++;
      }

      if (A[i-1] != i + 1) {
          return i+1;
      }
      return 1;
  }
}

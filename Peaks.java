import java.util.*;
public class Peaks {
	public static void main(String[] args) {
        int[] test = new int[]{0,1,0,1,0,0};

        Peaks peaks = new Peaks();
        int result = peaks.solution(test);
        System.out.println("Number of devided section of array is: :");
        System.out.println(result);
    }


    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        ArrayList<Integer> peaks = new ArrayList<Integer>();
        for(int i = 1; i < (N -1); i++) {
            if(A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }

        for(int size = 1; size <= N; size++) {
            if(N % size != 0) continue; // skip if divide not possible

            int find = 0;
            int groups = N/size;
            boolean ok = true;

            // check if every group has a peek
            for(int peak : peaks) {
                if(peak/size > find) { // here goes overshot of divide part (int)@find
                    ok = false;
                    break;
                }
                if(peak/size == find) find++; // if find 1st peak included in (int)@find, then go to find peak for next (int)@find
            }
            if(find != groups) ok = false; // if didnt find all groups
            if(ok) return groups;
        }
        return 0;
    }

}

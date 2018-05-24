
public class MinAvgTwoSlice {

	
	public static int solution(int[] A) {
        double sum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < A.length - 1; i++) {
            double sumPre = A[i];
            for (int j = i + 1; j < A.length; j++) {
                double sumCur = (sumPre + A[j]) / (double) (j - i + 1);
                if (sum > sumCur) {
                    sum = sumCur;
                    index = i;
                }
                sumPre = sumPre + A[j];
            }
        }
        return index;
    }


    public static int solution2(int[] A) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            int sumPre = A[i];
            for (int j = i + 1; j < A.length; j++) {
                sumPre = sumPre + A[j];
                if (sum < sumPre) {
                    sum = sumPre;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
//        int[] arr={3,1,2,4,3};
//        int[] arr = {4, 2, 2, 3, 5, 1, 5, 8};
        int[] arr = {5, -7, 3, 5, -2,4,-1};
        System.out.println(solution2(arr));
    }
    
}

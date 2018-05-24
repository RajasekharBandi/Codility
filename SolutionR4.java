public class SolutionR4 {

	public static void main(String[] args) {

		System.out.println(new SolutionR4().solution(50));
	}


	public int solution(int N) {

		int result = 0;
		for (int i = 1; i <= N; i++) {
			String str = String.valueOf(i);
				for (int j = 0; j < str.length(); j++){
					if(str.charAt(j) == '1')
						result++;
				}
		}

		return result;
	}
}

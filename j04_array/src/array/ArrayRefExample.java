package array;

public class ArrayRefExample {

	public static void main(String[] args) {
		// 배열 선언과 동시에 초기화.
		int[] scores = new int[]{70,60,50,40,60,60};
		//   0   1   2   3   4   5
		// [70][60][50][40][60][60]
		// 배열의 시작 인덱스 번호 : 0
		// 할당된 배열의 마지막 인덱스 번호 : 배열의 항목 크기 - 1
		//                             5
		System.out.println(scores.length);
		// scores 배열의 0번째 인덱스를 가진 항목의 값을 80으로 변경
		scores[0] = 80;
		// [80][60][50][40][60][60]
		
		int score = scores[0];
		System.out.println(score);
		int[] scores2 = null;
		if(scores2 == null) {
			scores2 = scores;
		}
		System.out.println(scores2 == scores);
		// scores [80][60][50][40][60][60]		
		scores2[1] = 70;
		// scores [80][70][50][40][60][60]
		System.out.println(scores[1]);
	}

}





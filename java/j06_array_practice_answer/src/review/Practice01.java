package review;

/**
 * numbers 배열 중에서 값이 짝수인 요소(항목)만 출력하는 source code 를 작성하세요.
 */
public class Practice01 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				System.out.println(numbers[i]);
			}
		}
	} // end main

} // end class

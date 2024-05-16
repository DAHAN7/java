package review;

import java.util.Scanner;

/**
 * 총 5개의 정수를 저장할 수 있는 배열을 생성 하고 사용자로부터 정수를 입력받아 배열에 저장하고, 
 * 저장된 값들을 출력하는 source code 를 작성하세요.
 */
public class Practice02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = new int[5];

		System.out.println("정수 5개를 입력하세요:");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		scanner.close();

		System.out.println("입력된 배열 요소:");
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	} // end main
} // end class

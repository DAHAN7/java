package review;

import java.util.Scanner;

/**
 * 총 5개의 정수를 저장할 수 있는 배열을 생성 하고 사용자로부터 정수를 입력받아 배열에 저장하고, 
 * 저장된 값들을 출력하는 소스코드를 작성하세요.
 */
public class Practice02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// 코드 작성
		int []numbers = new int [5];
		for (int i=0;i<numbers.length;i++) {
			System.out.print("정수를 입력하세요:");
			numbers[i]=scanner.nextInt(); 
		}
		System.out.print("입력된 정수들:");
		for (int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i]);
		}
	} // end main
} // end class

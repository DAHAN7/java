package review;

/**
 * 다음과 같은 배열을 선언하고, 
 * 가장 큰 수, 가장 작은 수를 찾아 출력하는 source code 를 작성하세요.
 */
public class Practice03 {

	public static void main(String[] args) {

		int[] numbers = { 25, 13, 45, 67, 33, 92, 17 };
		
		int max, min;
		
		max = min = numbers[0];
		
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}

			if (numbers[i] < min)
				min = numbers[i];
		}

		System.out.println("가장 큰 수: " + max);
		System.out.println("가장 큰 수: " + min);
	} // end main

} // end class

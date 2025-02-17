package review;

/**
 * numbers 배열에 나열된 각 항목의 값을 오름차순으로 정렬하여 저장하고
 * 저장된 배열의 값을 출력하시오.
 */
public class Practice04 {
	
	public static void main(String[] args) {
		
		int[] numbers = { 25, 13, 45, 67, 33, 92, 17 };
		Arrays.sort(numbers);

		System.out.print("정렬된 배열의 값: ");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	} // end main

} // end class
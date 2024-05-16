package review;

/**
 * numbers 배열에 나열된 각 항목의 값을 오름차순으로 정렬하여 저장하고
 * 저장된 배열의 값을 출력하는 source code 를 작성하세요.
 */
public class Practice04 {
	
	public static void main(String[] args) {
		//             0   1   2   3    4   5   6
		// numbers = { 25, 13, 45, 67, 33, 92, 17 };
		
		//            numbers[0] > [1,2,3,4,5,6]
		// numbers = { 13, 25, 45, 67, 33, 92, 17 };
		//            numbers[1] > [2,3,4,5,6]		                 
		// numbers = { 13, 17, 45, 67, 33, 92, 25};
		//            numbers[2] > [3,4,5,6]		                 
		// numbers = { 13, 17, 33, 67, 45, 92, 25};
		// numbers = { 13, 17, 25, 67, 45, 92, 33};
		//            numbers[3] > [4,5,6]		                 
		// numbers = { 13, 17, 25, 45, 67, 92, 33};
		// numbers = { 13, 17, 25, 33, 67, 92, 45};
		//            numbers[4] > [5,6]		                 
		// numbers = { 13, 17, 25, 33, 67, 92, 45};
		// numbers = { 13, 17, 25, 33, 45, 92, 67};
		//            numbers[5] > [6]		                 
		// numbers = { 13, 17, 25, 33, 45, 67, 92};
		int[] numbers = { 25, 13, 45, 67, 33, 92, 17 };
		
        for (int i = 0; i < numbers.length; i++) {
        	
            for (int j = i + 1; j < numbers.length; j++) {
            	
            	// 앞자리의 수가 뒤자리의 수보다 크다면
                if (numbers[i] > numbers[j]) {
                    // 두 숫자의 위치를 교환
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            } // end inner for
            
        } // end outer for, i++

        // 정렬된 배열의 값을 출력
        System.out.print("정렬 후 배열의 항목 값 : ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
	} // end main

} // end class

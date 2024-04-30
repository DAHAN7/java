import java.util.Scanner;

public class Practice04SalaryExample {

	public static void main(String[] args) {
		 int[] array4 = new int[5]; // 크기가 5인 배열 생성
	        System.out.println("배열 초기화 전:");
	        printArray(array4); // 배열의 초기 상태 출력

	        // 배열의 세 번째 요소에 10 할당
	        array4[2] = 10;

	        System.out.println("\n배열 초기화 후:");
	        printArray(array4); // 배열의 변경된 상태 출력
	    }

	    // 배열 출력 메서드
	    public static void printArray(int[] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
		
	}
	
}












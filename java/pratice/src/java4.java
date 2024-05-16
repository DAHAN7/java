import java.util.Scanner;

public class java4 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 3, 60, -3};
        Scanner scanner = new Scanner(System.in);
        // 첫 번째 인덱스 번호 입력
        System.out.print("첫 번째 인덱스 번호를 입력하세요: ");
        int index1 = scanner.nextInt();

        // 두 번째 인덱스 번호 입력
        System.out.print("두 번째 인덱스 번호를 입력하세요: ");
        int index2 = scanner.nextInt();
//입력받은 인덱스가 배열의 유효범위내에 있는지 확인
if(index1>=0&& index1 < arr.length && index2>=0
&&index2<arr.length) {
	//두 인덱스의 값을 서로 교환
	int temp= arr[index1];
	arr[index1]= arr[index2];
	arr[index2]=temp;
	//변경된 배열을 출력
System.out.println("변경된 배열:"+java.util.Arrays.toString(arr));
}else {
	//입력받은 인덱스가 유효범위를 벗어난 경우 에러메시지 출력
	System.out.println("유효하지 않은 인덱스입니다.");
}
}
}
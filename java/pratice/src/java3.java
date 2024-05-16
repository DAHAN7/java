import java.util.Scanner;
public class java3 {
	public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 3, 60, -3};
        Scanner scanner = new Scanner(System.in);
//사용자로부터 변경하고 싶은 값의 인덱스번호를 입력받음
System.out.print("변경하고 싶은 값의 인덱스 번호를 입력하세요:");
int index = scanner.nextInt();
//입력받은 인덱스가 배열의 유효범위 내에 있는지 확인
if (index >=0&& index < arr.length) {
	//해당 인덱스의 값을 1000으로 변경
	arr[index]=1000;
	//변경될 배열을 출력
	System.out.println("변경된 배열:"
	+java.util.Arrays.toString(arr));
}else {
	//입력받은 인덱스가 유효범위를 벗어난 경우 에러 메시지 출력
	System.out.println("유효하지 않은 인덱스입니다.");
}
}
}

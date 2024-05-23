package practice_01_03;

import java.util.Scanner;

public class Practice_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// sample id
		String myId = "id001";
		
		System.out.print("아이디 입력>");
		String id = sc.next();
		//문자열 내용 비교는 equals 메서드를 사용
		if(myId.equals(id)) {
			System.out.println("아이디가 일치합니다.");
		}else {
			System.out.println("아이디가 일치하지 않습니다.");
		}
		sc.close();
	}
}

package h_practice;

import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		/*
		Student s1 = new Student();
		s1.number = 1;
		s1.name = "최기근";
		s1.score = 100;
		
		System.out.println(s1.getInfo());
		
		Student s2 = new Student(2,"이다한",98);
		String info = s2.getInfo();
		System.out.println(info);
		*/
		
		Scanner sc = new Scanner(System.in); // import 추가
		
		// 학생 정보를 저장할 배열
		Student[] students = null;
		
		while(true) {
			System.out.println("=====================================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("=====================================");
			System.out.println("메뉴 번호를 입력해 주세요(1~5)");
			// console에서 정수값을 입력받아 selectNo변수에 저장
			int selectNo = sc.nextInt();
			/*
			 	1. 학생수를 입력받아 Student 객체가 저장될 students 배열 생성
			    	- 입력받은 학생 수만큼의 크기를 가짐.
			    2. 생성된 students 배열의 항목 수만큼(배열의 크기만큼)
			       학생의 정보를 입력받아 Student 객체를 생성하여 저장하고
			       배열항목에 저장
			       - int(number), String(name), int(score)
			       sc.next();		// console을 통해서 문자열 입력받음
		        3. students 배열에 저장된 학생들의 정보를 출력(field 정보 출력)
		        4. 1. students 배열에 저장된 학생들의 점수를 전체합계, 평균을 구해서 출력
		           2. students 배열에 저장된 학생들의 점수를 연산하여
		              최고득점자 이름, 최저득점자의 이름을 출력
		        5. 프로그램 종료      
			 */
		}
		
	}// end main

} // end StudentManagement class














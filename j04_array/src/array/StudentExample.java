package array;

import java.util.Scanner;

public class StudentExample {

	public static void main(String[] args) {
		System.out.println("Main START");
		
		// 사용자에게 콘솔을 통해서 지정한 타입으로 값을 입력
		Scanner sc = new Scanner(System.in); // import 추가
		
		// 프로그램 종료 flag
		boolean isRun = true;
		
		// 학생들의 점수를 저장할 배열(공간)
		int[] scores = null;
		
		while(isRun) {
			System.out.println("=====================================");
			System.out.println("1.학생수|2.점수입력|3.전체점수|4.분석|5.종료");
			System.out.println("=====================================");
			System.out.println("선택하실 기능의 번호를 입력하세요 > ");
			int selectNo = sc.nextInt(); // int 타입의 값을 입력받아 전달
			System.out.println("선택하신 번호는 " + selectNo + "번 입니다.");
			/*
			 	1. 학생수 
			 	   점수를 입력할 학생수를 입력받음. 
			 	   입력받은 학생수(정수값) 만큼 배열을 생성하여 scores에 저장
			 	   
		 	    2. 1번에서 생성된 학생 수 만큼(배열의 크기 만큼) 학생의 점수를 입력받아
		 	       scores배열의 각 항목에 저장 (0 ~ scores.length -1)
		 	       
	 	        3. scores 배열에 저장된 각 학생들의 점수(배열 항목)를 출력
	 	        
	 	        4. 분석 - scores 배열에 저장된 학생의 점수를 계산하여
	 	                 전체 총점, 평균 점수, 최고점수, 최저점수를 출력
	 	                 
	 	        5. while문을 종료하여 프로그램 종료 
			 */
			//
			if(selectNo != 1 && selectNo != 5 && scores == null) {
				System.out.println("학생 수를 먼저 입력해주세요.");
				continue;
			}
			
			
			// switch문을 통해서 사용자가 입력한 메뉴 번호 비교
			switch(selectNo) {
				case 1 : 
					/*
					 점수를 입력할 학생수를 입력받음. 
			 	     입력받은 학생수(정수값) 만큼 배열을 생성하여 scores에 저장
					 */
					System.out.println("학생 수를 입력해 주세요.");
					int studentCount = sc.nextInt();
					// 입력받은 학생 수만큼 배열 생성해서 scores 변수에 저장
					scores = new int[studentCount];
					System.out.println("등록된 학생 수는 : " + scores.length);
					break; // 1번 기능 종료 시 switch 문 탈출
				case 2 : 
					// 배열의 항목 크기만큼 학생들의 점수를 입력받아 저장
					System.out.println("저장할 학생 점수 입력");
					for(int i = 0; i < scores.length; i++) {
						System.out.println((i+1)+"번째 학생 점수 입력 > ");
						// 입력받은 학생의 점수를 scores배열의 각 항목에 저장
						scores[i] = sc.nextInt();
					}
					System.out.println("점수 입력 완료!");
					break;
				case 3 : 
					System.out.println("학생들의 점수 출력");
					for(int i : scores) {
						System.out.print(i+" ");
					}
					System.out.println();
					break;
				case 4 : 
					System.out.println("점수 분석");
					// 전체총점, 평균, 최고, 최저
					int total = 0;	// 총점
					double avg = 0; // 평균
					int max = 0, min = 0;	// 최고, 최저 점수
					max = min = scores[0];
					for(int i : scores) {
						// scores 배열에 저장된 모든 항목의 값을 total
						// 변수에 누적해서 저장
						total += i;
						if(i > max) {
							max = i;
						}
						
						if(i < min) {
							min = i;
						}
					}
					
					avg = (double)total / scores.length;
					
					System.out.println("총점 : " + total);
					System.out.println("평균 : " + avg);
					System.out.println("최고 : " + max);
					System.out.println("최저 : " + min);
					break;
				case 5 :
					isRun = false;
					System.out.println("프로그램 을 종료합니다.");
					break;
				default : 
					System.out.println("없는 메뉴입니다.");
			} //end switch
		} // end while
		System.out.println("Main END");
	} // end main
} // end class







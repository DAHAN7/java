import java.util.Scanner;

public class java6 {
    public static void main(String[] args) {
    	final int rows =10;//행의 개수
    	final int cols= 10;//열의 개수
    	char[][]seats =new char [rows][cols];//좌석배열
    	Scanner scanner = new Scanner(System.in);
    	//초기 좌석 배치표 생성(미음으로 초기화)
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			seats[i][j]='ㅁ';//미음으로 초기화
    			
    		}
    	}
    	while (true){
    		//좌석 배치 출력
    		 System.out.println("------------------------");
             System.out.println("      좌석 배치표");
             System.out.println("------------------------");
             System.out.print("  ");
             //열 번호 출력
             for(int i=1;i<=cols;i++) {
            	 System.out.print(i+"");
             }
             System.out.println();
             //행과 열에 대한 좌석 배치 출력
             for(char rowChar = 'A';rowChar<='J';rowChar++) {
            	 System.out.print(rowChar+"");
            	 //행 이름 출력
            	 for (int j = 0; j < cols; j++) {
                     System.out.print(seats[rowChar - 'A'][j] + " "); // 좌석 상태 출력
                 }
                 System.out.println();
             }
             System.out.println("------------------------");

             // 사용자로부터 행의 이름과 열의 번호 입력 받기
             System.out.print("예약하실 좌석의 행을 입력해주세요 (종료는 -1): ");
             char rowChar = scanner.next().charAt(0); // 행의 이름
             if (rowChar == '-') {
                 break; // 프로그램 종료
             }
             int row =rowChar -'A';//행 인덱스 계산
             System.out.print("예약하실 좌석의 열 번호를 입력해주세요:");
             int col = scanner.nextInt()-1;//열 번호
             //입력받은 좌석이 유효한지 확인
             if(row<0||row>=rows||col<0||col>=cols) {
            	 System.out.println("잘못된 좌석입니다.다시 입력해주세요.");
            	 continue;
             }
             //이미 예약된 좌석인지 확인
             if (seats[row][col] == '■') {
                 System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
                 continue;
                 }
             //좌석 예약 확인
             System.out.println("선택하신 좌석은:"
             +rowChar+(col+1)+"입니다.");
             char confirm = scanner.next().charAt(0);
             if (confirm == 'y' || confirm == 'Y') {
                 seats[row][col] = '■'; // 좌석 예약 완료
                 System.out.println("예약 완료되었습니다.");
             } else {
                 System.out.println("예약이 취소되었습니다.");
             }
         }

         System.out.println("프로그램을 종료합니다.");
     }
 }
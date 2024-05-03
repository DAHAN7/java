import java.util.Scanner;

public class java5 {
    public static void main(String[] args) {
        final int size = 10;
        int[] seats = new int[size];
        Scanner scan = new Scanner(System.in);

        while (true) {
            // 좌석 배치 출력
            System.out.println("------------------------");
            System.out.println("    좌석 배치표");
            System.out.println("------------------------");
            // 좌석 번호 출력
            for (int i = 0; i < size; i++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println("\n------------------------");
            // 좌석 예약 상태 출력
            for (int i = 0; i < size; i++) {
                System.out.print(seats[i] + " ");
            }
            System.out.println("\n------------------------");

            // 사용자로부터 좌석 번호 입력 받기
            System.out.print("원하시는 좌석 번호를 입력하세요 (종료는 -1): ");
            int seatNumber = scan.nextInt();

            // 프로그램 종료 여부 확인
            if (seatNumber == -1) {
                break;
            }

            // 입력받은 좌석 번호가 유효한지 확인
            if (seatNumber < 1 || seatNumber > size) {
                System.out.println("잘못된 좌석 번호입니다. 다시 입력해주세요.");
                continue;
            }

            // 이미 예약된 좌석인지 확인
            if (seats[seatNumber - 1] == 1) {
                System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
                continue;
            }

            // 좌석 예약 완료
            seats[seatNumber - 1] = 1;
            System.out.println("좌석 예약이 완료되었습니다.");
        }

        System.out.println("프로그램을 종료합니다.");
    }
}


package practice_01_03;

import java.util.Arrays; // Arrays 클래스 사용을 위해 임포트

public class Practice_02 {

    private static int count; // 정적 변수 count 선언, 현재 사용되지 않음

    public static void main(String[] args) {

        int[] lotto = new int[6]; // 정수형 배열 lotto를 길이 6으로 선언
        
        for(int i = 0; i < lotto.length; i++) { // 배열의 각 인덱스에 접근하는 반복문
            lotto[i] = (int)(Math.random() * 45 + 1); // 1부터 45까지의 랜덤한 숫자를 배열에 저장
            // System.out.print(""+lotto[i]); // 디버깅용으로 랜덤 숫자를 출력하는 코드 (현재는 주석 처리)
        }
        
        int number = (int)(Math.random() * 45 + 1); // 또 다른 랜덤 숫자 생성 (사용되지 않음)
        
        Arrays.sort(lotto); // lotto 배열을 오름차순으로 정렬
        
        // 결과 출력 코드 수정 x
        System.out.println("[ 결과 ]"); // 결과 출력
        for (int i : lotto) { // lotto 배열의 각 요소에 접근하는 향상된 for 문
            System.out.print("[" + i + "]"); // 각 숫자를 대괄호로 감싸서 출력
        }
    }
}

package array;

/**
 * 1등 : 6개 일치
 * 2등 : 5개 일치 + bonus 번호 일치
 * 3등 : 5개 일치
 * 4등 : 4개 일치
 * 5등 : 3개 일치
 */
public class LottoExample {

	public static void main(String[] args) {
		// 1 ~ 45까지의 수를 6개 + bonus 1
		// 1 ~ 45 까지의 난수 6개를 추출 해서 행운번호 저장
		
		// 난수 추출
		// Math 수학 관련된 계산 기능을 저장하는 객체
		// Math.random(); 호출 되는 시점에 랜덤한 난수를 반환하는 함수
		// 0.0 ~ 0.999999999999999; 까지의 실수
		// 0이상 1미만의 실수를 전달
		// 0.99999999999999; * 45 == 44.99999999
		// 0.0 * 45 == 0
		double random = Math.random();
		System.out.println(random);
		double next = random * 45;
		System.out.println(next);
		int number = (int)next;
		System.out.println(number);
		System.out.println(number + 1);
		number = (int)(Math.random() * 45) + 1;
		System.out.println(number);
		
		System.out.println("====================================");
		
		// 당첨번호 - 행운번호를 저장할 배열
		int[] lotto = new int[6];
//		lotto[0] = (int)(Math.random() * 45) + 1;
//		lotto[1] = (int)(Math.random() * 45) + 1;
		int count = 0; // 외부 for문의 반복횟수를 저장할 변수
		for(int i = 0; i < lotto.length; i++) {
			count++;
			// lotto 배열 각 인덱스 항목에 1 ~ 45 까지의 난수를 저장
			lotto[i] = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		} // 행운번호 생성 저장 완료
		
		System.out.println("count : " + count);
		
		// 저장된 행운 번호 확인
		for(int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		} // end for
		System.out.println();
		// 저장된 두 위치의 값을 변경 - swap
		// 45 44 27 41 25 26 
		/*
		if(lotto[0] > lotto[1]) {
			int temp = lotto[0];
			// temp == 45
			// lotto[0] == 45
			// lotto[1] == 44
			lotto[0] = lotto[1];
			// temp == 45
			// lotto[0] == 44
			// lotto[1] == 44
			lotto[1] = temp;
			// lotto[0] == 44
			// lotto[1] == 45
		}
		*/
		
		// 앞의 값이 크면 뒤에 있는 값과 자리를 변경하여
		// 오름차순으로 정렬
		for(int i = 0; i < lotto.length; i++) {
			for(int j = i+1; j < lotto.length; j++) {
				// i == 0,  j == 1 ~ 5
				// i == 1,  j == 2 ~ 5
				// ...
				// i == 5,  j == 6 X
				// 앞에 있는 값이 더 클때 큰 수를 뒤로 배치 - 오름차순
				if(lotto[i] > lotto[j]) {
				// 앞에 있는 값이 작을때 뒤의 항목과 위치 이동 - 내림차순	
				// if(lotto[i] < lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		} // end sorting
		
		// 정렬 확인
		for(int i : lotto) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	} // end main
} // end class
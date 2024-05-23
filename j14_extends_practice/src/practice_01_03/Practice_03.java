package practice_01_03;

import java.util.Random;

public class Practice_03 {

	public static void main(String[] args) {
		// code 작성
		int []randomArray = new int[10];
		Random random = new Random();
		//난수발생 및 배열에 저장
		System.out.print("최초의 리스트"+": ");
		for(int i=0;i<randomArray.length;i++) {
			// numbers 배열 각 항목에 1 ~ 100까지의 난수를 저장
			randomArray[i] = (int)(Math.random()*100)+1;
			// 줄바꿈 하지 않고 각 배열의 항목에 저장된 난수를 출력 후 공백 추가
			System.out.print(randomArray[i]+" ");
		}// end 전체 배열 순회 for
		
		for(int i=0;i<randomArray.length-1;i++) {
			for(int j=0;j<randomArray.length-1-i;j++) {
				if(randomArray [j]<randomArray[j+1]) {
					int temp= randomArray[j];
					randomArray[j]=randomArray[j+1];
					randomArray[j+1]=temp;
			}
		}
	}
System.out.println();
        // 정렬된 배열 출력
        System.out.print("정렬된 리스트" + ": ");
        
        for (int number : randomArray) {
            System.out.print(number + " ")
            ;
        }
    }
}

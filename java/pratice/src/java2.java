public class java2 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 3, 60, -3};
        // 60이라는 값을 가진 원소의 인덱스를 출력하는데,
        // 인덱스번호가 3인 곳은 출력하지 않음
        findIndexExcept(arr, 60, 3);
    }

    // 주어진 배열에서 특정값을 찾아 해당 인덱스를 출력하는 메소드
    // 단, 특정 인덱스 번호는 제외함
    public static void findIndexExcept(int[] arr, int target, int exceptIndex) {
        for (int i = 0; i < arr.length; i++) {
            // 제외할 인덱스 번호인 경우 또는 찾고자 하는 값이 아닌 경우에는 출력하지 않음
            if (i != exceptIndex && arr[i] == target) {
                System.out.println("값이 " + target + "인 곳의 인덱스 번호: " + i);
            }
        }
    }
}


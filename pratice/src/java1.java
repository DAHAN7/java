public class java1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 3, 60, -3};
        findIndex(arr, 60);
    }

    public static void findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("값이 " + target + "인 곳의 인덱스 번호: " + i);
            }
        }
    }
}

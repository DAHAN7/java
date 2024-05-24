 package practice_04;

//CarExample 클래스 정의
public class CarExample {
  /**
   * Car class 작성
   */
  
  // main 메서드: 프로그램의 시작점
  public static void main(String[] args) {
      // Car 클래스의 인스턴스 생성
      Car car = new Car();
      
      // car 객체의 color 필드를 "red"로 설정
      car.color = "red";
      
      // car 객체의 speed 필드를 0으로 설정
      car.speed = 0;
      
      // car 객체의 기어를 1로 변경
      car.changeGear(1);
      
      // car 객체의 속도를 10 증가
      car.speedUp();
      
      // car 객체의 현재 상태를 출력
      System.out.println(car);
      
      // car 객체의 속도를 10 감소
      car.speedDown();
      
      // car 객체의 현재 상태를 다시 출력
      System.out.println(car);
  }
}
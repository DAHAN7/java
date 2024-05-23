package practice_04;

public class Car// extends Object 
{

	public String color;
	public int speed;
	private int gear;

	public void changeGear(int i) {
		this.gear = i;
	}

	public void speedUp() {
		speed += 10;
	}
	// 속도를 10 감소시키는 메서드

	public void speedDown() {
		if (speed >= 10) {
			speed -= 10;
		} else {
			speed = 0;// 속도가 0 미만으로 내려가지 않도록 설정
		}
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
	}
	
}
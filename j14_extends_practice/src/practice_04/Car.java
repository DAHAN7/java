package practice_04;

public class Car// extends Object 
{

	public String color;
	public int speed;
	private int gear;

	public void changeGear(int i) {
		this.gear = gear;
	}

	public void speedUp() {
		speed += 10;
	}
	// 속도를 10 감소시키는 메서드

	public void speedDown() {

			speed -= 10;
		
	}
	//alt + s, v
//	@Override	public String toString() {		return "Car [color=" + this.color  + ", speed=" + this.speed + ", gear=" + this.gear + "]";}
	//alt +s,s,s
	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
	}
	
}
package a7_encapsulation;

public class StudentExample {

	public static void main(String[] args) {
		System.out.println(Student.MIN_GRADE);
		System.out.println(Student.MAX_GRADE);
		
		Student choi = new Student();
		choi.name = "최기근";
		
		choi.age  = -20;
	}

}







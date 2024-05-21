package extends5_polymorphism.base;

public class Student extends Person{
	
	// name, birth
	
	String classRoom;		// 교실
	String studentNum;		// 학번
	String grade;			// 학년
	
	// alt + s , a
	public Student(String name, int birth, 
				   String classRoom, String studentNum, String grade) {
		super(name, birth);
		this.classRoom = classRoom;
		this.studentNum = studentNum;
		this.grade = grade;
	}
	
	// alt + s + s , s
	
	@Override
	public String toString() {
		return super.toString() + "Student [classRoom=" + classRoom + ", studentNum=" + studentNum + ", grade=" + grade + "]";
	}
	

}










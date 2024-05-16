package a2_class;

// 현재 소스코드 파일과 다른 패키지에 정의된 클래스를 사용할려면
// 해당 클래스의 위치를 알려줘야함.
import a1_class.A;
// B class는 a1_class package 내부에서만 공개되어 있으므로
// 외부 패키지에서 접근이 불가능함.
// import a1_class.B;

public class C {
	
	a1_class.A a = new a1_class.A();
	A a1 = new A();
	
//	B b = new B();
	
}









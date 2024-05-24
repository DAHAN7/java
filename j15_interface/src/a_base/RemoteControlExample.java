package a_base;

/**
 * interface test class
 */
public class RemoteControlExample {

	public static void main(String[] args) {
		
		int maxValue = RemoteControl.MAX_VALUE;
		System.out.println(maxValue);
		
		// 인터페이스의 모든 field는 public static final
		int minValue = RemoteControl.MIN_VALUE;
		System.out.println(minValue);
		// RemoteControl.MIN_VALUE = 1;
		
		RemoteControl tvRemote; // = new RemoteControl();
		tvRemote = new TVRemoteControl();
		tvRemote.turnOn();
		tvRemote.setValue(11);
		tvRemote.turnOff();
		
		RemoteControl radioRemote = new RadioRemoteControl();
		
		
		
	}

}










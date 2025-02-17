package object_array_guide.account;

import java.util.Scanner;

public class BankApplication {
	
	Account[] account = new Account[100];
	
	Scanner sc = new Scanner(System.in);
	
	BankApplication(){
		run();
	}
	
	void run() {
		// 1. 계좌생성
		// 2. 계좌조회 
		// 3. 예금
		// 4. 출금
		// 5. 종료
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("========================================");
			System.out.println("1.계좌생성 2.계좌조회 3.예금 4.출금 5.종료");
			System.out.println("========================================");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				// 계좌생성
				createAccount();
			}else if(selectNo ==2) {
				// 계좌조회
				selectAccount();
			}else if(selectNo ==3) {
				// 예금
				deposit();
			}else if(selectNo ==4) {
				// 출금
				withdraw();
			}else if(selectNo ==5) {
				// 종료
				isRun = false;
				sc.close();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	//계좌생성
	void createAccount() {
		System.out.println("-------------");
		System.out.println("계좌생성");
		System.out.println("------------");
		System.out.print("계좌주 : ");
		String owner = sc.next(); // 계좌 소유주 이름을 문자열로 입력받음.
		
		System.out.print("계좌번호 : ");
		// 계좌번호를 문자열로 입력받음.
		String accountNumber = sc.next();
		
		System.out.print("초기입금액 : ");
		// 초기입금액을 정수타입의 int 타입으로 입력받아 저장.
		int balance = sc.nextInt();
		
		System.out.print("비밀번호 : ");
		// 비밀번호를 문자열로 입력받아 저장.
		String pass = sc.next();
		
		// 계좌 정보를 저장하는 객체 생성
		Account newAccount = new Account();
		newAccount.ano = accountNumber;
		newAccount.owner = owner;
		newAccount.balance = balance;
		newAccount.password = pass;
		//  0             1     2     3     4   ....  99  
 		// [newAccount][null][null][null][null] ....[null]
		// account[0] == null : 아직 계좌정보가 등록되지않은 항목
		// account[0] = newAccount;
		for(int i = 0; i < account.length; i++) {
			// account배열의 각 항목을 순회 하면서 빈자리(null)를 찾아
			// 새로 생성한 account 객체 정보를 등록시키고 반복문 종료
			if(account[i] == null){
				account[i] = newAccount;
				System.out.println("계좌 생성이 완료되었습니다.");
				break;
			}
		} // end for
		
	} // end createAccount method
	
	// 계좌조회
	void selectAccount() {
		System.out.println("-----------");
		System.out.println("계좌 조회");
		System.out.println("-----------");
		System.out.print("계좌번호 : ");
		String accountNumber = sc.next();
		
		System.out.print("비밀번호 : ");
		String pass = sc.next();
		
		// 등록된 계좌정보들 중에 계좌번호와 비밀번호가 일치하는 Account 객체 조회
		//[newAccount][null][null][null][null]
		for(int i = 0; i < account.length; i++) {
			// account[i] 항목에 할당된 Account객체가 존재하는지 확인
			if(account[i] != null) {
				// Account객체가 존재하면 각 계좌번호 비밀번호 필드의 값과
				// 사용자가 입력한 계좌번호와 비밀번호의 문자열이 일치하는지 비교
				if(account[i].ano.equals(accountNumber) 
						&& 
				   pass.equals(account[i].password)) {
					String info = account[i].toString();
					// 계좌번호 비밀번호가 일치하는 계좌정보를 콘솔에 출력
					System.out.println(info); 
					break;
				} // end 계좌정보 일치 확인 if
			} // end 항목 null check if
		} // end for : 계좌 정보 순회
		
		// findAccount method 활용
		Account registAccount = findAccount(accountNumber, pass);
		if(registAccount == null) {
			System.out.println("일치하는 계좌정보가 존재하지 않습니다.");
		}else {
			System.out.println(registAccount.toString());
		}
	} // end selecAccount method 
	
	// 예금
	void deposit() {
		System.out.println("--------");
		System.out.println("계좌입금");
		System.out.println("--------");
		System.out.print("계좌번호 : ");
		String accountNumber = sc.next();
		System.out.print("비밀번호 : ");
		String pass = sc.next();
		
		// 입금 기능을 수행할 계좌정보 검색
		Account registAccount = findAccount(accountNumber, pass);
		if(registAccount == null) {
			System.out.println("계좌정보가 존재하지 않습니다.");
		}else {
			// 일치하는 계좌정보 존재
			// 입금할 금액 입력
			System.out.print("입금액 : ");
			int money = sc.nextInt();
			registAccount.balance += money;
			System.out.printf(
					"%s님의 계좌에 %,d원이 입금되었습니다. 잔고는 %,d원 %n",
					registAccount.owner,
					money,
					registAccount.balance
			);
		}
	} // end deposit method
	
	//출금
	void withdraw() {
		System.out.println("---------");
		System.out.println("계좌출금");
		System.out.println("---------");
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		System.out.print("비밀번호 : ");
		String pass = sc.next();
		
		// 계좌번호와 비밀번호가 일치하는 계좌정보 검색
		Account regist = findAccount(ano,pass);
		
		if(regist == null) {
			System.out.println("잘못된 정보를 입력하셨습니다.");
			return; // withdraw() 즉시 종료
		}
		
		// regist != null
		System.out.print("출금액 : ");
		int money = sc.nextInt();
		// 계좌 잔고에서 money만큼 차감한 금액을 result에 저장
		int result = regist.balance - money;
		
		// 잔고 보다 큰 금액을 출금 요청
		if(result < 0) {
			System.out.println("잔고 부족");
			return;
		}
		// 출금 금액 만큼 차감한 금액을 잔고에 저장
		regist.balance = result;
		System.out.println(
			money+"원 만큼 출금이 완료되었습니다. 잔고는 "+regist.balance
		);
	} // end withdraw method
	
	// 계좌번호와 비밀번호가 일치하는 Account 객체를 찾아서 반환 
	Account findAccount(String ano, String password) {
		// account 배열 순회
		for(int i = 0; i < account.length; i++){
			if(account[i] != null 
					&& 
			   account[i].ano.equals(ano) 
			   		&& 
		   	   account[i].password.equals(password)) {
				// account[i] 번째 항목에 계좌정보가
				// 매개변수로 전달된 계좌번호와 비밀번호가 일치하는 계좌정보
				return account[i];
			}
		} // end for
		return null;
	}
	
	public static void main(String[] args) {
		new BankApplication();
	}
}






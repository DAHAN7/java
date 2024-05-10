package GUIDE.account;

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
System.out.print("계좌번호:");
String ano = sc.next();
System.out.print("계좌주:");
String owner = sc.next();
System.out.print("초기 입금액");
int balance = sc.nextInt();
System.out.print("비밀번호:");
String password = sc.next();
Account newAccount = new Account(ano,owner,balance,password);
for(int i=0;i<account.length;i++) {
	if(account[i]==null) {
	account[i]=newAccount;
	System.out.println("계좌가 생성되었습니다.");
	return;
	}
	System.out.println("계좌가 생성되지 않았습니다.");
}
}
	// 계좌조회
	void selectAccount() {
		System.out.print("계좌번호:");
		String ano = sc.next();
		System.out.print("비밀번호");
		String password = sc.next();
		Account a = findAccount(ano,password);
		if(a !=null) {
			System.out.println(a.toString() );			
		}else {
			System.out.print("계좌를 못찾음:");
		}
		
	}
	
	
	// 예금
	void deposit() {
		System.out.print("계좌번호:");
		String ano=sc.next();
		System.out.print("비밀번호:");
		String password = sc.next();
		System.out.print("입금액:");
		int balance = sc.nextInt();
		Account b = findAccount(ano,password);
		if(b !=null) {
			b.balance+=balance;
			System.out.println("입금이 완료되었습니다.:");
				
			}else {
				System.out.println("계좌를 못 찾았습니다.:");
		}
	}
	//출금
	void withdraw() {
		System.out.print("계좌번호:");
		String ano =sc.next();
		System.out.print("비밀번호:");
		String password = sc.next();
		System.out.print("출금액:");
		int w = sc.nextInt();
		Account c = findAccount(ano,password);
		if(c !=null) {
			if(c.balance>=w) {
				c.balance-=w;
				System.out.println("출금이 완료되었습니다.");
			}else {
				System.out.println("잔액이 부족합니다.");
			}
		}else {
			System.out.println("계좌를 찾지 못함.");
		}
		
	}
	
	// 계좌번호와 비밀번호가 일치하는 Account 객체를 찾아서 반환 
	Account findAccount(String ano, String password) {
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null&&account[i].ano.equals(ano)&&account[i].password.equals(password)) {
				return account[i];
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		new BankApplication();
	}
}

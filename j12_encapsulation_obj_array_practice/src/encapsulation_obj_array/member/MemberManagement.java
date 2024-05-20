package encapsulation_obj_array.member;
import java.util.Scanner;

public class MemberManagement {
	
	// 사용자에게 정보를 입력받을 필드
	private Scanner sc = new Scanner(System.in);
	
	// 회원목록 정보를 저장할 필드
	private Member[] members = new Member[100];
	
	// 관리자 계정
	private Member master = new Member(100,"master","root","root");
	
	// 로그인된 회원정보를 저장하고 유지할 필드
	private Member loginMember = null;
	
	// 프로그램 flag (true : 진행 , false : 종료) 
	private boolean isRun = true;
	
	// 프로그램 실행용 생성자
	public MemberManagement() {
		// 관리자 계정을 마지막[99]인덱스에 저장
		members[members.length-1] = master;
	}

	public void isRun() {
		
		System.out.println("프로그램 시작!");
		
		while (isRun) {
			System.out.println("===========================================================");
			System.out.println("1.회원가입 |2.로그인 |3.회원목록|4.회원정보수정|5.회원탈퇴|6.프로그램종료");
			System.out.println("===========================================================");
			System.out.println("메뉴 선택 > ");
			
			if(!sc.hasNextInt()){
				System.out.println("번호를 입력해주세요. ");
				sc.next();
				continue;
			}

			int selectNo = sc.nextInt();
			
			switch (selectNo) {
				case 1:
					System.out.println("== 회원가입 == ");
					join();
					break;
				case 2:
					System.out.println("== 로그인 == ");
					login();
					break;
				case 3:
					System.out.println("== 회원목록 == ");
					select();
					break;
				case 4:
					System.out.println("== 회원정보수정 == ");
					update();
					break;
				case 5:
					System.out.println("== 회원탈퇴 == ");
					delete();
					break;
				case 6:
					System.out.println("== 종료 == ");
					terminate();
					break;
				default:
					System.out.println("선택할 수 없는 번호입니다.");
			} // end switch
		} // end while
	} // end isRun method

	private void terminate() {
		isRun = false;
		System.out.println("프로그램을 종료합니다.");
	}

	private void join() {
		System.out.println("아이디를 입력해주세요");
		String mId = sc.next();

		if (!memberIdCheck(mId)) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}

		System.out.println("비밀번호를 입력해주세요");
		String mPw = sc.next();
		System.out.println("비밀번호를 한번 더 입력해주세요");
		String rePw = sc.next();
		
		if (!mPw.equals(rePw)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}

		System.out.println("이름을 입력해주세요");
		String mName = sc.next();
		
<<<<<<< HEAD
		int mNum = generateMemberNum();

		Member newMember = new Member(mNum, mName, mId, mPw);

		for (int i = 0; i < members.length; i++) {
			if (members[i] == null) {
				members[i] = newMember;
				System.out.println("회원가입이 완료되었습니다.");
				return;
			}
		}
		
		System.out.println("더 이상 회원을 추가할 수 없습니다.");
=======
		if(memberIdCheck(mId)&&!mPw.equals(rePw)) {
			System.err.println("이미사용중이거나 비밀번호가 일치하지 않습니다.");
			
		}
		else {System.out.println("정상적으로 로그인되었습니다.");
			
		}
>>>>>>> bc0d025 (Your commit message)
	}

	private void login() {
		System.out.println("아이디를 입력해주세요 > ");
		String mId = sc.next();
		System.out.println("비밀번호를 입력해주세요 > ");
		String mPw = sc.next();
<<<<<<< HEAD

		Member foundMember = findMember(new Member(mId, mPw));

		if (foundMember != null) {
			loginMember = foundMember;
			System.out.println("로그인 성공!");
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
=======
		if(!memberIdCheck(mId)
				&&!mPw.equals(mrePw)) {System.out.println("이미사용중이거나 "))
			
>>>>>>> bc0d025 (Your commit message)
		}
	}

	private void select() {
		if (loginMember == null || !loginMember.equals(master)) {
			System.out.println("관리자만 접근 가능한 메뉴입니다.");
			return;
		}
		
		for (Member member : members) {
			if (member != null) {
				System.out.println(member);
			}
		}
	}
	
	private void update() {
		if (loginMember == null) {
			System.out.println("로그인 후 사용 가능한 메뉴입니다.");
			return;
		}
		
		if (loginMember.equals(master)) {
			System.out.println("== 관리자 회원정보 수정 ==");
			select();
			System.out.println("수정할 회원 번호를 입력해 주세요.");
			int mNum = sc.nextInt();
			
			for (Member member : members) {
				if (member != null && member.getmNum() == mNum) {
					System.out.println("수정할 이름을 입력해 주세요.");
					String newName = sc.next();
					member.setmName(newName);
					System.out.println("회원 정보가 수정되었습니다.");
					return;
				}
			}
			
			System.out.println("해당 번호의 회원을 찾을 수 없습니다.");
		} else {
			System.out.println("수정할 이름을 입력해 주세요.");
			String newName = sc.next();
			loginMember.setmName(newName);
			System.out.println("회원 정보가 수정되었습니다.");
		}
	}

	private void delete() {
		if (loginMember == null) {
			System.out.println("로그인 후 사용 가능한 메뉴입니다.");
			return;
		}
		
		if (loginMember.equals(master)) {
			System.out.println("관리자는 탈퇴할 수 없습니다.");
			return;
		}
		
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원 탈퇴가 완료되었습니다.");
				return;
			}
		}
		
		System.out.println("일치하는 회원 정보가 없습니다.");
	}
	
	private boolean memberIdCheck(String mId) {
		for (Member member : members) {
			if (member != null && member.getmId().equals(mId)) {
				return false;
			}
		}
		return true;
	}
	
	private Member findMember(Member m) {
		for (Member member : members) {
			if (member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}
	
	private int generateMemberNum() {
		int maxNum = 0;
		for (Member member : members) {
			if (member != null && member.getmNum() > maxNum) {
				maxNum = member.getmNum();
			}
		}
		return maxNum + 1;
	}
}

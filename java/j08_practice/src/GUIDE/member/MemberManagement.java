package GUIDE.member;
import java.util.Scanner;

public class MemberManagement{

   // 사용자 입력
   Scanner sc = new Scanner(System.in);
   
   // 회원정보 저장
   Member[] members = new Member[100];
   
   // 관리자 계정
   Member master = new Member(100,"master","root","root");
   
   // 로그인한 회원
   Member loginMember = null;
   
   // 프로그램 flag (true : 진행 , false : 종료) 
   boolean isRun = true;
   
   // 메뉴 번호 선택
   int selectNo;

   // 프로그램 실행용 생성자
   MemberManagement() {
      // 회원목록 배열 마지막 인덱스에 관리자 계정 저장
      members[members.length-1] = master;
      // 회원관리 메소드 호출
      isRun();
   }
   
   /*
    * 기능 관리 
    */
   
   // 프로그램 실행
   void isRun() {
      while(isRun) {
         System.out.println("===========================================================");
         System.out.println("1.회원가입|2.로그인|3.회원목록|4.회원정보수정|5.회원탈퇴|6.프로그램 종료");
         System.out.println("===========================================================");
         System.out.println("메뉴 선택 > ");
         
         if(!sc.hasNextInt()) {
            System.out.println("번호를 입력해주세요>");
            sc.next();
            continue;
         }
         
         selectNo = sc.nextInt();
         
         switch(selectNo) {
            case 1 : 
               System.out.println(" 회원가입 > ");
               join();
               break;
            case 2 : 
               System.out.println("== 로그인 == ");
               login();
               break;
            case 3 : 
               System.out.println("== 회원목록 == ");
               select();
               break;
            case 4 : 
               System.out.println("== 회원정보수정 == ");
               update();
               break;
            case 5 : 
               System.out.println("== 회원탈퇴 == ");
               delete();
               break;
            case 6 : 
               System.out.println("== 종료 == ");
               terminate();
               break;
            default :
               System.out.println("선택할 수 없는 번호입니다.");
         } // switch 종료
      } // while 종료
   } // run 종료
   
   // 프로그램 종료
   void terminate() {
      isRun = false;
      System.out.println("프로그램 종료");
   }

   // 회원 가입
   void join() {
       System.out.println("사용정보를 입력해주세요----------------------");

       System.out.println("아이디를 입력해주세요>");
       String mId = sc.next();
       System.out.println("비밀번호를 입력 해 주세요");
       String mPw = sc.next();
       System.out.println("비밀번호를 확인해주세요");
       String mPw1 = sc.next();
       System.out.println("이름을 입력해 주세요");
       String mName = sc.next();

       // 중복 아이디 체크
       Member findMember = new Member(0, mId, null, null);
       if (findMember(findMember) != null) {
           System.out.println("이미 존재하는 아이디입니다.");
           return;
       }

       // 비밀번호 확인
       if (!mPw.equals(mPw1)) {
           System.out.println("비밀번호 확인이 일치하지 않습니다.");
           return;
       }

       Member newMember = new Member(members.length,mName, mId, mPw1);
       for (int i = 0; i < members.length; i++) {
           if (members[i] == null) {
               members[i] = newMember;
               System.out.println("회원가입완료");
               return;
           }
       }
       System.out.println("회원가입 실패");
   }

   // 로그인
   void login() {
        System.out.println("아이디를 입력해주세요>");
        String mId= sc.next();
        System.out.println("비밀번호를 입력 해 주세요");
        String mPw = sc.next();
        if(mId.equals(master.mId)
            && mPw.equals(master.mPw)) {
            loginMember = master;
            System.out.println("관리자 계정입니다.");
            return;
        }
        Member findMember = new Member(mId,mPw);
        
        Member member = findMember(findMember);
        
        if(member != null) {
            System.out.println("정상적으로 로그인 되었습니다.");
            this.loginMember = member;
        }else {
            System.out.println("일치하는 멤버가 없습니다.");
        }
    }
   
   // 회원목록 - 로그인한 회원이 관리자 일때만 노출 
   void select() {
      if(loginMember != null && loginMember.equals(master)) {
         System.out.println("회원목록>");
         for(Member m: members) {
            if(m !=null) {
               System.out.print(m);
            }
         }
}else {
   System.out.println("관리자만 확인가능한 메뉴입니다.");
}
   }
   
// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
   void update() {
	    if (loginMember != null) {
	        if (loginMember.equals(master) || loginMember.equals(findMember(loginMember))) {
	            System.out.println("번호입력>");
	            int menuNo = sc.nextInt();
	            if (menuNo == 1) {
	                System.out.println("회원정보수정>");
	            } else if (menuNo == 2) {
	                if (loginMember.equals(master)) {
	                    System.out.println("관리자 로그인 회원정보수정");
	                    System.out.println("수정할 회원 번호를 입력해 주세요>");
	                    int memberNumber = sc.nextInt();
	                    Member memberToUpdate = members[memberNumber];

	                    if (memberToUpdate == null) {
	                        System.out.println("해당 회원이 존재하지 않습니다.");
	                        return;
	                    }

	                    System.out.println("수정할 회원의 이름을 입력해 주세요>");
	                    String modifyName = sc.next();
	                    memberToUpdate.mName = modifyName;

	                    System.out.println("수정완료");
	                } else {
	                    System.out.println("내정보수정>");

	                    // 비밀번호 확인
	                    System.out.println("비밀번호를 한번 더 입력해주세요>");
	                    String confirmPassword = sc.next();
	                    if (!confirmPassword.equals(loginMember.mPw)) {
	                        System.out.println("비밀번호가 일치하지 않습니다.");
	                        return;
	                    }

	                    System.out.println("수정할 이름을 입력해주세요>");
	                    String modifyName = sc.next();
	                    loginMember.mName = modifyName;

	                    System.out.println("내정보수정완료");
	                }
	            } else {
	                System.out.println("잘못된 번호입니다.");
	            }
	        } else {
	            System.out.println("수정권한이 없습니다.");
	        }
	    }
	}

   // 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
   void delete() {
      if(loginMember !=null) {
         deleteMember();
      }else {
         System.out.println("회원탈퇴완료");
      }
   }
   
   // 사용자 아이디 중복 체크
   boolean memberIdCheck(String mId) {
      for(Member m : members) {
         if(m != null && m.mId.equals(mId)) {
            return false;
         }
      }      
      return true;
   }
   
   // 회원 아이디와 비밀번호로 회원 찾기
   Member findMember(Member m) {
       for(Member member : members) {
           if(member != null && member.mId.equals(m.mId) && member.mPw.equals(m.mPw)) {
               return member;
           }
       }
       return null;
   }

   // 회원 정보 삭제
   void deleteMember() {
      for(int i=0; i<members.length; i++) {
         if(members[i].equals(loginMember)) {
            members[i] = null;
            loginMember = null;
            System.out.println("회원탈퇴 완료");
            return;
         }
      }
   }
}
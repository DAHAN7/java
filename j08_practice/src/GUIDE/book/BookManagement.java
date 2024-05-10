package GUIDE.book;

import java.util.Scanner;

public class BookManagement {

	// 문자열 입력
	Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	Scanner scanSelectnum = new Scanner(System.in);
	
	// 도서목록
	Book[] books = new Book[100];
	// 프로그램 실행 flag
	boolean isRun = true;
	// 메인 메뉴 선택 번호
	int selectNo = 0;
	// 도서관리 번호
	int count=1;	

	public BookManagement(){
		run();
	}
	
	public void run() {
		while(isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요 > ");
			
			switch(selectNo) {
				case 1 :
					registerBook();
					break;
				case 2 :
					selectBook();
					break;
				case 3 :
					updateBook();
					break;
				case 4 : 
					deleteBook();
					break;
				case 5 : 
					terminate();
					break;	
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			
			}
		}
	}
	
	// 프로그램 종료
	public void terminate() {
		System.out.println("프로그램 종료");
	}

	// 도서 등록
	public void  registerBook() {
		System.out.println("1. 도서등록");
		String title = getData("도서 제목:");
		String author = getData("저자:");
		
		Book a =new Book(count,title,author);
		for(int i=0;i<books.length;i++) {
			if(books[i]==null) {
				books[i]= a;
				System.out.println("등록완료:");
				count++;
				return;
			}
		}
		System.out.println("등록실패:");
	}
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for(int i=0;i<books.length;i++) {
			if(books[i]!=null) {
				printBookInfo(books[i]);
			}
		}
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		int num = getSelectNum("수정할 도서 관리 번호를 입력하세요:");
		Book foundBook= findBook(num);
		if(foundBook!=null) {
			String title =getData("제목수정:");
			String author = getData("저자수정:");
			System.out.println("도서정보가 수정:");
		}else {
			System.out.println("해당도서를 찾을수가 없음");
		}
				}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
	    System.out.println("4. 도서삭제");
	    int num = getSelectNum("삭제할 도서 관리 번호를 입력하세요: ");
	    Book foundBook = findBook(num);
	    if (foundBook != null) {
	        for (int i = 0; i < books.length; i++) {
	            if (books[i] != null && books[i].num == num) {
	                books[i] = null;
	                System.out.println("도서가 삭제되었습니다.");
	                return;
	            }
	        }
	    } else {
	        System.out.println("해당 도서를 찾을 수 없습니다.");
	    }
	}
	// 책 정보 출력
	public void printBookInfo(Book b) {
		System.out.println(b.toString());
	}
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
for(int i=0;i<books.length;i++) {
	if(books[i]!=null) {
		return books[i];
	}
}
		return null;
	}
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	
	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		return scanSelectnum.nextInt();
	}
		
	public static void main(String[] args) {
		new BookManagement();
	}

}

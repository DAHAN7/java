package encapsulation_obj_array.book;

import java.util.Scanner;

public class BookManagement {
	
	// 문자열 입력
	private Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	private Scanner scanSelectnum = new Scanner(System.in);
	
	// 도서목록을 저장할 배열
	private static Book[] books = new Book[100];
	// 프로그램 실행 flag
	private boolean isRun = true;
	// 메인 메뉴 선택 번호
	private int selectNo = 0;
	
	public BookManagement(){}
	
	public void run() {
		while(isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요>");
			
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
			} // end switch
		} // end while
	} // end run method
	
	// 프로그램 종료
	public void terminate() {
		this.isRun = false;
		System.out.println("프로그램 종료");
	}

	// 도서 등록
	public void  registerBook() {
	    System.out.println("1. 도서등록");
	    String title = getData("등록할 도서의 제목을 입력해 주세요 >");
	    String author = getData("등록할 도서의 저자를 입력해 주세요 >");
	    
	    int i = 0;
	    while (i < books.length) {
	        if (books[i] == null) {
	            int count = 0;
	            books[i] = new Book(count++, title, author);
	            System.out.println("등록 완료");
	            return;
	        }
	        i++;
	    }
	    System.out.println("더 이상 도서를 등록할 수 없습니다. 현재 등록된 도서 수: " + books.length);
	}

	
	// 도서 목록 출력
	public void selectBook() {
		  if (books == null) {
		        System.out.println("도서 목록이 초기화되지 않았습니다.");
		        return;
		    }
		System.out.println("2. 도서목록");
		for(Book book : books) {
			if(book != null) {
				String info = book.toString();
				System.out.println(info);
			} 
		} 
	}


	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		int bookNum = getSelectNum("수정하실 책의 관리번호를 입력하세요.");
		
		Book updateBook = findBook(bookNum);
		
		if(updateBook == null) {
			System.out.println("잘못된 번호입니다.");
			return; // updateBook() 종료
		}
		
		System.out.println(updateBook.toString());
		
		boolean isUpdate = true;
		
		while(isUpdate) {
			System.out.println("==============================");
			System.out.println("1.제목수정 | 2.저자수정 | 3.수정완료");
			System.out.println("==============================");
			
			int no = getSelectNum("번호 입력 > ");
			
			switch(no) {
				case 1 :
					System.out.println("제목 수정");
					String title = getData("수정할 제목 입력 > ");
					// 새로 입력 받은 책 제목으로 책 제목 정보 수정
					updateBook.setTitle(title);
					break;
				case 2 : 
					System.out.println("저자 수정");
					String author = getData("수정할 저자 이름 입력 > ");
					updateBook.setAuthor(author);
					break;
				case 3 : 
					System.out.println("수정 완료");
					// update while문의 반복문 탈출 flag를 false
					// 로 변경하여 수정 반복문 탈출
					isUpdate = false;
					break;
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");	
			}
			
		}
		
	}
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		
		// 삭제할 도서이 도서관리번호를 저장하는 변수
		int bookNum = getSelectNum("삭제할 도서의 관리번호를 입력해 주세요.");
		
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null && books[i].getNum() == bookNum) {
				// 삭제하고자 하는 도서 관리번호가 일치하는 책이 저장된 위치
				// books[i]
				books[i] = null;
				System.out.println("삭제완료");
				break;
			}
			
		} // end for : books 배열 순회
		
	} // end deleteBook method
	
	// 책 정보 출력
	public void printBookInfo(Book b) {
		System.out.println(b.toString());
	}
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null && books[i].getNum() == num) {
				// books배열에 도서관리번호가 일치하는 책을 찾았다면
				// findBook()을 호출한 위치에 해당 도서를 반환
				return books[i];
			}
		}// end for : books 배열 순회
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
		if(!scanSelectnum.hasNextInt()) {
			System.out.println("숫자를 입력해주세요.");
			scanSelectnum.next();
			return 0;
		}
		return scanSelectnum.nextInt();
	}
	

}



package quiz;

import java.util.ArrayList;
import java.util.Scanner;

import quiz.Info2;

public class MainClass {
	public static void main(String[] args) {
	DBClass db = new DBClass();
	Info2 info2 = new Info2();
	Scanner sc = new Scanner(System.in);
	int num, age, result = 0;
	 String id, name, addr = null;
	while(true) {
		
		System.out.println("1.등록");
		System.out.println("2.조회");
		System.out.println("3.목록");
		System.out.println("4.삭제");
		System.out.println("5.수정");
		num = sc.nextInt();
		
	switch(num) {
		case 1:
			System.out.println("아이디 입력 :");
			id = sc.next();
			System.out.println("이름 입력 :");
			name = sc.next();
			System.out.println("나이 입력 :");
			age = sc.nextInt();
			System.out.println("주소 입력 :");
			addr = sc.next();
			info2.setId(id);
			info2.setName(name);
			info2.setAge(age);
			info2.setAddr(addr);
			
			result = db.insert(info2);
			if(result == 1) {
				System.out.println("저장되었습니다");
			}else {
				System.out.println("저장 실패");
			}
			break;
		case 2:
			System.out.println("검색할 아이디 입력 : ");
			id = sc.next();
			info2 = db.serch(id);
			if(info2 == null) {
				System.out.println("해당아이디는 존재하지 않습니다.");
			}else {
				System.out.println("아이디 : "+info2.getId());
				System.out.println("이름 : "+info2.getName());
				System.out.println("나이 : "+info2.getAge());
				System.out.println("주소 : "+info2.getAddr());
			}
			break;
		case 3:
			ArrayList<Info2> list =db.select();
			if(list.size() == 0) {
				System.out.println("정보가 존재하지 않습니다");
			}else {
				for(Info2 in : list) {
					System.out.println(in.getId());
					System.out.println(in.getName());
					System.out.println(in.getAge());
					System.out.println(in.getAddr());
					System.out.println("----------");
				}
			}
			break;
		case 4:
			System.out.println("삭제할 아이디 입력");
			id = sc.next();
			db.delete(id);
			System.out.println("삭제되었습니다.");
			break;
		case 5:
			
			break;
	}
	}
	}
}










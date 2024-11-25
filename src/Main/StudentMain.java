package Main;

import java.util.Scanner;

import Controller.StudentCotroller;
import Repository.StudentRepository;

public class StudentMain {
	public static void main(String[] args) {
		StudentCotroller st = new StudentCotroller();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Thêm thông tin học sinh:");
			System.out.println("2. Hiển thị thông tin học sinh:");
			System.out.println("3. Cập nhạt thông tin học sinh:");
			System.out.println("4. Xóa thông tin học sinh:");
			System.out.println("5. Tìm kiếm học sinh theo id:");
			System.out.println("6. Thoát khỏi chương trình:");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				st.addStudent();
				break;
			case 2:
				st.displayStudents();
			case 3:
				st.updateStudent();
			case 4:
				st.deleteStudent();
			case 5:
				st.findStudentById();
			case 6:
				System.out.println("Thoát khỏi chương trình:");
			default:
				break;
			}
		}
	}
	

	


}

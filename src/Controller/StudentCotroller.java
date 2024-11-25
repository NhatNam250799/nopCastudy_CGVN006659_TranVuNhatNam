package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entity.Student;

public class StudentCotroller {
	private List<Student> students;
	private final String filePathString = "C:\\Users\\ASUS\\Desktop\\test.txt";

	public StudentCotroller() {
		students = readFromFile();
		if (students == null) {
			students = new ArrayList<>();
		}
	}

	private void saveToFile() {
        File file = new File(filePathString);
        OutputStream outputStream = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			 ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
		} catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
	}

	private List<Student> readFromFile() {
		try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(filePathString))) {
			return (List<Student>) oiStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	public void addStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập id: ");
		String id = scanner.nextLine();

		System.out.println("Nhập tên: ");
		String name = scanner.nextLine();

		System.out.println("Nhập tuổi: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		students.add(new Student());
		saveToFile();
		System.out.println("Học sinh được thêm thành công");
		
	}

	public void displayStudents() {
		if (students.isEmpty()) {
			System.out.println("Không có sinh viên nào có sẵn");
		} else {
			students.forEach(System.out::println);

		}
	}

	public void updateStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập id học sinh để cập nhật");
		String id = scanner.nextLine();
		Student students = new Student();
		if (id != null && id.equals(students.getId())) {
			System.out.println("Nhập tên mới: ");
			String name = scanner.nextLine();

			System.out.println("Nhập tuổi mới:");
			int age = scanner.nextInt();
			scanner.nextLine();
			students.setName(name);
			students.setAge(age);
			saveToFile();
			System.out.println("Học sinh cập nhật thành công: ");
			return;
		}

	}

	public void deleteStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập id của học sinh cần xóa: ");
		String id = scanner.nextLine();

		students.removeIf(student -> student.getId().equals(id));
		saveToFile();
		System.out.println("Xóa id học sinh thành công:");
	}
	public Student findStudentById() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("tìm kiếm học sinh theo id: ");
		String id = scanner.nextLine();
		Student students = new Student();
			if(students.getId().equals(id)) {
				return students;
			}
			return null;
		}
	}


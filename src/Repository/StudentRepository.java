package Repository;


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

import Entity.Student;

public class StudentRepository {
	
	 
	 private final String filePathString ="C:\\Users\\ASUS\\Documents\\file";
	 @SuppressWarnings("unchecked")
	public List<Student> getAll(){
		 List<Student> students = new ArrayList<>();
		 File file = new File (filePathString);
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            students = (List<Student>) objectInputStream.readObject();
	            objectInputStream.close();
			} catch (FileNotFoundException e) {
				System.out.println("Lỗi không tìm thấy file");
			} catch (IOException e) {
				System.out.println("Lỗi đọc file");
			}catch (ClassNotFoundException e) {
	            System.out.println("Loi khong tim thay class");
			}
		 
		return students;
		 
	 }
	  public void writeFileBinary(List<Student> students) {
	        File file = new File(filePathString);
	        OutputStream outputStream = null;
	        try {
	            outputStream = new FileOutputStream(file);
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	            objectOutputStream.writeObject(students);
	            objectOutputStream.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Lỗi không tìm thấy file");
	        } catch (IOException e) {
	            System.out.println("Lỗi ghi file");
	        }
	    }
	  public void deleteById(int id) {
	        List<Student> students = getAll();
	        for (Student student : students) {
	            if (student.hashCode() == id) {
	                students.remove(student);
	                break;
	            }
	        }
	        writeFileBinary(students);

	    }
}
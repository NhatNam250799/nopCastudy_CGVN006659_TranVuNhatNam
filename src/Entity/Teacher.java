package Entity;

public class Teacher {
	private String teacherId;
	private String teacherName;
	private String address;
	public Teacher() {
		super();
	}
	public Teacher(String teacherId, String teacherName, String address) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.address = address;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", address=" + address + "]";
	}
	
}

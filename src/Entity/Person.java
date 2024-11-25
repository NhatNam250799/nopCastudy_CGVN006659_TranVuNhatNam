package Entity;

import java.util.Objects;

public class Person {
	private long code;
	private String name;
	private String address;

	public Person() {
		super();
	}

	public Person(long code, String name, String address) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	 public int hashCode() {
	        return Objects.hash(code, name);
	    }
	public String toString() {
		return "Person [code=" + code + ", name=" + name + ", address=" + address + "]";
	}

}

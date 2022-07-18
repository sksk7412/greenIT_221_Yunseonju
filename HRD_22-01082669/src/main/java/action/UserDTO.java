package action;

import java.sql.Timestamp;

public class UserDTO {
	
	private String custname,phone,address,grade,city; 
	private static int custno = 2;
	private Timestamp create;
	public UserDTO(String custname, String phone, String address, String grade, String city) {
		
		this.custno = custno++; 
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
		this.city = city;
		this.create = new Timestamp(System.currentTimeMillis());
	}

	public static int getCustno() {
		return custno;
	}

	public static void setCustno(int custno) {
		UserDTO.custno = custno;
	}

	public Timestamp getCreate() {
		return create;
	}

	public void setCreate(Timestamp create) {
		this.create = create;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}

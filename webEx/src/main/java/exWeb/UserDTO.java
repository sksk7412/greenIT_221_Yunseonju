package exWeb;

public class UserDTO {
	
	private String id,password,name;
	private int year,month,day;
	private String gender,email,country,mobile;
	
	public UserDTO(String id,String password, String name, int year, int month, int day, String gender, String email, String country, String mobile) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
		this.email = email;
		this.country = country;
		this.mobile = mobile;
	}
	public UserDTO(String id,String password) {
		this.id = id;
		this.password = password;
	}
	
	// get & set
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}

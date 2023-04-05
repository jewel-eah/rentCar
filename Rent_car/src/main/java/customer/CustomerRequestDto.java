package customer;


public class CustomerRequestDto {

	private int cuscode;
	private String cusname;
	private String contact;
	private String email;
	private String id;
	private String password;
	private int age;
	private String joindate;
	
	
	public CustomerRequestDto (int cuscode, String cusname, String contact, String email, String id, String password, int age, String joindate) {
		this.cuscode = cuscode;
		this.cusname = cusname;
		this.contact = contact;
		this.email = email;
		this.id = id;
		this.password = password;
		this.age = age;
		this.joindate = joindate;
	}

	public int getCuscode() {
		return cuscode;
	}


	public void setCuscode(int cuscode) {
		this.cuscode = cuscode;
	}


	public String getCusname() {
		return cusname;
	}


	public void setCusname(String cusname) {
		this.cusname = cusname;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getJoindate() {
		return joindate;
	}


	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	
	

	
	
	
	
}

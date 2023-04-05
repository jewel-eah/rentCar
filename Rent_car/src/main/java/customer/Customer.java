package customer;

import java.sql.Timestamp;

import customer.controller.CustomerDao;


// VO
public class Customer {
	
	private int cuscode;
	private String cusname;
	private String contact;
	private String email;
	private String id;
	private String password;
	private int age;
	private String joindate;
	
	
	public Customer (int cus_code, String cus_name, String contact, String email, String id, String password, int age, String joindate) {
		this.cuscode = cus_code;
		this.cusname = cus_name;
		this.contact = contact;
		this.email = email;
		this.id = id;
		this.password = password;
		this.age = age;
		this.joindate = joindate;
	}
	
	
	public Customer(CustomerRequestDto customerDto) {
		CustomerDao customerDao = CustomerDao.getInstacne();
		
		this.cuscode = customerDao.getCuscodeMax() +1;
		this.cusname = customerDto.getCusname();
		this.contact = customerDto.getContact();
		this.email = customerDto.getEmail();
		this.id = customerDto.getId();
		this.password = customerDto.getPassword();
		this.age = customerDto.getAge();
		this.joindate = customerDto.getJoindate();
	}

	public int getCuscode() {
		return cuscode;
	}


	public String getCusname() {
		return cusname;
	}


	public String getContact() {
		return contact;
	}


	public String getEmail() {
		return email;
	}


	public String getId() {
		return id;
	}


	public String getPassword() {
		return password;
	}


	public int getAge() {
		return age;
	}


	public String getJoindate() {
		return joindate;
	}

	
	
}

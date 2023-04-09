package customer.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.DBManager;
import customer.Customer;
import customer.CustomerRequestDto;

public class CustomerDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private CustomerDao() {
	}

	private static CustomerDao instance = new CustomerDao();

	public static CustomerDao getInstacne() {
		return instance;
	}

	// create
	public void createCustomer(CustomerRequestDto customerDto) {
		Customer customer = new Customer(customerDto);

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, customer.getCuscode());
				this.pstmt.setString(2, customer.getCusname());
				this.pstmt.setString(3, customer.getContact());
				this.pstmt.setString(4, customer.getEmail());
				this.pstmt.setString(5, customer.getId());
				this.pstmt.setString(6, customer.getPassword());
				this.pstmt.setInt(7, customer.getAge());
				this.pstmt.setString(8, customer.getJoindate());

				this.pstmt.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// read
	public ArrayList<Customer> getCustomerAll() {
		ArrayList<Customer> list = new ArrayList<Customer>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM customers ORDER BY cus_code";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int cus_code = this.rs.getInt(1);
					String cus_name = this.rs.getString(2);
					String contact = this.rs.getString(3);
					String email = this.rs.getString(4);
					String id = this.rs.getString(5);
					String password = this.rs.getString(6);
					int age = this.rs.getInt(7);
					String joindate = this.rs.getString(8);

					Customer customer = new Customer(cus_code, cus_name, contact, email, id, password, age, joindate);
					list.add(customer);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// 특정 고객 정보 찾기

	public Customer getCustomerById(String id) {
		Customer customer = null;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			try {
				String sql = "SELECT * FROM customer WHERE id =?";

				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int cuscode = this.rs.getInt(1);
					String cusname = this.rs.getString(2);
					String contact = this.rs.getString(3);
					String email = this.rs.getString(4);
					String password = this.rs.getString(6);
					int age = this.rs.getInt(7);
					String joindate = this.rs.getString(8);

					customer = new Customer(cuscode, cusname, contact, email, id, password, age, joindate);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return customer;
	}

	// cus_code 마지막값찾기
	public int getCuscodeMax() {
		int cusCode = 1;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT MAX(cus_code) FROM customer";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				this.rs.next();
				cusCode = this.rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		return cusCode;
	}
	
	// 아이디로 이름가져오기
	public String getCusNameById(String id) {
		String cusName = "";
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql= "SELECT cusName FROM customer WEHRE id=";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				this.rs.next();
				cusName = this.rs.getString(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		return cusName;
	}
	
	
	// update
	public void updateCustomer(CustomerRequestDto customerDto) {
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql ="UPDATE customer SET cusname=?, contact=?, email=?, id=?, password=?, age=?, joindate=? WHERE cuscode=?";
				
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, customerDto.getCusname());
				this.pstmt.setString(2, customerDto.getContact());
				this.pstmt.setString(3, customerDto.getEmail());
				this.pstmt.setString(4, customerDto.getId());
				this.pstmt.setString(5, customerDto.getPassword());
				this.pstmt.setInt(6, customerDto.getAge());
				this.pstmt.setString(7, customerDto.getJoindate());
				this.pstmt.setInt(8, customerDto.getCuscode());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// delete
	public void removeCustomerById(String id) {
		Customer customer = getCustomerById(id);
		this.conn = DBManager.getConnection();
		
		if(customer != null && this.conn != null) {
			String sql = "DELETE FROM customer WHERE id = ?;";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
}

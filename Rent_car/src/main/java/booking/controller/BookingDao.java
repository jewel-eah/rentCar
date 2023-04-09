package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.DBManager;
import booking.Booking;
import booking.BookingRequestDto;

public class BookingDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BookingDao instance = new BookingDao();

	public static BookingDao getInstance() {
		return instance;
	}

	// c
	public void createBooking(BookingRequestDto bookingDto) {
		Booking booking = new Booking(bookingDto);

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO booking VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?))";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, booking.getCarCode());
				this.pstmt.setString(2, booking.getCusName());
				this.pstmt.setInt(3, booking.getCusCode());
				this.pstmt.setString(4, booking.getVenueId());
				this.pstmt.setInt(5, booking.getHour());
				this.pstmt.setInt(6, booking.getBookCode());
				this.pstmt.setInt(7, booking.getTotalPrice());
				this.pstmt.setString(8, booking.getBookDate());
				this.pstmt.setString(9, booking.getStartDate());
				this.pstmt.setString(10, booking.getPeriodDate());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// bookCode 생성
	public int getBookCodeMax() {
		int bookCode = 1;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT MAX(book_code) FROM booking";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				this.rs.next();
				bookCode = this.rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace(); 
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		
		return bookCode;
	}
	
	// r

	public ArrayList<Booking> getBookingAll() {
		ArrayList<Booking> list = new ArrayList<Booking>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM booking ORDER BY book_date";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int carCode = this.rs.getInt(1);
					String cusName = this.rs.getString(2);
					int cusCode = this.rs.getInt(3);
					String venueId = this.rs.getString(4);
					int hour = this.rs.getInt(5);
					int bookCode = this.rs.getInt(6);
					int totalPrice = this.rs.getInt(7);
					String bookDate = this.rs.getString(8);
					String startDate = this.rs.getString(9);
					String periodDate = this.rs.getString(10);

					Booking booking = new Booking(carCode, cusName, cusCode, venueId, hour, bookCode, totalPrice,
							bookDate, startDate, periodDate);
					list.add(booking);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// u
	// d

}

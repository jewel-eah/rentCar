package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.DBManager;
import customer.Customer;
import vehicle.Vehicle;
import vehicle.VehicleRequestDto;

public class VehicleDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private VehicleDao() {
	}

	private static VehicleDao instance = new VehicleDao();

	public static VehicleDao getInstance() {
		return instance;
	}

	// create
	public void createVehicle(VehicleRequestDto vehicleDto) {
		Vehicle vehicle = new Vehicle(vehicleDto);

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO vehicle VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, vehicle.getCarcode());
				this.pstmt.setString(2, vehicle.getCarname());
				this.pstmt.setString(3, vehicle.getCarbrand());
				this.pstmt.setString(4, vehicle.getBookstatus());
				this.pstmt.setInt(5, vehicle.getPrice());
				this.pstmt.setString(6, vehicle.getOption());
				this.pstmt.setInt(7, vehicle.getSeat());
				this.pstmt.setString(8, vehicle.getVenueid());

				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}

	}

	// car_code 마지막값찾기
	public int getCarcodeMax() {
		int carCode = 1;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT MAX(car_code) FROM vehicle";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				this.rs.next();
				carCode = this.rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		return carCode;
	}
	
	// carCode로 프라이스 찾기
	public int getPriceByCarcode(int carCode) {
		int total = 0;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT price FROM vehicle";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				this.rs.next();
				total = this.rs.getInt(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
					
		}
		
		return total;
	}
	
	
	// 로케이션주소 반환 
	public String getLocationById(String venueId) {
		String location = null;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null){
			String sql = "SELECT venue_id FROM venue";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				this.rs.next();
				location = this.rs.getString(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt,rs);
			} 
		}
		return location;
	}

	
	// read
	public ArrayList<Vehicle> getVehicleAll() {
			ArrayList<Vehicle> list = new ArrayList<Vehicle>();

			this.conn = DBManager.getConnection();
			if (this.conn != null) {
				String sql = "SELECT * FROM vehicle ORDER BY car_code";

				try {
					this.pstmt = this.conn.prepareStatement(sql);
					this.rs = this.pstmt.executeQuery();

					while (this.rs.next()) {
						int carcode = this.rs.getInt(1);
						String carname = this.rs.getString(2);
						String carbrand = this.rs.getString(3);
						String bookstatus = this.rs.getString(4);
						int price = this.rs.getInt(5);
						String option = this.rs.getString(6);
						int seat = this.rs.getInt(7);
						String venueid = this.rs.getString(8);
						
						Vehicle vehicle = new Vehicle(carcode, carname, carbrand, bookstatus, price, option, seat, venueid);
						list.add(vehicle);
					}
						
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
			}
			return list;
	}
}

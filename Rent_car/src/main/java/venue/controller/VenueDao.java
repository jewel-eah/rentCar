package venue.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.DBManager;
import venue.Venue;
import venue.VenueRequestDto;

public class VenueDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private VenueDao() {}
	private static VenueDao instance = new VenueDao();
	public static VenueDao getInstance() {
		return instance;
	}
	
	
	// c
	public void createVenue(VenueRequestDto venueDto) {
		Venue venue = new Venue(venueDto);
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "INSERT INTO venue VALUES (?, ?)";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, venue.getVenueid());
				this.pstmt.setString(0, venue.getVenuename());
				
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace(); 
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
	}
	
	// r [ 뷰 테이블 만들어둠 ]
	public ArrayList<Venue> getVenueAll(){
		ArrayList<Venue> list = new ArrayList<Venue>();
		
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT * FROM venues";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String venueId = this.rs.getString(1);
					String venueName = this.rs.getString(2);
					
					Venue venue = new Venue(venueId, venueName);
					list.add(venue);
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

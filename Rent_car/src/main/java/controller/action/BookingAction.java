package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vehicle.controller.VehicleDao;

public class BookingAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession session = request.getSession();
		
		VehicleDao vehicleDao = VehicleDao.getInstance();
		
		String carCode = request.getParameter("carCode");
		String cusName = request.getParameter("cusName");
		String cusCode =request.getParameter("cusCode");
		String venueId = request.getParameter("venueId");
		int hour = 0;
		String bookCode= request.getParameter("booCode");
//		int totalPrice = vehicleDao.getPriceByCarcode(carCode) * hour;
		String bookDate = request.getParameter("bookDate");

		// 받아온 날짜정보 
		String tempStartDate = request.getParameter("startDate");
		String tempStartHour = request.getParameter("startHour");
		String tempPeriodDate = request.getParameter("periodDate");
		String tempEndHour = request.getParameter("endHour");
		
		
		// 가공된 날짜 ()
		int startDate = Integer.parseInt(tempStartDate.split("-")[0]+tempStartDate.split("-")[1]+tempStartDate.split("-")[2]);
		int startHour = Integer.parseInt(tempStartHour.split(":")[0]);
		int startMin = Integer.parseInt(tempStartHour.split(":")[1]);
		int periodDate = Integer.parseInt(tempPeriodDate.split("-")[0]+tempPeriodDate.split("-")[1]+tempPeriodDate.split("-")[2]);
		int endHour = Integer.parseInt(tempEndHour.split(":")[0]);
		int endMin = Integer.parseInt(tempStartHour.split(":")[1]);
		
		
		int days = periodDate - startDate;
		int hours = (24-startHour) + endHour;
		
		if(days > 1) {
			hour = (24*(days-1)) + hours;
		} 
		else {
				hour = hours;
		}

		
		System.out.println("startDate: "+startDate);
		System.out.println("startHour: "+startHour);
		System.out.println("periodDate: "+periodDate);
		System.out.println("endHour: "+endHour);
		System.out.println("hour: "+hour);
		
		
		
		
//		this.pstmt.setInt(1, booking.getCarCode());
//		this.pstmt.setString(2, booking.getCusName());
//		this.pstmt.setInt(3, booking.getCusCode());
//		this.pstmt.setString(4, booking.getVenueId());
//		this.pstmt.setInt(5, booking.getHour());
//		this.pstmt.setInt(6, booking.getBookCode());
//		this.pstmt.setInt(7, booking.getTotalPrice());
//		this.pstmt.setString(8, booking.getBookDate());
//		this.pstmt.setString(9, booking.getStartDate());
//		this.pstmt.setString(10, booking.getPeriodDate());

		
	}
 
}

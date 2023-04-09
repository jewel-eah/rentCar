package booking;

public class Booking {
	
	private int carCode;
	private String cusName;
	private int cusCode;
	private String venueId;
	private int hour;
	private int bookCode;
	private int totalPrice;
	private String bookDate;
	private String startDate;
	private String periodDate;
	
	public Booking (int carCode, String cusName, int cusCode, String venueId, int hour, int bookCode, int totalPrice, String bookDate, String startDate, String periodDate) {
		this.carCode = carCode;
		this.cusName = cusName;
		this.cusCode = cusCode;
		this.venueId = venueId;
		this.hour = hour;
		this.bookCode = bookCode;
		this.bookDate = bookDate;
		this.startDate = startDate;
		this.periodDate = periodDate;
	}

	public Booking (BookingRequestDto bookingDto) {
		this.carCode = bookingDto.getCarCode();
		this.cusName = bookingDto.getCusName();
		this.cusCode = bookingDto.getCusCode();
		this.venueId = bookingDto.getVenueId();
		this.hour = bookingDto.getHour();
		this.bookCode = bookingDto.getBookCode();
		this.totalPrice = bookingDto.getTotalPrice();
		this.bookDate = bookingDto.getBookDate();
		this.startDate = bookingDto.getStartDate();
		this.periodDate = bookingDto.getPeriodDate();
	}

	public int getCarCode() {
		return carCode;
	}

	public String getCusName() {
		return cusName;
	}

	public int getCusCode() {
		return cusCode;
	}

	public String getVenueId() {
		return venueId;
	}

	public int getHour() {
		return hour;
	}

	public int getBookCode() {
		return bookCode;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public String getBookDate() {
		return bookDate;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getPeriodDate() {
		return periodDate;
	}
	
	

	
	
}

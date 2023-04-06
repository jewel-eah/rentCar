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
	
	public Booking (int carCode, String cusName, int cusCode, String venueId, int hour, int bookCode, int totalPrice, String bookDate) {
		this.carCode = carCode;
		this.cusName = cusName;
		this.cusCode = cusCode;
		this.venueId = venueId;
		this.hour = hour;
		this.bookCode = bookCode;
		this.bookDate = bookDate;
	}

	public Booking (BookingRequestDto bookingDtoo) {
		this.carCode = bookingDtoo.getCarCode();
		this.cusName = bookingDtoo.getCusName();
		this.cusCode = bookingDtoo.getCusCode();
		this.venueId = bookingDtoo.getVenueId();
		this.hour = bookingDtoo.getHour();
		this.bookCode = bookingDtoo.getBookCode();
		this.totalPrice = bookingDtoo.getTotalPrice();
		this.bookDate = bookingDtoo.getBookDate();
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

	
	
}

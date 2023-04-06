package booking;

public class BookingRequestDto {
	
	private int carCode;
	private String cusName;
	private int cusCode;
	private String venueId;
	private int hour;
	private int bookCode;
	private int totalPrice;
	private String bookDate;
	
	public BookingRequestDto (int carCode, String cusName, int cusCode, String venueId, int hour, int bookCode, int totalPrice, String bookDate) {
		this.carCode = carCode;
		this.cusName = cusName;
		this.cusCode = cusCode;
		this.venueId = venueId;
		this.hour = hour;
		this.bookCode = bookCode;
		this.totalPrice = totalPrice;
		this.bookDate = bookDate;
	}


	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public int getCusCode() {
		return cusCode;
	}

	public void setCusCode(int cusCode) {
		this.cusCode = cusCode;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	

}

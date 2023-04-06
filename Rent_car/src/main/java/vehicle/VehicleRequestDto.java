package vehicle;

public class VehicleRequestDto {

	
	private int carcode;
	private String carname;
	private String carbrand;
	private String bookstatus;
	private int price;
	private String option;
	private int seat;
	private String venueid;
	
	public VehicleRequestDto (int carcode, String carname, String carbrand, String bookstatus, int price, String option, int seat, String venueid) {
		this.carcode = carcode;
		this.carname = carname;
		this.carbrand = carbrand;
		this.bookstatus = bookstatus;
		this.price = price;
		this.option = option;
		this.seat = seat;
		this.venueid = venueid;
	}

	public int getCarcode() {
		return carcode;
	}

	public void setCarcode(int carcode) {
		this.carcode = carcode;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCarbrand() {
		return carbrand;
	}

	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}

	public String getBookstatus() {
		return bookstatus;
	}

	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getVenueid() {
		return venueid;
	}

	public void setVenueid(String venueid) {
		this.venueid = venueid;
	}
	
	
	
}

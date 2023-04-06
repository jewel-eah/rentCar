package vehicle;

import customer.CustomerRequestDto;
import customer.controller.CustomerDao;
import vehicle.controller.VehicleDao;

// vo 
public class Vehicle {
	
	private int carcode;
	private String carname;
	private String carbrand;
	private String bookstatus;
	private int price;
	private String option;
	private int seat;
	private String venueid;
	
	public Vehicle (int carcode, String carname, String carbrand, String bookstatus, int price, String option, int seat, String venueid) {
		this.carcode = carcode;
		this.carname = carname;
		this.carbrand = carbrand;
		this.bookstatus = bookstatus;
		this.price = price;
		this.option = option;
		this.seat = seat;
		this.venueid = venueid;
	}

	
	public Vehicle(VehicleRequestDto vehicleDto) {
		VehicleDao vehicleDao = VehicleDao.getInstance();
		
		this.carcode = vehicleDao.getCarcodeMax() +1;
		this.carname = vehicleDto.getCarname();
		this.carbrand = vehicleDto.getCarbrand();
		this.bookstatus = vehicleDto.getBookstatus();
		this.price = vehicleDto.getPrice();
		this.option = vehicleDto.getOption();
		this.seat = vehicleDto.getSeat();
		this.venueid = vehicleDto.getVenueid();
	}

	public int getCarcode() {
		return carcode;
	}

	public String getCarname() {
		return carname;
	}

	public String getCarbrand() {
		return carbrand;
	}

	public String getBookstatus() {
		return bookstatus;
	}

	public int getPrice() {
		return price;
	}

	public String getOption() {
		return option;
	}

	public int getSeat() {
		return seat;
	}

	public String getVenueid() {
		return venueid;
	}
	
	
	
	
}

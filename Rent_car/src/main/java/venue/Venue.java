package venue;

public class Venue {
	private String venueId;
	private String venueName;
	
	public Venue(String venueId, String venueName) {
		this.venueId = venueId;
		this.venueName = venueName;
	}

//	public Venue(VenuReqtestDto Dto) {
//		
//	}
	
	public Venue(VenueRequestDto venueDto) {
		this.venueId = venueDto.getVenueId();
		this.venueName = venueDto.getVenueName();
	}

	public String getVenueid() {
		return venueId;
	}

	public String getVenuename() {
		return venueName;
	}
	
	
}

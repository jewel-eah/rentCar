package venue;

public class VenueRequestDto {
	
	private String venueId;
	private String venueName;
	
	public VenueRequestDto(String venueId, String venueName) {
		this.venueId = venueId;
		this.venueName = venueName;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	
}

package ca.mcgill.carpooling.model.carpooling;

import java.util.UUID;

public class Stop {
	private String id;
	private String city_id;
	private String trip_id;
	//booking_id 删除
	private String booking_id;
	private int seq_no;
	private float cost;
	private int seats;
	private String time;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public int getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}

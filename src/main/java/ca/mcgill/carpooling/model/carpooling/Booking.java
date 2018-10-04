package ca.mcgill.carpooling.model.carpooling;

public class Booking {
	
	private String id;
	private String p_id;
	private String d_id;
	private float p_score;
	private float d_score;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public float getP_score() {
		return p_score;
	}
	public void setP_score(float p_score) {
		this.p_score = p_score;
	}
	public float getD_score() {
		return d_score;
	}
	public void setD_score(float d_score) {
		this.d_score = d_score;
	}
	
	
}

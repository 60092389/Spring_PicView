package picView.follow.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Follow implements Serializable {
	private int follow_no;
	private int mem_no;
	private int follow_fri_no;
	private String follow_check;
	private Timestamp follow_date;
	
	public Follow(){}
	
	public Follow(int follow_no, int mem_no, int follow_fri_no, String follow_check, Timestamp follow_date) {
		super();
		this.follow_no = follow_no;
		this.mem_no = mem_no;
		this.follow_fri_no = follow_fri_no;
		this.follow_check = follow_check;
		this.follow_date = follow_date;
	}

	public int getFollow_no() {
		return follow_no;
	}

	public void setFollow_no(int follow_no) {
		this.follow_no = follow_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public int getFollow_fri_no() {
		return follow_fri_no;
	}

	public void setFollow_fri_no(int follow_fri_no) {
		this.follow_fri_no = follow_fri_no;
	}

	public String getFollow_check() {
		return follow_check;
	}

	public void setFollow_check(String follow_check) {
		this.follow_check = follow_check;
	}

	public Timestamp getFollow_date() {
		return follow_date;
	}

	public void setFollow_date(Timestamp follow_date) {
		this.follow_date = follow_date;
	}
		
}

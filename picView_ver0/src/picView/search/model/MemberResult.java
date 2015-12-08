package picView.search.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberResult implements Serializable {
	private int mem_no;
	private String mem_id;
	private String mem_pic;
	private String mem_name;
	private int pic_count;
	private Timestamp mem_date;
	private int fol_check;
	
	
	public MemberResult() {}

	public MemberResult(int mem_no, String mem_id, String mem_pic, String mem_name, int pic_count, Timestamp mem_date,
			int fol_check) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_pic = mem_pic;
		this.mem_name = mem_name;
		this.pic_count = pic_count;
		this.mem_date = mem_date;
		this.fol_check = fol_check;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pic() {
		return mem_pic;
	}

	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getPic_count() {
		return pic_count;
	}

	public void setPic_count(int pic_count) {
		this.pic_count = pic_count;
	}

	public Timestamp getMem_date() {
		return mem_date;
	}

	public void setMem_date(Timestamp mem_date) {
		this.mem_date = mem_date;
	}

	public int getFol_check() {
		return fol_check;
	}

	public void setFol_check(int fol_check) {
		this.fol_check = fol_check;
	}
	
		

}

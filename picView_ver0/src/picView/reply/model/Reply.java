package picView.reply.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reply implements Serializable{
	private int pic_no;
	private int mem_no;
	private String rep_content;
	private String rep_auth;
	private Timestamp rep_date;
	private String mem_name;
	private String mem_pic;
	
	public int getPic_no() {
		return pic_no;
	}
	public void setPic_no(int pic_no) {
		this.pic_no = pic_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public String getRep_auth() {
		return rep_auth;
	}
	public void setRep_auth(String rep_auth) {
		this.rep_auth = rep_auth;
	}
	public Timestamp getRep_date() {
		return rep_date;
	}
	public void setRep_date(Timestamp rep_date) {
		this.rep_date = rep_date;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pic() {
		return mem_pic;
	}
	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}
	
	
}

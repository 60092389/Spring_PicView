package picView.member.model;

import java.io.Serializable;

public class AuthInfo implements Serializable {
	private int mem_no;
	private String mem_id;
	private String mem_name;
	private String mem_pic;
	
	public AuthInfo(){}

	public AuthInfo(int mem_no, String mem_id, String mem_name, String mem_pic) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_pic = mem_pic;
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

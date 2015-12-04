package picView.follow.model;

import java.io.Serializable;

public class FollowRecommand implements Serializable {
	private int mem_no;
	private String mem_id;
	private String mem_name;
	private int pic_count;
	private String category_name;
	private String mem_pic;
	
	public FollowRecommand(){}

	public FollowRecommand(int mem_no, String mem_id, String mem_name, int pic_count, String category_name,
			String mem_pic) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.pic_count = pic_count;
		this.category_name = category_name;
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

	public int getPic_count() {
		return pic_count;
	}

	public void setPic_count(int pic_count) {
		this.pic_count = pic_count;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getMem_pic() {
		return mem_pic;
	}

	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}

	
	
	
	
	
}

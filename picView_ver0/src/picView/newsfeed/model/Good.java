package picView.newsfeed.model;

import java.io.Serializable;

public class Good implements Serializable{
	private int pic_no;
	private int mem_no;
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
	
}

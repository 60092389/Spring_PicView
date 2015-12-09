package picView.good.model;

import java.io.Serializable;

public class Good implements Serializable{
	private int good_no;
	private int pic_no;
	private int mem_no;
	
	public Good(){};
	
	public Good(int good_no, int pic_no, int mem_no) {
		super();
		this.good_no = good_no;
		this.pic_no = pic_no;
		this.mem_no = mem_no;
	}

	public int getGood_no() {
		return good_no;
	}

	public void setGood_no(int good_no) {
		this.good_no = good_no;
	}

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

	@Override
	public String toString() {
		return "Good [good_no=" + good_no + ", pic_no=" + pic_no + ", mem_no=" + mem_no + "]";
	}
	
}

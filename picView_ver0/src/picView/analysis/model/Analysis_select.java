package picView.analysis.model;

import java.io.Serializable;

public class Analysis_select implements Serializable{
	private int mem_no;
	private int pic_no;
	private String anl_word;
	
	public Analysis_select(){};
	
	public Analysis_select(int mem_no, int pic_no, String anl_word) {
		super();
		this.mem_no = mem_no;
		this.pic_no = pic_no;
		this.anl_word = anl_word;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public int getPic_no() {
		return pic_no;
	}

	public void setPic_no(int pic_no) {
		this.pic_no = pic_no;
	}

	public String getAnl_word() {
		return anl_word;
	}

	public void setAnl_word(String anl_word) {
		this.anl_word = anl_word;
	}

	@Override
	public String toString() {
		return "Analysis_select [mem_no=" + mem_no + ", pic_no=" + pic_no + ", anl_word=" + anl_word + "]";
	}
}

package picView.picture.model;

import java.io.Serializable;

public class ReplyCount implements Serializable{
	private int rep_count;
	private int pic_no;
	
	public ReplyCount(){}
	
	public ReplyCount(int rep_count, int pic_no) {
		super();
		this.rep_count = rep_count;
		this.pic_no = pic_no;
	}
	public int getRep_count() {
		return rep_count;
	}
	public void setRep_count(int rep_count) {
		this.rep_count = rep_count;
	}
	public int getPic_no() {
		return pic_no;
	}
	public void setPic_no(int pic_no) {
		this.pic_no = pic_no;
	}
	

}

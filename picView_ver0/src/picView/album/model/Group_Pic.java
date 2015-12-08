package picView.album.model;

import java.io.Serializable;

public class Group_Pic implements Serializable{
	
	private int group_no;
	private int alb_no;
	private int pic_no;
	
	
	public int getGoup_no() {
		return group_no;
	}
	public void setGoup_no(int goup_no) {
		this.group_no = goup_no;
	}
	public int getAlb_no() {
		return alb_no;
	}
	public void setAlb_no(int alb_no) {
		this.alb_no = alb_no;
	}
	public int getPic_no() {
		return pic_no;
	}
	public void setPic_no(int pic_no) {
		this.pic_no = pic_no;
	}
	
	

}

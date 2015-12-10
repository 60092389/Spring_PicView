package picView.picture.model;

import java.io.Serializable;

public class PictureResult implements Serializable{
	private String pic_title;
	private String pic_add;
	private String good_count;
	private String pic_count;
	private String mem_name;
	
	public String getPic_title() {
		return pic_title;
	}
	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}
	public String getPic_add() {
		return pic_add;
	}
	public void setPic_add(String pic_add) {
		this.pic_add = pic_add;
	}
	public String getGood_count() {
		return good_count;
	}
	public void setGood_count(String good_count) {
		this.good_count = good_count;
	}
	public String getPic_count() {
		return pic_count;
	}
	public void setPic_count(String pic_count) {
		this.pic_count = pic_count;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	
	

}

package picView.search.model;

import java.io.Serializable;

public class SearchResult implements Serializable{
	private String mem_name;
	private String pic_add;
	private String pic_title;
	private int good_count;
	private int count_rep_no;
	private int pic_no;
	private int mem_no;
	
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
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getPic_add() {
		return pic_add;
	}
	public void setPic_add(String pic_add) {
		this.pic_add = pic_add;
	}
	public String getPic_title() {
		return pic_title;
	}
	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}
	public int getGood_count() {
		return good_count;
	}
	public void setGood_count(int good_count) {
		this.good_count = good_count;
	}
	public int getCount_rep_no() {
		return count_rep_no;
	}
	public void setCount_rep_no(int count_rep_no) {
		this.count_rep_no = count_rep_no;
	}
	
	
}

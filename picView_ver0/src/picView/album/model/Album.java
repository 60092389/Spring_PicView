package picView.album.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Repository;


public class Album implements Serializable{
	
	private int alb_no;
	private int mem_no;
	private String alb_name;
	private String alb_content;
	private String alb_word;
	private String alb_open;
	private Date alb_date;
	
	


	public int getAlb_no() {
		return alb_no;
	}
	public void setAlb_no(int alb_no) {
		this.alb_no = alb_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getAlb_name() {
		return alb_name;
	}
	public void setAlb_name(String alb_name) {
		this.alb_name = alb_name;
	}
	public String getAlb_content() {
		return alb_content;
	}
	public void setAlb_content(String alb_content) {
		this.alb_content = alb_content;
	}
	public String getAlb_word() {
		return alb_word;
	}
	public void setAlb_word(String alb_word) {
		this.alb_word = alb_word;
	}
	public String getAlb_open() {
		return alb_open;
	}
	public void setAlb_open(String alb_open) {
		this.alb_open = alb_open;
	}
	public Date getAlb_date() {
		return alb_date;
	}
	public void setAlb_date(Date alb_date) {
		this.alb_date = alb_date;
	}
	
	
	
	
	
	
	
	

}

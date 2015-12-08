package picView.album.model;

import java.io.Serializable;
import java.sql.Date;

public class CommandAlbum implements Serializable{
	
	private String alb_name;
	private String alb_content;
	private String alb_word;
	private String alb_open;
	private String pic_no;
	private int mem_no;
	
	
	
	public CommandAlbum(){}
	public CommandAlbum(String alb_name, String alb_content, String alb_word, String alb_open, String pic_no, int mem_no) {
		super();
		this.alb_name = alb_name;
		this.alb_content = alb_content;
		this.alb_word = alb_word;
		this.alb_open = alb_open;
		this.pic_no = pic_no;
		this.mem_no = mem_no;
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
	public String getPic_no() {
		return pic_no;
	}
	public void setPic_no(String pic_no) {
		this.pic_no = pic_no;
	}
	
	


}

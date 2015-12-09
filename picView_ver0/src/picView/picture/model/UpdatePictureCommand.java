package picView.picture.model;

import java.io.Serializable;

public class UpdatePictureCommand implements Serializable {
	private String pic_no;
	private int mem_no;
	private String pic_open;
	private String pic_title;
	private String pic_content;
	private String pic_tag;
	
	public UpdatePictureCommand(){}

	public UpdatePictureCommand(String pic_no, int mem_no, String pic_open, 
			String pic_title, String pic_content, String pic_tag) {
		super();
		this.pic_no = pic_no;
		this.mem_no = mem_no;
		this.pic_open = pic_open;
		this.pic_title = pic_title;
		this.pic_content = pic_content;
		this.pic_tag = pic_tag;
	}

	public String getPic_no() {
		return pic_no;
	}

	public void setPic_no(String pic_no) {
		this.pic_no = pic_no;
	}

	public String getPic_open() {
		return pic_open;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setPic_open(String pic_open) {
		this.pic_open = pic_open;
	}

	public String getPic_title() {
		return pic_title;
	}

	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}

	public String getPic_content() {
		return pic_content;
	}

	public void setPic_content(String pic_content) {
		this.pic_content = pic_content;
	}

	public String getPic_tag() {
		return pic_tag;
	}

	public void setPic_tag(String pic_tag) {
		this.pic_tag = pic_tag;
	}	

}

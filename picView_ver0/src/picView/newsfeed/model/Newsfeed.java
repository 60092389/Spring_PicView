package picView.newsfeed.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Newsfeed implements Serializable {
	private String subject;//구분
	private int pic_no;//사진 번호
	private int mem_no;//회원번호
	private String pic_add;//사진이미지경로
	private String mem_name;//회원이름
	private String mem_pic;//회원프로필사진
	private Timestamp pic_date;//사진 업로드날짜
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getPic_add() {
		return pic_add;
	}
	public void setPic_add(String pic_add) {
		this.pic_add = pic_add;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pic() {
		return mem_pic;
	}
	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}
	public Timestamp getPic_date() {
		return pic_date;
	}
	public void setPic_date(Timestamp pic_date) {
		this.pic_date = pic_date;
	}
	@Override
	public String toString() {
		return "Newsfeed [subject=" + subject + ", pic_no=" + pic_no + ", mem_no=" + mem_no + ", pic_add=" + pic_add
				+ ", mem_name=" + mem_name + ", mem_pic=" + mem_pic + ", pic_date=" + pic_date + "]";
	}
	
	
}

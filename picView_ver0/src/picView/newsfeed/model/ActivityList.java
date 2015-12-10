package picView.newsfeed.model;

import java.io.Serializable;
import java.sql.Timestamp;


public class ActivityList implements Serializable{
	private String subject;//제목 구분
	private int pic_no;//구분 번호
	private String rep_content;//댓글 내용
	private Timestamp rep_date;//날짜
	private String mem_name;//해당 회원이름
	private int mem_no; //해당 회원번호
	private String mem_pic;//해당 회원프로필사진
	
	public String getMem_pic() {
		return mem_pic;
	}
	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}
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
	public String getRep_content() {
		return rep_content;
	}
	
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public Timestamp getRep_date() {
		return rep_date;
	}
	public void setRep_date(Timestamp rep_date) {
		this.rep_date = rep_date;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	
}

package picView.newsfeed.model;

import java.io.Serializable;

import com.sun.jmx.snmp.Timestamp;

public class ActivityList implements Serializable{
	private String subject;//제목 구분
	private int pic_no;//구분 번호
	private String rep_content;//댓글 내용
	private Timestamp rep_date;//날짜
	private String mem_name;//해당 회원이름
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

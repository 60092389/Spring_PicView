package picView.member.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Member implements Serializable{
	private int mem_no;
	private String mem_name;
	private String mem_id;
	private String mem_pwd;
	private String mem_birth;
	private String mem_sex;
	private int pic_count;
	private String mem_pic;
	private Timestamp mem_last_date;
	private Timestamp mem_date;
	
	public Member(){}
	
	public Member(int mem_no, String mem_name, String mem_id, String mem_pwd, String mem_birth, String mem_sex,
			int pic_count, String mem_pic, Timestamp mem_last_date, Timestamp mem_date) {
		super();
		this.mem_no = mem_no;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_birth = mem_birth;
		this.mem_sex = mem_sex;
		this.pic_count = pic_count;
		this.mem_pic = mem_pic;
		this.mem_last_date = mem_last_date;
		this.mem_date = mem_date;
	}
	
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_sex() {
		return mem_sex;
	}
	public void setMem_sex(String mem_sex) {
		this.mem_sex = mem_sex;
	}
	public int getPic_count() {
		return pic_count;
	}
	public void setPic_count(int pic_count) {
		this.pic_count = pic_count;
	}
	public String getMem_pic() {
		return mem_pic;
	}
	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}
	public Timestamp getMem_last_date() {
		return mem_last_date;
	}
	public void setMem_last_date(Timestamp mem_last_date) {
		this.mem_last_date = mem_last_date;
	}
	public Timestamp getMem_date() {
		return mem_date;
	}
	public void setMem_date(Timestamp mem_date) {
		this.mem_date = mem_date;
	}
	
		

}

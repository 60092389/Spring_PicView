package picView.newsfeed.model;

import java.io.Serializable;

public class FriendList implements Serializable{
	private int follow_fri_no; //회원번호(나와 친구가 된 사람의 회원번호)
	private String mem_name;//회원명
	private String mem_pic;//회원 프로필사진
	public int getFollow_fri_no() {
		return follow_fri_no;
	}
	public void setFollow_fri_no(int follow_fri_no) {
		this.follow_fri_no = follow_fri_no;
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
	
	
}

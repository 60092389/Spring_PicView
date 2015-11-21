package picView.picture.model;

import java.sql.Timestamp;


public class Picture {
	private int pic_no; //사진번호 
	private String pic_title; //사진제목
	private int mem_no; //회원번호
	private int category_no; //카테고리번호
	private String tag_name; //태그내용
	private String pic_content; //사진내용
	private int pic_count; //조회수
	private int good_count; //좋아요 개수
	private String pic_add; //이미지 경로
	private int noti_count; //신고횟수
	private String pic_info_1; //추가정보1
	private String pic_info_2; //추가정보2
	private String pic_info_3; //추가정보3
	private Timestamp pic_date; //업로드 날짜
	private String pic_open; //사진 공개범위
	public int getPic_no() {
		return pic_no;
	}
	public void setPic_no(int pic_no) {
		this.pic_no = pic_no;
	}
	public String getPic_title() {
		return pic_title;
	}
	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getPic_content() {
		return pic_content;
	}
	public void setPic_content(String pic_content) {
		this.pic_content = pic_content;
	}
	public int getPic_count() {
		return pic_count;
	}
	public void setPic_count(int pic_count) {
		this.pic_count = pic_count;
	}
	public int getGood_count() {
		return good_count;
	}
	public void setGood_count(int good_count) {
		this.good_count = good_count;
	}
	public String getPic_add() {
		return pic_add;
	}
	public void setPic_add(String pic_add) {
		this.pic_add = pic_add;
	}
	public int getNoti_count() {
		return noti_count;
	}
	public void setNoti_count(int noti_count) {
		this.noti_count = noti_count;
	}
	public String getPic_info_1() {
		return pic_info_1;
	}
	public void setPic_info_1(String pic_info_1) {
		this.pic_info_1 = pic_info_1;
	}
	public String getPic_info_2() {
		return pic_info_2;
	}
	public void setPic_info_2(String pic_info_2) {
		this.pic_info_2 = pic_info_2;
	}
	public String getPic_info_3() {
		return pic_info_3;
	}
	public void setPic_info_3(String pic_info_3) {
		this.pic_info_3 = pic_info_3;
	}
	public Timestamp getPic_date() {
		return pic_date;
	}
	public void setPic_date(Timestamp pic_date) {
		this.pic_date = pic_date;
	}
	public String getPic_open() {
		return pic_open;
	}
	public void setPic_open(String pic_open) {
		this.pic_open = pic_open;
	}
	
	
	
	
	
	
	
	
}

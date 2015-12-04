package picView.picture.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Picture implements Serializable {

	private int pic_no; //사진번호
	private String pic_title; //사진제목
	private int mem_no; //회원번호
	private int category_no; //카테고리번호
	private String tag_name; //태그명
	private String pic_content; //사진내용
	private int pic_count; //사진조회수
	private int good_count; //좋아요개수
	private String pic_add; //사진이미지경로
	private String pic_color; //사진색상
	private String pic_location; //사진위치주소
	private Timestamp pic_date; //사진업로드날짜
	private String pic_open; //사진공개범위
	
	public Picture(){}

	public Picture(int pic_no, String pic_title, int mem_no, int category_no, String tag_name, String pic_content,
			int pic_count, int good_count, String pic_add, String pic_color, String pic_location, Timestamp pic_date,
			String pic_open) {
		super();
		this.pic_no = pic_no;
		this.pic_title = pic_title;
		this.mem_no = mem_no;
		this.category_no = category_no;
		this.tag_name = tag_name;
		this.pic_content = pic_content;
		this.pic_count = pic_count;
		this.good_count = good_count;
		this.pic_add = pic_add;
		this.pic_color = pic_color;
		this.pic_location = pic_location;
		this.pic_date = pic_date;
		this.pic_open = pic_open;
	}

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

	public String getPic_color() {
		return pic_color;
	}

	public void setPic_color(String pic_color) {
		this.pic_color = pic_color;
	}

	public String getPic_location() {
		return pic_location;
	}

	public void setPic_location(String pic_location) {
		this.pic_location = pic_location;
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

	@Override
	public String toString() {
		return "Picture [pic_no=" + pic_no + ", pic_title=" + pic_title + ", mem_no=" + mem_no + ", category_no="
				+ category_no + ", tag_name=" + tag_name + ", pic_content=" + pic_content + ", pic_count=" + pic_count
				+ ", good_count=" + good_count + ", pic_add=" + pic_add + ", pic_color=" + pic_color + ", pic_location="
				+ pic_location + ", pic_date=" + pic_date + ", pic_open=" + pic_open + "]";
	}
	
	
	
	
}

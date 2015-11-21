package picView.cate.model;

import java.io.Serializable;

public class Category implements Serializable{
	private int category_no;
	private String category_name;
	private String category_img_add;
	
	public Category(){}
	
	public Category(int category_no, String category_name, String category_img_add) {
		super();
		this.category_no = category_no;
		this.category_name = category_name;
		this.category_img_add = category_img_add;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_img_add() {
		return category_img_add;
	}

	public void setCategory_img_add(String category_img_add) {
		this.category_img_add = category_img_add;
	}
	
	
	
	
}

package picView.cate.model;

import java.io.Serializable;

public class GroupCategory implements Serializable {
	private int group_cate_no;
	private int mem_no;
	private int category_no;
	
	public GroupCategory(){}
	
	public GroupCategory(int group_cate_no, int mem_no, int category_no) {
		super();
		this.group_cate_no = group_cate_no;
		this.mem_no = mem_no;
		this.category_no = category_no;
	}

	public int getGroup_cate_no() {
		return group_cate_no;
	}

	public void setGroup_cate_no(int group_cate_no) {
		this.group_cate_no = group_cate_no;
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
	
}

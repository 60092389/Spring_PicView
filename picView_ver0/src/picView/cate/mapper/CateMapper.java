package picView.cate.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import picView.cate.model.Category;
import picView.cate.model.GroupCategory;

public interface CateMapper {
	public List<Category> categoryList();
	public void insertGroupCate(GroupCategory gc);
	public List<GroupCategory> member_cate(int mem_no);
	public String selectCate(int category_no);
	
}

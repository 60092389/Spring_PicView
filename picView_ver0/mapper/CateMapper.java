package picView.cate.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import picView.cate.model.Category;
import picView.cate.model.GroupCategory;
import picView.picture.model.Picture;

public interface CateMapper {
	public List<Category> categoryList();
	public void insertGroupCate(GroupCategory gc);
	public List<Picture> picList();
	public List<Picture> catepiclist(int category_no);
	public Picture selectpic(int category_no);
	public List<GroupCategory> member_cate(int mem_no);
	public String selectCate(int category_no);
}

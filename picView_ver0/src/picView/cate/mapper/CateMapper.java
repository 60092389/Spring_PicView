package picView.cate.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import picView.cate.model.Category;
import picView.cate.model.Search;

public interface CateMapper {
	public int insertCategory(Category category);
	public List<Category> ListCategory(RowBounds row, Search search);
	public List<Category> ListCategory2();
	public int countCate(Search search);
}

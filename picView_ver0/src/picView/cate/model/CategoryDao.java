package picView.cate.model;


import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.cate.mapper.CateMapper;

@Component
public class CategoryDao {
	@Autowired
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	public List<Category> categoryList(){
		
		return myTemplate.getMapper(CateMapper.class).categoryList();
	}
	
	public void insertGroupCate(GroupCategory gc){
		
		myTemplate.getMapper(CateMapper.class).insertGroupCate(gc);
	}
	
}

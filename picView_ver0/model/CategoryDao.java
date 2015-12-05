package picView.cate.model;


import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.cate.mapper.CateMapper;
import picView.picture.model.Picture;

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
	
	public List<Picture> picList(){
		return myTemplate.getMapper(CateMapper.class).picList();
	}
	
	public List<Picture> catepiclist(int category_no){
		return myTemplate.getMapper(CateMapper.class).catepiclist(category_no);
	}
	
	public Picture selectpic(int category_no){
		return myTemplate.getMapper(CateMapper.class).selectpic(category_no);
	}
	
	//해당회원이 갖고있는 카테고리
		public List<GroupCategory> member_cate(int mem_no){
			return myTemplate.getMapper(CateMapper.class).member_cate(mem_no);
		}
		
		//해당카테고리 번호에따른 카테고리이름
		public String selectCate(int category_no){
			return myTemplate.getMapper(CateMapper.class).selectCate(category_no);
		}	
	
}

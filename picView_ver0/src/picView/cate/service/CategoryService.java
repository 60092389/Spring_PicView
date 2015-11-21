package picView.cate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.cate.model.GroupCategory;

@Service
public class CategoryService {
	private CategoryDao cateDao;

	@Autowired
	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}
	
	public List<Category> categoryList(){
		System.out.println("cateService 오케이");		
		return cateDao.categoryList();
	}
	

	

}

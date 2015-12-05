package picView.cate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.cate.model.GroupCategory;
import picView.picture.model.Picture;

@Service
public class CategoryService {
	private CategoryDao cateDao;

	@Autowired
	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}

	public List<Category> categoryList() {
		System.out.println("cateService 오케이");
		return cateDao.categoryList();
	}

	public List<Picture> picList() {
		System.out.println("Piclist 오케이");
		return cateDao.picList();
	}

	public List<Picture> catepiclist(int[] category_nos) {

		List<Picture> cate = new ArrayList<>();

		if (category_nos == null) {
			System.out.println("선택한 카테고리가 없습니다.");
			return cateDao.picList();
		}

		System.out.println("length" + category_nos.length);
		for(int cnt = 0; cnt < category_nos.length; cnt++){
		List<Picture> pic = cateDao.catepiclist(category_nos[cnt]);
		System.out.println("이녀석이 2개여야해 :"+pic.size());
		for(int i =0; i<pic.size();i++){
			Picture pic2 = new Picture();
			pic2.setPic_add(pic.get(i).getPic_add());
			cate.add(pic2);
			System.out.println("이게나와야되"+cate.get(i).getPic_add());
		}
		}
		return cate;
	}

}

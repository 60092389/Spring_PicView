package picView.cate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import picView.cate.model.Category;
import picView.cate.service.CategoryService;
import picView.picture.model.Picture;

@Controller
public class CateController {
	
	@Autowired
	CategoryService cateservice;
	@Autowired
	public void setCateservice(CategoryService cateservice) {
		this.cateservice = cateservice;
	}
	
	@RequestMapping("/jsp/category/category_list")
	public String cate_list(Model model){
		System.out.println("a");
		List<Category> list = cateservice.categoryList();
		List<Picture> piclist = cateservice.picList();
		model.addAttribute("piclist", piclist);
		model.addAttribute("cateList" , list); 
		
		return "category/category";
	}
	
	@RequestMapping("/jsp/category/category_search")
	public String cate_search(Model model, @RequestParam int category_no[]){
		int category_nos[] = category_no;
		List<Picture> piclist = cateservice.catepiclist(category_nos);
		System.out.println(piclist);
		List<Category> list = cateservice.categoryList();
		model.addAttribute("piclist", piclist);
		model.addAttribute("cateList" , list); 
		
		return "category/category";
	}
	

}

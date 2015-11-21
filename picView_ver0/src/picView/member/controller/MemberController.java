package picView.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import picView.cate.model.Category;
import picView.cate.service.CategoryService;
import picView.member.model.MemberCommand;
import picView.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private CategoryService categoryService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping("/jsp/**/insertForm")
	public String insertForm(Model model){
		System.out.println("insertForm 오케이");
		
		List<Category> list = categoryService.categoryList();		
		
		model.addAttribute("cateList", list);
		
		System.out.println(list);
		
		return "login/register";
	}

	@RequestMapping("/jsp/login/insertMember")
	public String insertMember(MemberCommand mc) {

		System.out.println("controller 오케이");

		try {
			memberService.insertMember(mc);

			return "index/index";

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "login/register";
	}

}
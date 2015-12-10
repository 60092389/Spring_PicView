package picView.member.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import picView.cate.model.Category;
import picView.cate.service.CategoryService;
import picView.member.model.AuthInfo;
import picView.member.model.MailSend;
import picView.member.model.Member;
import picView.member.model.MemberCommand;
import picView.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MailSend mail;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Autowired
	public void setMail(MailSend mail) {
		this.mail = mail;
	}
	

	@RequestMapping(value="/jsp/**/insertForm", method=RequestMethod.GET)
	public String registForm(Model model){
		model.addAttribute("memberCommand", new MemberCommand());
		
		List<Category> list = categoryService.categoryList();		
		
		model.addAttribute("cateList", list);
		
		System.out.println(list);	
		
		return "/login/register";
	}

	@RequestMapping(value="/jsp/**/insertForm", method=RequestMethod.POST)
	public String insertForm(Model model,@ModelAttribute("memberCommand")
	@Valid MemberCommand memberCommand, BindingResult errors) throws IOException{
		System.out.println("여기 post 컨트롤러");
		if(errors.hasErrors()){
			List<Category> list = categoryService.categoryList();		
			
			model.addAttribute("cateList", list);
			
			System.out.println(list);
			
			return  "/login/register";
		}
		
		System.out.println("controller 오케이");
		System.out.println(memberCommand.getCategory_no());
		try {
			memberService.insertMember(memberCommand);
			
			memberService.sendMailSerivce(memberCommand);			
			
			return "redirect:/jsp/index/index.jsp";

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "login/register";
		
	}
	
	@RequestMapping("/jsp/login/loginForm")
	public String loginMember(@RequestParam(value="id")String mem_id,
				@RequestParam(value="pass")String mem_pwd, HttpSession session, Model model){
		int login_check = -1;
		String url = "";
		
		System.out.println("loginMember컨트롤러 id : "+mem_id);
		System.out.println("loginMember컨트롤러 mem_pwd : "+mem_pwd);
		
		AuthInfo authInfo = memberService.loginMember(mem_id, mem_pwd);
		
		if(authInfo.getMem_id() != null){
			login_check = 1;
			System.out.println("로그인 성공하면1, 실패하면 -1 : "+login_check);
			session.setAttribute("authInfo", authInfo);
			url = "redirect:/jsp/main/loginMain.jsp";
		}else if(authInfo.getMem_id().equals(null)){
			login_check = -1;
			System.out.println("로그인 성공하면1, 실패하면 -1 : "+login_check);
			model.addAttribute("login_check", login_check);
			url = "login/loginForm";
		}		
		
		return url;
	}
	
	@RequestMapping("/jsp/login/logout")
	public String logoutMember(HttpSession session){
		session.invalidate();
		
		return "redirect:/jsp/index/index.jsp";
	}
	

	
	
}
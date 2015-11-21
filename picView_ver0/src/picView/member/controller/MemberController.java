package picView.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import picView.member.model.MemberCommand;
import picView.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/jsp/login/insertMember")
	public String insertMember(MemberCommand mc){
		
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
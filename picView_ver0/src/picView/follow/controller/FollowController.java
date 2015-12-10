package picView.follow.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import picView.follow.model.Follow;
import picView.follow.model.FollowCommand;
import picView.follow.model.FollowRecommand;
import picView.follow.model.Search;
import picView.follow.service.FollowService;
import picView.member.model.AuthInfo;
import picView.member.model.Member;
import picView.member.service.MemberService;
import picView.picture.service.PictureService;

@Controller
public class FollowController {
	
	private FollowService followService;
	private MemberService memberService;
	private PictureService pictureService;

	@Autowired
	public void setFollowService(FollowService followService) {
		this.followService = followService;
	}
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Autowired	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@RequestMapping("/jsp/myRoom/listFri")
	public String listSearchFri(Model model, HttpSession session){
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		String level = "1";

		List<FollowRecommand> fr = followService.followRecommand(mem_no);
		Member member = memberService.selectByNo(mem_no);
		
		for(int i=0; i<fr.size(); i++){
			System.out.println("추천회원 이름 : "+fr.get(i).getMem_name());
			System.out.println("추천회원 카테고리 : "+fr.get(i).getCategory_name());
		}
		
		model.addAttribute("recommandMember", fr);
		model.addAttribute("member", member);
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("level", level);
		
		return "myRoom/my_FollowSearch";
	}
	
	@RequestMapping("/jsp/myRoom/my_Follow{fri_mem_no}")
	public String listFollow(@PathVariable String fri_mem_no, Model model, HttpSession session){
		
		int fri_no = Integer.parseInt(fri_mem_no);
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		String level = "-1";
		
		if(fri_no == mem_no){
			level = "1";
		}
		Member member = memberService.selectByNo(fri_no);
		List<Member> members = memberService.listSearchFri();
		List<Follow> follows = followService.listFollow(fri_no);
			
		
		for(int i=0; i<members.size(); i++){
			System.out.println("친구목록 : "+members.get(i).getMem_name());
		}
		
		for(int i=0; i<follows.size(); i++){
			System.out.println("팔로우목록 : "+follows.get(i));
		}
		
		String fol_check_list = pictureService.fol_check(mem_no, fri_no);
		
		
		model.addAttribute("fol_check", fol_check_list);
		
		model.addAttribute("member", member);
		model.addAttribute("members", members);
		model.addAttribute("follows", follows);
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("level", level);
		
		return "myRoom/my_Follow";
	}
	
	@RequestMapping("/jsp/myRoom/my_Follower")
	public String listFollower(Model model, HttpSession session){
				
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		String level = "1";
		
		Member member = memberService.selectByNo(mem_no);
		List<Member> members = memberService.listSearchFri();
		List<Follow> follows = followService.listFollow(mem_no);
			
		
		for(int i=0; i<members.size(); i++){
			System.out.println("친구목록 : "+members.get(i).getMem_name());
		}
		
		for(int i=0; i<follows.size(); i++){
			System.out.println("팔로우목록 : "+follows.get(i));
		}
		
		model.addAttribute("members", members);
		model.addAttribute("follows", follows);
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("member", member);
		model.addAttribute("level", level);
		
		return "myRoom/my_Follower";
	}
	
	
	//상대방과 아무관계 없을때 팔로우하기
	@RequestMapping("jsp/**/addNewFollow")
	public String addNewFollow(FollowCommand fc,HttpSession session){
		System.out.println(fc.getMem_nos());
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		followService.addNewFollow(fc);
		
		return "redirect:/jsp/myRoom/my_Follow"+mem_no;
	}
	
	//상대방이 자신을 팔로우하고있을때 나도팔로우하기
	@RequestMapping("jsp/**/addFollow")
	public String addFollow(FollowCommand fc, HttpSession session){
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		followService.addFollow(fc);
		
		return "redirect:/jsp/myRoom/my_Follow"+mem_no;
	}
	
	//나만 상대방 팔로우 상태일때 팔로우취소하기
	@RequestMapping("jsp/**/cancelFollow")
	public String cancelFollow(FollowCommand fc, HttpSession session){
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		System.out.println("cancelFollow 컨트롤러");
		
		followService.cancelFollow(fc);		
		
		return "redirect:/jsp/myRoom/my_Follow"+mem_no;
	}
	
	//맞팔상태일때 나만 팔로우 취소하기
	@RequestMapping("jsp/**/cancelEachFollow")
	public String cancelEachFollow(FollowCommand fc, HttpSession session){
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		followService.cancelEachFollow(fc);
		
		return "redirect:/jsp/myRoom/my_Follow"+mem_no;
	}
	
	//@RequestMapping("jsp/**/followRecommand")
	/*public String followRecommand(Model model, HttpSession session){
			
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			int mem_no = authInfo.getMem_no();
			
			String level = "1";
		
			Member member = memberService.selectByNo(mem_no);
		
			List<FollowRecommand> fr = followService.followRecommand(mem_no);
			
			
			for(int i=0; i<fr.size(); i++){
				System.out.println("추천회원 이름 : "+fr.get(i).getMem_name());
				System.out.println("추천회원 카테고리 : "+fr.get(i).getCategory_name());
			}
			
			model.addAttribute("recommandMember", fr);
			model.addAttribute("member", member);
			model.addAttribute("level", level);
			
		return "my_FollowSearch";
	}*/
	
}

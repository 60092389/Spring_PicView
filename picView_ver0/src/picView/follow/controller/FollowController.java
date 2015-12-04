package picView.follow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import picView.follow.model.Follow;
import picView.follow.model.FollowCommand;
import picView.follow.model.FollowRecommand;
import picView.follow.model.Search;
import picView.follow.service.FollowService;
import picView.member.model.Member;
import picView.member.service.MemberService;

@Controller
public class FollowController {

	int mem_no = 5;
	
	private FollowService followService;
	private MemberService memberService;

	@Autowired
	public void setFollowService(FollowService followService) {
		this.followService = followService;
	}
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/jsp/myRoom/listFri")
	public String listSearchFri(Model model){
		
		
		
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

		/////////////////////////////////////////////////////////////////
		
		List<FollowRecommand> fr = followService.followRecommand(mem_no);
		
		
		for(int i=0; i<fr.size(); i++){
			System.out.println("추천회원 이름 : "+fr.get(i).getMem_name());
			System.out.println("추천회원 카테고리 : "+fr.get(i).getCategory_name());
		}
		
		model.addAttribute("recommandMember", fr);
		
		return "myRoom/my_FollowSearch";
	}
	
	@RequestMapping("/jsp/myRoom/my_Follow")
	public String listFollow(Model model){
				
		
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
		
		return "myRoom/my_Follow";
	}
	
	@RequestMapping("/jsp/myRoom/my_Follower")
	public String listFollower(Model model){
				
		
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
		
		return "myRoom/my_Follower";
	}
	
	
	//상대방과 아무관계 없을때 팔로우하기
	@RequestMapping("jsp/**/addNewFollow")
	public String addNewFollow(FollowCommand fc){
		System.out.println(fc.getMem_nos());
		
		
		followService.addNewFollow(fc);
		
		return "redirect:/jsp/myRoom/my_Follow";
	}
	
	//상대방이 자신을 팔로우하고있을때 나도팔로우하기
	@RequestMapping("jsp/**/addFollow")
	public String addFollow(FollowCommand fc){
		followService.addFollow(fc);
		
		return "redirect:/jsp/myRoom/my_Follow";
	}
	
	//나만 상대방 팔로우 상태일때 팔로우취소하기
	@RequestMapping("jsp/**/cancelFollow")
	public String cancelFollow(FollowCommand fc){
		
		System.out.println("cancelFollow 컨트롤러");
		
		followService.cancelFollow(fc);		
		
		return "redirect:/jsp/myRoom/my_Follow";
	}
	
	//맞팔상태일때 나만 팔로우 취소하기
	@RequestMapping("jsp/**/cancelEachFollow")
	public String cancelEachFollow(FollowCommand fc){
		followService.cancelEachFollow(fc);
		
		return "redirect:/jsp/myRoom/my_Follow";
	}
	
	//@RequestMapping("jsp/**/followRecommand")
	/*public String followRecommand(Model model){
			int mem_no = 4;
			List<FollowRecommand> fr = followService.followRecommand(mem_no);
			
			
			for(int i=0; i<fr.size(); i++){
				System.out.println("추천회원 이름 : "+fr.get(i).getMem_name());
				System.out.println("추천회원 카테고리 : "+fr.get(i).getCategory_name());
			}
			
			model.addAttribute("recommandMember", fr);
			
		return "my_FollowSearch";
	}*/
	
}

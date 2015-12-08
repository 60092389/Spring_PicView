package picView.album.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import picView.album.model.Album;
import picView.album.model.AlbumResult;
import picView.album.model.CommandAlbum;
import picView.album.service.AlbumService;
import picView.member.model.AuthInfo;
import picView.member.model.Member;
import picView.member.service.MemberService;
import picView.picture.model.Picture;

@Controller
public class Alb_Controller {

	AlbumService service;
	MemberService memberService;

	@Autowired
	public void setService(AlbumService service) {
		this.service = service;
	}
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	

	@RequestMapping("/jsp/myRoom/my_album{fri_mem_no}")
	public String my_alb(@PathVariable String fri_mem_no, Model model, HttpSession session) {
		
		int fri_no = Integer.parseInt(fri_mem_no);
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		
		String level = "";
		
		Member member = memberService.selectByNo(fri_no);
		
		model.addAttribute("mem_no", mem_no);
		// 여기서 앨범 리스트가 출력되야함
		AlbumResult albumResult = service.albumlist(mem_no, fri_no);
		
		List<Album> albumlist = albumResult.getAlbumlist();
		level = albumResult.getRelation()+"";
		List<String> albumpiclist = service.albumpiclist(mem_no, fri_no);
		model.addAttribute("albumpiclist", albumpiclist);
		model.addAttribute("albumlist", albumlist);
		model.addAttribute("level", level);
		model.addAttribute("member", member);
		
		System.out.println("서비스 후 모델에 담기 컨트롤러");

		return "myRoom/my_album";
	}

	@RequestMapping("/jsp/myRoom/album_add")
	public String alb_add(Model model, @RequestParam int mem_no, @RequestParam String getalb_word) {
		
		System.out.println("앨범추가하기의 mem_no ="+mem_no);
		
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("getalb_word", getalb_word);
		
		// 사진리스트 출력
		List<Picture> listpic = service.listpic(mem_no);
		model.addAttribute("listpic", listpic);
		return "myRoom/my_album_add";
	}
	

	

	@RequestMapping("/jsp/myRoom/album_add_re")
	public String alb_add_re(CommandAlbum ca, Model model, HttpSession session) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		
		try {
			System.out.println("ca alb_word : " + ca.getAlb_word());
			
			AlbumResult albumResult = service.albumlist(ca.getMem_no(), mem_no);
			
			List<Album> album = albumResult.getAlbumlist();
			if(ca.getAlb_word() == null){
				ca.setAlb_word("-");
			}
		
			for (int i = 0; i < album.size(); i++) {
				System.out.println("album_word : " + album.get(i).getAlb_word());
				if (ca.getAlb_word().equals(album.get(i).getAlb_word())) {
					System.out.println("pic_no 어케오니 :"+ca.getPic_no());
					model.addAttribute("getalb_word", ca.getAlb_word());
					model.addAttribute("mem_no", ca.getMem_no());	
					service.updateget(ca);
					System.out.println("ca 가안되? "+ca.getAlb_word());
					return "redirect:album_add"+mem_no;
				} 
			}
			service.insertAlbum(ca);
			return "redirect:my_album"+mem_no;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "redirect:/jsp/myRoom/my_album"+mem_no;
	

	}

	@RequestMapping("/jsp/myRoom/my_album_detail")
	public String alb_detail(@RequestParam int fri_no, @RequestParam int alb_no, Model model,
				HttpSession session) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		
		int level = -1;
		if(mem_no == fri_no){
			level = 1;
		}
		
		model.addAttribute("mem_no", fri_no);
		model.addAttribute("alb_no", alb_no);
		List<String> detailAlbumPic = service.detailAlbumPic(alb_no);
		List<String> detailAlbumPicname = service.detailAlbumPicname(alb_no);
		List<Integer> detailAlbumPicno = service.detailAlbumPicno(alb_no);
		Album detailAlbum = service.detailAlbum(alb_no);
		model.addAttribute("detailAlbum", detailAlbum);
		model.addAttribute("detailAlbumPic", detailAlbumPic);
		model.addAttribute("detailAlbumPicname", detailAlbumPicname);
		model.addAttribute("detailAlbumPicno", detailAlbumPicno);
		model.addAttribute("level", level);
		// 여기서는 앨범에 담겨져있는 사진내용을 가져와야함
		return "myRoom/my_album_detail";
	}

	@RequestMapping("/jsp/myRoom/my_album_delete")
	public String alb_delete(@RequestParam int alb_no, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		
		try {
			service.deleteAlbum(alb_no);
			System.out.println("실행되나 안되나.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/jsp/myRoom/my_album"+mem_no;
	}
	
	
	@RequestMapping("/jsp/myRoom/my_album_update")
	public String my_album_update(Model model,@RequestParam int alb_no, @RequestParam int mem_no){
		System.out.println("update 여기까진와야지");
		List<Picture> listpic = service.listpic(mem_no);
		model.addAttribute("listpic", listpic);
		List<Picture> detailAlbumPic_add = service.grouplist(alb_no);
		Album album = service.detailAlbum(alb_no);
		//List<String> detailAlbumPic_add = service.detailAlbumPic(alb_no);	
		model.addAttribute("detailAlbumPic_add", detailAlbumPic_add);
		model.addAttribute("album", album);
		model.addAttribute("mem_no", mem_no);
	
		
		return "myRoom/my_album_add_update";
	}
	
	@RequestMapping("/jsp/myRoom/album_add_updae_re")
	public String album_add_updae_re(Model model, CommandAlbum ca, @RequestParam int alb_no,
				HttpSession session){
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		
		
		try {
			System.out.println("삭제되나?");
			service.deleteAlbum(alb_no);
			System.out.println("삭제되네");
			System.out.println("ca alb_word : " + ca.getAlb_word());

			AlbumResult albumResult = service.albumlist(ca.getMem_no(), mem_no);
			
			List<Album> album = albumResult.getAlbumlist();
			System.out.println("albumlist 되네");
			for(int i=0; i<album.size(); i++){
				System.out.println("album_list 앨범 이름 : "+album.get(i).getAlb_name());
			}
			
			for (int i = 0; i < album.size(); i++) {
				System.out.println("album_word : " + album.get(i).getAlb_word());
				if (ca.getAlb_word().equals(album.get(i).getAlb_word())) {
					System.out.println("pic_no 어케오니 :"+ca.getPic_no());
					model.addAttribute("getalb_word", ca.getAlb_word());
					model.addAttribute("mem_no", ca.getMem_no());	
					service.updateget(ca);
					System.out.println("ca 가안되? "+ca.getAlb_word());
					return "redirect:album_add"+mem_no;
				} 
			}
			service.insertAlbum(ca);
			System.out.println("수정확인해보장");
			return "redirect:my_album"+mem_no;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "redirect:/jsp/myRoom/my_album"+mem_no;
	}
	
	@RequestMapping("/jsp/myRoom/my_album_level")
	public String my_album_level(Album levelcommand, HttpSession session){
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		
		System.out.println("???몽미");
		System.out.println("mem_no :" +levelcommand.getMem_no() );
		System.out.println("alb_no : "+ levelcommand.getAlb_no());
		System.out.println("levelopen :"+levelcommand.getAlb_open());
		//service.albumlevel(levelcommand);
		service.albumlevel(levelcommand);
		
		return "redirect:/jsp/myRoom/my_album"+mem_no;
	}
	
	@RequestMapping("/jsp/myRoom/pic_search")
	public String pic_search(Model model,@RequestParam String pic_search, @RequestParam int mem_no, @RequestParam String getalb_word){
		System.out.println("검색");
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("getalb_word", getalb_word);
		List<Picture> listpic = service.pic_search(pic_search);
		model.addAttribute("listpic", listpic);
		return "myRoom/my_album_add";
	}
	
	
}

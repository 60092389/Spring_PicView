package picView.picture.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import picView.member.model.AuthInfo;
import picView.member.model.Member;
import picView.member.service.MemberService;
import picView.picture.model.AlbumInfo;
import picView.picture.model.Picture;
import picView.picture.model.PictureShow;
import picView.picture.model.ReplyCount;
import picView.picture.model.UpdatePictureCommand;
import picView.picture.service.PictureService;

@Controller
public class PictureController {
	// int mem_no = 4;

	private PictureService picService;
	private MemberService memService;

	@Autowired
	public void setPicService(PictureService picService) {
		this.picService = picService;
	}

	@Autowired
	public void setMemService(MemberService memService) {
		this.memService = memService;
	}

	// my_Room->my_Manage.jsp에서 사용하는 사진목록볼러오기
	@RequestMapping("/jsp/**/manageForm")
	public String my_ManageForm(Model model, HttpSession session) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();

		List<Picture> picList = picService.listPicture(mem_no);
		List<Picture> picDate = picService.dateListPicture(mem_no);
		List<String> years = picService.yearListPicture(mem_no);
		List<String> months = picService.monthListPicture(mem_no);
		Member member = memService.selectByNo(mem_no);
		String level = "1";

		model.addAttribute("date", picDate);
		model.addAttribute("list", picList);
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("years", years);
		model.addAttribute("months", months);
		model.addAttribute("member", member);
		model.addAttribute("level", level);

		return "myRoom/my_Manage";
	}

	// 사진권한변경
	@RequestMapping("jsp/**/updatePictureOpen")
	public String updatePictureOpen(UpdatePictureCommand upc) {
		picService.updatePictureOpen(upc);

		return "redirect:/jsp/myRoom/manageForm";
	}

	// 사진정보변경
	@RequestMapping("jsp/**/updatePictureInfo")
	public String updatePictureInfo(UpdatePictureCommand upc) {

		picService.updatePictureInfo(upc);

		return "redirect:/jsp/myRoom/manageForm";
	}

	// 사진삭제
	@RequestMapping("jsp/**/deletePicture")
	public String deletePicture(@RequestParam(value = "pic_no") String pic_no,
			@RequestParam(value = "mem_no") int mem_no) {
		picService.deletePicture(pic_no, mem_no);

		return "redirect:/jsp/myRoom/manageForm";
	}

	// 채영
	@RequestMapping(value = "/jsp/**/myShowForm{fri_mem_no}")
	public String my_ShowForm(@PathVariable String fri_mem_no, Model model,
			@RequestParam(value = "pic_open", required = false) String pic_open,
			@RequestParam(value = "search", required = false) String search, HttpSession session) {
		// test

		int fri_no = Integer.parseInt(fri_mem_no);

		// System.out.println("마이쇼의 친구페이지 mem_no : "+fri_no);

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();

		System.out.println("접속한사람 : " + mem_no);
		System.out.println("누구의 페이지? : " + fri_no);

		Picture picture = new Picture();
		picture.setPic_open(pic_open);
		// picture.setMem_no(mem_no);
		picture.setMem_no(fri_no);
		picture.setSearch(search);
		System.out.println("여기 myShow 컨트롤러");
		System.out.println("넘어온 search 값 " + search);

		PictureShow pic_show = picService.myShowPicture(picture, mem_no);

		/*
		 * relation = 1 -> 자기자신 relation = 2 -> 내가팔로우하는사람 페이지 들어갔을때 relation = 3
		 * -> 날 팔로우하는 사람 페이지 들어갔을때 relation = 4 -> 서로 친구인 사람 페이지 들어갔을때 relation
		 * = 5 -> 아무관계 없는 사람 페이지 들어갔을때
		 */
		String relation = pic_show.getRelation() + "";

		Member member = memService.selectByNo(fri_no);

		List<Picture> myShowList = pic_show.getPic_list();

		System.out.println("컨트롤러 myShowList의 사이즈 : " + myShowList.size());

		List<ReplyCount> rep_count = picService.myShowReply_count(myShowList);
		for (int i = 0; i < rep_count.size(); i++) {
			System.out.println("컨트롤러의 rep_count의 댓글개수 : " + rep_count.get(i).getRep_count());
		}

		model.addAttribute("member", member);
		model.addAttribute("myShowList", myShowList);
		model.addAttribute("level", relation);
		model.addAttribute("rep_count", rep_count);

		return "myRoom/my_Show";
	}

	@RequestMapping(value = "/jsp/**/myShowSlide{fri_mem_no}")
	public String my_ShowSlide(Model model, @RequestParam(value = "pic_open", required = false) String pic_open,
			HttpSession session, @PathVariable String fri_mem_no) {

		int fri_no = Integer.parseInt(fri_mem_no);

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();

		// test
		System.out.println("여기 slide 컨트롤러");
		Picture picture = new Picture();
		picture.setPic_open(pic_open);
		picture.setMem_no(fri_no);

		PictureShow pic_show = picService.myShowPicture(picture, mem_no);

		List<Picture> myShowList = pic_show.getPic_list();

		int pic_count = myShowList.size();

		model.addAttribute("myShowList", myShowList);
		model.addAttribute("pic_count", pic_count);

		return "myRoom/myShowSlide";
	}

	// basic->picDetail.jsp에서 사용하는 사진 상세보기 불러오기
	@RequestMapping("/jsp/**/picDetail") /// pic_no={pic_no}
	public String picDetail(Model model, @RequestParam(value = "pic_no", required = false) int pic_no) { // @PathVariable
																											// int
																											// pic_no
		// @RequestParam(value="select_pic", required=false) int select_pic

		// int mem_no = 2;
		// int pic_no = 1;

		// 상세보기 - 사진 정보
		Picture picDetail = picService.detailPicture(pic_no);

		// 상세보기 - 태그들
		String tag_list = picService.tag_list(pic_no);

		// 상세보기 - 회원정보(이름, 프로필 사진)
		Member memInfo = picService.memInfo(pic_no);

		// 상세보기 - 댓글 갯수
		int rep_count = picService.rep_count(pic_no);

		// 상세보기 - 사진 리스트
		List<Picture> pic_list = picService.pic_list(pic_no);

		// 상세보기 - 선택한 사진번호
		// String move_pic = Integer.toString(pic_no);
		// System.out.println(move_pic);

		// 상세보기 - 메인 사진
		String main_pic = picService.main_pic(pic_no);

		// 상세보기 - 좋아요
		int findGood = picService.findGood(pic_no);

		// 상세보기 - 카테고리
		String category_name = picService.findCategory(pic_no);

		/*
		 * // 상세보기 - 앨범 찾기 List<String> album_pic_add =
		 * picService.findAlbum_pic_add(pic_no);
		 * System.out.println(album_pic_add.toString());
		 */

		// 상세보기 - 앨범 개수
		int alb_count = picService.findAlbum_count(pic_no);
		System.out.println("컨트롤러 앨범개수" + alb_count);

		////

		AlbumInfo albumInfo = new AlbumInfo();
		albumInfo.setPic_add(picService.findAlbum_pic_add(pic_no));
		albumInfo.setAlb_name(picService.findAlbum_name(pic_no));
		albumInfo.setAlb_pic_count(picService.findAlbum_pic_count(pic_no));

		List<AlbumInfo> list = new ArrayList<AlbumInfo>();
		list.add(albumInfo);
		System.out.println(list);
		///

		model.addAttribute("detail", picDetail);
		model.addAttribute("tag_list", tag_list);
		model.addAttribute("memInfo", memInfo);
		model.addAttribute("rep_count", rep_count);
		model.addAttribute("pic_list", pic_list);
		model.addAttribute("main_pic", main_pic);
		model.addAttribute("pic_no", pic_no);
		model.addAttribute("findGood", findGood);
		model.addAttribute("category_name", category_name);
		model.addAttribute("alb_count", alb_count);

		return "basic/picDetail";
	}

	// 상세보기 - 앨범 ajax
	@RequestMapping("/jsp/**/findAlbum") /// pic_no={pic_no}
	public @ResponseBody List<AlbumInfo> picDetail_Album(@RequestParam(value = "pic_no", required = false) int pic_no) {

		AlbumInfo albumInfo = new AlbumInfo();
		albumInfo.setPic_add(picService.findAlbum_pic_add(pic_no));
		albumInfo.setAlb_name(picService.findAlbum_name(pic_no));
		albumInfo.setAlb_pic_count(picService.findAlbum_pic_count(pic_no));

		List<AlbumInfo> list = new ArrayList<AlbumInfo>();
		list.add(albumInfo);
		System.out.println(list);

		return list;
	}
}

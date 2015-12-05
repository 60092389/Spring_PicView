package picView.picture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import picView.member.model.Member;
import picView.picture.model.Picture;
import picView.picture.model.UpdatePictureCommand;
import picView.picture.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService picService;

	@Autowired
	public void setPicService(PictureService picService) {
		this.picService = picService;
	}

	// my_Room->my_Manage.jsp에서 사용하는 사진목록볼러오기
	@RequestMapping("/jsp/**/manageForm")
	public String my_ManageForm(Model model) {
		int mem_no = 1;
		List<Picture> picDate = picService.dateListPicture(mem_no);
		List<Picture> picList = picService.listPicture(mem_no);
		List<String> years = picService.yearListPicture(mem_no);
		List<String> months = picService.monthListPicture(mem_no);

		/*
		 * for(int i=0; i<years.size(); i++){ System.out.println("year 리스트 : "
		 * +years.get(i)); }
		 */

		model.addAttribute("date", picDate);
		model.addAttribute("list", picList);
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("years", years);
		model.addAttribute("months", months);

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
	@RequestMapping(value = "/jsp/**/myShowForm")
	public String my_ShowForm(Model model, @RequestParam(value = "pic_open", required = false) String pic_open,
			@RequestParam(value = "search", required = false) String search) {
		// test

		// search 값 안되면 나중에 Hashmap 으로 보내기
		int mem_no = 1;
		Picture picture = new Picture();
		picture.setPic_open(pic_open);
		picture.setMem_no(mem_no);
		picture.setSearch(search);
		System.out.println("여기 myShow 컨트롤러");
		System.out.println("넘어온 search 값 " + search);

		List<Picture> myShowList = picService.myShowPicture(picture);

		model.addAttribute("myShowList", myShowList);

		return "myRoom/my_Show";
	}

	@RequestMapping(value = "/jsp/**/myShowSlide")
	public String my_ShowSlide(Model model, @RequestParam(value = "pic_open", required = false) String pic_open) {
		// test
		System.out.println("여기 slide 컨트롤러");
		int mem_no = 3;
		Picture picture = new Picture();
		picture.setPic_open(pic_open);
		picture.setMem_no(mem_no);

		List<Picture> myShowList = picService.myShowPicture(picture);

		model.addAttribute("myShowList", myShowList);

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

		model.addAttribute("detail", picDetail);
		model.addAttribute("tag_list", tag_list);
		model.addAttribute("memInfo", memInfo);
		model.addAttribute("rep_count", rep_count);
		model.addAttribute("pic_list", pic_list);
		model.addAttribute("main_pic", main_pic);
		model.addAttribute("pic_no", pic_no);
		// model.addAttribute("move_pic", move_pic);

		return "basic/picDetail";
	}

}

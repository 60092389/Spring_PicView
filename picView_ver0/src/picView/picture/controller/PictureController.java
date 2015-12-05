package picView.picture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//my_Room->my_Manage.jsp에서 사용하는 사진목록볼러오기
	@RequestMapping("/jsp/**/manageForm")
	public String my_ManageForm(Model model){
		int mem_no = 3;
		List<Picture> picDate = picService.dateListPicture(mem_no);
		List<Picture> picList = picService.listPicture(mem_no);
		List<String> years = picService.yearListPicture(mem_no);
		List<String> months = picService.monthListPicture(mem_no);
		
		/*for(int i=0; i<years.size(); i++){
			System.out.println("year 리스트 : "+years.get(i));
		}*/
		
		model.addAttribute("date", picDate);
		model.addAttribute("list", picList);
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("years", years);
		model.addAttribute("months", months);

		return "myRoom/my_Manage";	
	}
	
	//사진권한변경
	@RequestMapping("jsp/**/updatePictureOpen")
	public String updatePictureOpen(UpdatePictureCommand upc){
		picService.updatePictureOpen(upc);
		
		return "redirect:/jsp/myRoom/manageForm";
	}
	
	//사진정보변경
	@RequestMapping("jsp/**/updatePictureInfo")
	public String updatePictureInfo(UpdatePictureCommand upc){
				
		picService.updatePictureInfo(upc);
		
		return "redirect:/jsp/myRoom/manageForm";
	}
	
	//사진삭제
	@RequestMapping("jsp/**/deletePicture")
	public String deletePicture(@RequestParam(value="pic_no") String pic_no, @RequestParam(value="mem_no") int mem_no){
		picService.deletePicture(pic_no,mem_no);
		
		return "redirect:/jsp/myRoom/manageForm";
	}
	
	
	
	//채영
	@RequestMapping(value="/jsp/**/myShowForm")
	public String my_ShowForm(Model model, @RequestParam(value="pic_open", required=false) String pic_open,
			@RequestParam(value="search",required=false) String search){
		//test
		
		//search 값 안되면 나중에 Hashmap 으로 보내기
		int mem_no=1;
		Picture picture = new Picture();
		picture.setPic_open(pic_open);
		picture.setMem_no(mem_no);
		picture.setSearch(search);
		System.out.println("여기 myShow 컨트롤러");
		System.out.println("넘어온 search 값 "+search);
		
		List<Picture> myShowList = picService.myShowPicture(picture);
			
		model.addAttribute("myShowList",myShowList);
				
		return "myRoom/my_Show";
	}
	
	@RequestMapping(value="/jsp/**/myShowSlide")
	public String my_ShowSlide(Model model, @RequestParam(value="pic_open", required=false) String pic_open){
		//test
		System.out.println("여기 slide 컨트롤러");
		int mem_no=3;
		Picture picture = new Picture();
		picture.setPic_open(pic_open);
		picture.setMem_no(mem_no);
						
		List<Picture> myShowList = picService.myShowPicture(picture);
			
		model.addAttribute("myShowList",myShowList);
				
		return "myRoom/myShowSlide";
	}

	
}
















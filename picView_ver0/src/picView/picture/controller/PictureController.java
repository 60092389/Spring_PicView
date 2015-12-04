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
		int mem_no = 1002;
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

	
}
















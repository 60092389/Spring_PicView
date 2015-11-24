package picView.picture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import picView.picture.model.Picture;
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
		int mem_no = 4;
		List<Picture> picDate = picService.dateListPicture(mem_no);
		List<Picture> picList = picService.listPicture(mem_no);
		
		model.addAttribute("date", picDate);
		model.addAttribute("list", picList);
		
		return "myRoom/my_Manage";	
	}

	
}

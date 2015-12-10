package picView.good.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import picView.good.model.Good;
import picView.good.service.GoodService;
import picView.member.model.AuthInfo;
import picView.picture.model.Picture;

@Controller
public class GoodController {
	private GoodService goodService;

	@Autowired
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	
	@RequestMapping("/jsp/**/picGood_In")
	public @ResponseBody Picture picDetail_Good(Good good, @RequestParam(value = "pic_no", required = false) int pic_no){
		// 좋아요 클릭
		
		good.setMem_no(1);
		good.setPic_no(pic_no);
		
		int findGood = goodService.findGood(good);
		
		if(findGood == 0){
			goodService.goodInsert(good);
			goodService.plus_good_count(pic_no);
		} else{
			goodService.goodDelete(good);
			goodService.minus_good_count(pic_no);
		}
		
		
		return goodService.detailPicture(pic_no);
		//return "picDetail_Good?pic_no=" + pic_no; 
		//"redirect:/jsp/basic/picDetail?pic_no="+pic_no;
		
	}
	
	@RequestMapping("/jsp/**/picGood_print")
	public @ResponseBody Picture picDetail_GoodPrint(Good good, @RequestParam(value = "pic_no", required = false) int pic_no,
			HttpSession session){
		// 좋아요 클릭
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		good.setMem_no(mem_no);
		good.setPic_no(pic_no);
		
		int findGood = goodService.findGood(good);
		
		return goodService.detailPicture(pic_no);
		
	}
}

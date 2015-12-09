package picView.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import picView.good.model.Good;
import picView.good.service.GoodService;
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
}

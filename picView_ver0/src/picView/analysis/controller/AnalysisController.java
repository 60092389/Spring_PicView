package picView.analysis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import picView.analysis.model.Analysis;
import picView.analysis.model.Analysis_select;
import picView.analysis.service.AnalysisService;
import picView.member.model.AuthInfo;
import picView.member.model.Member;
import picView.member.service.MemberService;

@Controller
public class AnalysisController {
	private AnalysisService anal_Service;
	private MemberService memberService;
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Autowired
	public void setAnal_Service(AnalysisService anal_Service) {
		this.anal_Service = anal_Service;
	}

	/*
	 * @RequestMapping("/jsp/myRoom/my_Analysis") public @ResponseBody Map<?, ?>
	 * listAnalysis(@RequestParam Map<String, Object> listAnal, ModelMap model){
	 * model.put("list", anal_Service.listAnalysis(listAnal)); return model; }
	 */

	@RequestMapping("/jsp/**/Anal_json")
	public @ResponseBody List<Analysis> listAnal(HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();

		return anal_Service.listAnalysis(mem_no);
	}

	@RequestMapping("/jsp/**/my_Analysis")
	public String my_Analysis(Analysis_select anal_select,HttpSession session,
			Model model) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		Member member = memberService.selectByNo(mem_no);
		String level = "1";
		// anal_Service.select_no(anal_select);
		
		String fol_check_list = "1";
		
		
		model.addAttribute("fol_check", fol_check_list);
		
		model.addAttribute("level", level);
		model.addAttribute("member", member);

		return "myRoom/my_Analysis";
	}

	/*
	 * @RequestMapping("/jsp/myRoom/json") public ModelAndView listAnal(){
	 * ModelAndView mav = new ModelAndView(); mav.addObject("list",
	 * anal_Service.listAnalysis()); mav.setViewName("jsonView");
	 * 
	 * return mav; }
	 */
}

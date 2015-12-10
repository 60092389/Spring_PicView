package picView.reply.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import picView.member.model.AuthInfo;
import picView.reply.model.Reply;
import picView.reply.service.ReplyService;

@Controller
public class ReplyController {
	
	private ReplyService service;
	
	@Autowired
	public void setService(ReplyService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/jsp/**/photo_reply",method=RequestMethod.POST)
	public @ResponseBody int photo_reply(Reply reply){
		System.out.println("--------댓글시작----------");
		System.out.println("댓글내용= " + reply.getRep_content());
		int re = service.insertReply(reply);
		return re;
	}
	
	@RequestMapping(value="/jsp/**/list_reply/{pic_no}")
	public @ResponseBody List<Reply> list_reply(@PathVariable String pic_no){
		return service.list_reply(Integer.parseInt(pic_no));
	}
	@RequestMapping(value="/jsp/**/reply_count/{pic_no}")
	public @ResponseBody int reply_count(@PathVariable String pic_no){
		return service.reply_count(Integer.parseInt(pic_no));
	}
	
	@RequestMapping(value="/jsp/**/photo_reply_detail")
  public @ResponseBody Reply photo_reply_detail(@RequestParam String pic_no
        ,@RequestParam String rep_content,HttpSession session){
     AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
     
     int mem_no = authInfo.getMem_no();
     String mem_pic = authInfo.getMem_pic();
     String mem_name = authInfo.getMem_name();
     System.out.println("mem_name" +mem_name);
     Reply reply = new Reply();
     reply.setMem_no(mem_no);
     reply.setPic_no(Integer.parseInt(pic_no));
     reply.setRep_content(rep_content);
     service.photo_reply_detail(reply);
     return new Reply(Integer.parseInt(pic_no), mem_no, rep_content
           , "0",new Timestamp(System.currentTimeMillis()) , mem_name, mem_pic);
  }
	
  @RequestMapping(value="/jsp/**/list_reply_detail{pic_no_chk}")
  public @ResponseBody List<Reply>list_reply_detail(@PathVariable String pic_no_chk){
     int pic_no = Integer.parseInt(pic_no_chk);
     
     List<Reply> list = service.list_reply_detail(pic_no);
     
     
     return list;
  }
	
	
}

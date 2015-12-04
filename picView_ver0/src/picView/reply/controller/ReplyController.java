package picView.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import picView.reply.model.Reply;
import picView.reply.service.ReplyService;

@Controller
public class ReplyController {
	
	private ReplyService service;
	
	@Autowired
	public void setService(ReplyService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/jsp/main/photo_reply",method=RequestMethod.POST)
	public @ResponseBody int photo_reply(Reply reply){
		System.out.println("--------댓글시작----------");
		System.out.println("댓글내용= " + reply.getRep_content());
		int re = service.insertReply(reply);
		return re;
	}
	
	@RequestMapping(value="/jsp/main/list_reply/{pic_no}")
	public @ResponseBody List<Reply> list_reply(@PathVariable String pic_no){
		return service.list_reply(Integer.parseInt(pic_no));
	}
	@RequestMapping(value="/jsp/main/reply_count/{pic_no}")
	public @ResponseBody int reply_count(@PathVariable String pic_no){
		return service.reply_count(Integer.parseInt(pic_no));
	}
	
	
}

package picView.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import picView.member.model.AuthInfo;
import picView.member.model.Member;
import picView.member.model.MemberDao;
import picView.message.model.Message;
import picView.message.service.MessageService;

@Controller
public class MessageController {
	private MessageService messageService;
	private MemberDao memberDao;
	
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@RequestMapping(value = "/jsp/**/message_write", method = RequestMethod.GET)
	public @ResponseBody String message_form() {

		return "/message/message_write";
	}

	@RequestMapping(value = "/jsp/**/message_write", method = RequestMethod.POST)
	public String message_send(Message message, HttpSession session) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		Member member = memberDao.selectByNo(mem_no);
		
		
		message.setMem_no(mem_no);
		message.setMsg_sender(member.getMem_name());
		
		int re = messageService.sendMessage(message);

		if (re < 1) {
			return "/message/message_write";
		} else {
			return "redirect:/jsp/message/message";
		}

	}

	@RequestMapping("/jsp/**/message")
	public String message_list(Model model, HttpSession session) {
		System.out.println("들어옴");
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();

		List<Message> message_list = messageService.listMessage(mem_no);

		model.addAttribute("message_list", message_list);

		return "/message/message";
	}

	@RequestMapping("/jsp/**/message_list_json")
	public @ResponseBody List<Message> message_list_json(HttpSession session) {
		System.out.println("들어옴");
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();

		return messageService.listMessage(mem_no);
	}

	@RequestMapping("/jsp/**/send_list")
	public String send_list(Model model, HttpSession session) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		List<Message> send_list = messageService.sendList(mem_no);
		model.addAttribute("send_list", send_list);

		return "/message/message_send";
	}

	@RequestMapping("/jsp/**/send_list_json")
	public @ResponseBody List<Message> send_list_json(HttpSession session) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		return messageService.sendList(mem_no);
	}

	@RequestMapping("/jsp/**/saveMessage")
	public String saveMessage(@RequestParam(value = "msg_no", required = false) String msg_no) {

		HashMap<String, Object> msg_no_list = new HashMap<String, Object>();
		msg_no_list.put("msg_no", msg_no.split(","));

		messageService.saveMessage(msg_no_list);

		return "/message/message";
	}

	@RequestMapping("/jsp/**/save_list")
	public String save_list(Model model, HttpSession session) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		List<Message> save_list = messageService.saveList(mem_no);
		model.addAttribute("save_list", save_list);

		return "/message/message_save";
	}

	@RequestMapping("/jsp/**/save_list_json")
	public @ResponseBody List<Message> save_list_json(HttpSession session) {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		return messageService.saveList(mem_no);
	}

	@RequestMapping("/jsp/**/message_json")
	public @ResponseBody List<Message> message_json(HttpSession session) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		int mem_no = authInfo.getMem_no();
		
		return messageService.listMessage(mem_no);
	}

	@RequestMapping("/jsp/**/message_detail/{msg_no}")
	public String message_detail(Model model, @PathVariable int msg_no) {
		List<Message> detailMessage = messageService.detailMessage(msg_no);

		String msg_check = detailMessage.get(0).getMsg_check();

		if (msg_check.equals("N")) {
			messageService.update_rec_date(detailMessage); // 자세히보기(수신확인, 수신날짜
															// 수정)
		}

		model.addAttribute("detail", detailMessage);

		return "/message/message_detail";
	}

	@RequestMapping("/jsp/**/message_detail_json/{msg_no}")
	public @ResponseBody List<Message> message_detail_json(@PathVariable int msg_no) {
		List<Message> detailMessage = messageService.detailMessage(msg_no);

		String msg_check = detailMessage.get(0).getMsg_check();

		if (msg_check.equals("N")) {
			messageService.update_rec_date(detailMessage); // 자세히보기(수신확인, 수신날짜
															// 수정)
		}

		return detailMessage;
	}

	@RequestMapping("/jsp/**/message_delete")
	public String message_delete(@RequestParam(value = "msg_no", required = false) String msg_no) {
		// @PathVariable int msg_no
		// @RequestParam(value="check", required=false) String msg_no

		HashMap<String, Object> msg_no_list = new HashMap<String, Object>();
		msg_no_list.put("msg_no", msg_no.split(","));

		messageService.deleteMessage(msg_no_list);

		return "redirect:/jsp/message/message";
	}

	@RequestMapping("jsp/**/find_sender")
	public List<String> find_sender(@RequestParam(value = "msg_sender", required = false) String msg_sender) {
		List<String> find_sneder = messageService.findSender(msg_sender);

		return find_sneder;
	}
}

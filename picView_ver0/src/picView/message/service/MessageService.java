package picView.message.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.message.model.Message;
import picView.message.model.MessageDao;

@Service
public class MessageService {
	private MessageDao messageDao;

	@Autowired
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	public List<String> findSender(String msg_sender){
		return messageDao.findSender(msg_sender);
	}
	
	// 쪽지 전송
	public int sendMessage(Message message){
		return messageDao.sendMessage(message);
	}
	// 받은 쪽지함
	public List<Message> listMessage(int mem_no){
		List<Message> list = messageDao.listMessage(mem_no);
		
		return list;
	}
	// 보낸 쪽지함
	public List<Message> sendList(int mem_no){
		return messageDao.sendList(mem_no);
	}
	// 쪽지 보관(쪽지번호로 쪽지내용)
	public Message findMessage(String msg_no){
		return messageDao.findMessage(msg_no);
	}
	// 쪽지 보관(msg_list_check 수정)
	public int saveMessage(HashMap<String, Object> msg_no_list){
		return messageDao.saveMessage(msg_no_list);
	}
	// 쪽지 보관함
	public List<Message> saveList(int mem_no){
		return messageDao.saveList(mem_no);
	}
	// 자세히 보기
	public List<Message> detailMessage(int msg_no){
		return messageDao.detailMessage(msg_no);
	}
	// 쪽지 삭제
	public int deleteMessage(HashMap<String, Object> msg_no_list){
		return messageDao.deleteMessage(msg_no_list);
	}
	// 자세히 보기(수신 확인, 수신 날짜 수정)
	public int update_rec_date(List<Message> detailMessage){
		return messageDao.update_rec_date(detailMessage);
	}
}

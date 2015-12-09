package picView.message.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.message.mapper.MessageMapper;

@Component
public class MessageDao {
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}

	public List<String> findSender(String msg_sender) {
		return myTemplate.getMapper(MessageMapper.class).findSender(msg_sender);
	}

	// 쪽지 전송
	public int sendMessage(Message message) {
		return myTemplate.getMapper(MessageMapper.class).sendMessage(message);
	}

	// 받은 쪽지함
	public List<Message> listMessage(int mem_no) {
		return myTemplate.getMapper(MessageMapper.class).listMessage(mem_no);
	}

	// 보낸 쪽지함
	public List<Message> sendList(int mem_no) {
		return myTemplate.getMapper(MessageMapper.class).sendList(mem_no);
	}

	// 쪽지 보관(쪽지번호로 쪽지내용)
	public Message findMessage(String msg_no) {
		return myTemplate.getMapper(MessageMapper.class).findMessage(msg_no);
	}

	// 쪽지 보관(msg_list_check 수정)
	public int saveMessage(HashMap<String, Object> msg_no_list) {
		return myTemplate.getMapper(MessageMapper.class).saveMessage(msg_no_list);
	}

	// 쪽지 보관함
	public List<Message> saveList(int mem_no) {
		return myTemplate.getMapper(MessageMapper.class).saveList(mem_no);
	}

	// 자세히 보기
	public Message detailMessage(int msg_no) {
		return myTemplate.getMapper(MessageMapper.class).detailMessage(msg_no);
	}

	// 쪽지 삭제
	public int deleteMessage(HashMap<String, Object> msg_no_list) {
		return myTemplate.getMapper(MessageMapper.class).deleteMessage(msg_no_list);
	}
	
	// 자세히보기(수신확인, 수신날짜 수정)
	public int update_rec_date(Message message){
		return myTemplate.getMapper(MessageMapper.class).update_rec_date(message);
	}
}

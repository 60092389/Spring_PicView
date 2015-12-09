package picView.message.mapper;

import java.util.HashMap;
import java.util.List;
import picView.message.model.Message;

public interface MessageMapper {
	public List<String> findSender(String msg_sender);
	
	public int sendMessage(Message message);	// 쪽지 전송
	public List<Message> listMessage(int mem_no);	// 받은 쪽지함
	public List<Message> sendList(int mem_no);	// 보낸 쪽지함
	public Message findMessage(String msg_no);	// 쪽지 보관(쪽지번호로 쪽지내용)
	public int saveMessage(HashMap<String, Object> msg_no_list);	// 쪽지 보관(msg_list_check 수정)
	public List<Message> saveList(int mem_no);	// 쪽지 보관함
	public Message detailMessage(int msg_no);	// 자세히 보기
	public int deleteMessage(HashMap<String, Object> msg_no_list);	// 쪽지 삭제
	public int update_rec_date(Message message);	// 자세히보기(수신확인, 수신날짜 수정)
}

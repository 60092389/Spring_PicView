package picView.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.reply.model.Reply;
import picView.reply.model.ReplyDao;

@Service
public class ReplyService {
	
	private ReplyDao dao;

	@Autowired
	public void setDao(ReplyDao dao) {
		this.dao = dao;
	}
	
	public int insertReply(Reply reply){
		
		return dao.insertReply(reply);
	}
	public List<Reply> list_reply(int pic_no){
		return dao.list_reply(pic_no);
	}
	public int reply_count(int pic_no){
		return dao.reply_count(pic_no);
	}
	
	public int photo_reply_detail(Reply reply){
    return dao.photo_reply_detail(reply);
 }
 public List<Reply> list_reply_detail(int pic_no){
    return dao.list_reply_detail(pic_no);
 }
	
}

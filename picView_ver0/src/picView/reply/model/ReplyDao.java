package picView.reply.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.picture.model.Picture;
import picView.reply.mapper.ReplyMapper;

@Component
public class ReplyDao {
	
	private SqlSessionTemplate myTemplate;
	
	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	public int insertReply(Reply reply){
		return myTemplate.getMapper(ReplyMapper.class).insertReply(reply);
	}
	public List<Reply> list_reply(int pic_no){
		return myTemplate.getMapper(ReplyMapper.class).list_reply(pic_no);
	}
	public int reply_count(int pic_no){
		return myTemplate.getMapper(ReplyMapper.class).reply_count(pic_no);
	}
	public int myShowReply_count(int pic_no){
		
		return myTemplate.getMapper(ReplyMapper.class).myShowReply_count(pic_no);
	}
	
	public int photo_reply_detail(Reply reply){
    return myTemplate.getMapper(ReplyMapper.class).photo_reply_detail(reply);
 }
	public List<Reply> list_reply_detail(int pic_no){
    return myTemplate.getMapper(ReplyMapper.class).list_reply_detail(pic_no);
 }
}

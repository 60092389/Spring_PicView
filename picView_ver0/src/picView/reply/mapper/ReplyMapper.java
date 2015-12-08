package picView.reply.mapper;

import java.util.List;

import picView.reply.model.Reply;

public interface ReplyMapper {
	
	public int insertReply(Reply reply);//댓글 등록
	public List<Reply> list_reply(int pic_no);//댓글 리스트
	public int reply_count(int pic_no);//뉴스피드에서 댓글 카운트
	
}

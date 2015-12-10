package picView.reply.mapper;

import java.util.List;

import picView.reply.model.Reply;

public interface ReplyMapper {
	
	public int insertReply(Reply reply);//댓글 등록
	public List<Reply> list_reply(int pic_no);//댓글 리스트
	public int reply_count(int pic_no);//뉴스피드에서 댓글 카운트
	
	public int myShowReply_count(int pic_no);//myShow에서 사진마다 보여줄 reply_count
	public int photo_reply_detail(Reply reply);//상세보기에서 댓글 추가
  public List<Reply> list_reply_detail(int pic_no);
	
}

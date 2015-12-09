package picView.good.mapper;

import picView.good.model.Good;
import picView.picture.model.Picture;

public interface GoodMapper {
	public void goodInsert(Good good);	// 좋아요 insert
	public int goodDelete(Good good);	// 좋아요 delete
	public int plus_good_count(int pic_no);	// 상세보기 - 좋아요 +1
	public int minus_good_count(int pic_no);	// 상세보기 - 좋아요 -1
	public int findGood(Good good);	// 좋아요 확인
	
	public Picture detailPicture(int pic_no);	// 상세보기 - 사진 정보
	
}

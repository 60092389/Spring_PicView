package picView.good.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.good.mapper.GoodMapper;
import picView.good.model.Good;
import picView.good.model.GoodDao;
import picView.picture.model.Picture;

@Service
public class GoodService {
	private GoodDao goodDao;

	@Autowired
	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}
	
	// 좋아요 insert
	public void goodInsert(Good good) {
		goodDao.goodInsert(good);
	}

	// 좋아요 delete
	public int goodDelete(Good good) {
		return goodDao.goodDelete(good);
	}

	// 상세보기 - 좋아요 +1
	public int plus_good_count(int pic_no) {
		return goodDao.plus_good_count(pic_no);
	}

	// 상세보기 - 좋아요 -1
	public int minus_good_count(int pic_no) {
		return goodDao.minus_good_count(pic_no);
	}

	// 좋아요 확인
	public int findGood(Good good) {
		return goodDao.findGood(good);
	}

	// 상세보기 사진 정보
	public Picture detailPicture(int pic_no) {
		return goodDao.detailPicture(pic_no);
	}

}

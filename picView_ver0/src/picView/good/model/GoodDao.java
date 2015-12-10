package picView.good.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.good.mapper.GoodMapper;
import picView.picture.model.Picture;

@Component
public class GoodDao {
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}

	// 좋아요 insert
	public void goodInsert(Good good) {
		myTemplate.getMapper(GoodMapper.class).goodInsert(good);
	}

	// 좋아요 delete
	public int goodDelete(Good good) {
		return myTemplate.getMapper(GoodMapper.class).goodDelete(good);
	}

	// 상세보기 - 좋아요 +1
	public int plus_good_count(int pic_no) {
		return myTemplate.getMapper(GoodMapper.class).plus_good_count(pic_no);
	}

	// 상세보기 - 좋아요 -1
	public int minus_good_count(int pic_no) {
		return myTemplate.getMapper(GoodMapper.class).minus_good_count(pic_no);
	}

	// 좋아요 확인
	public int findGood(Good good) {
		return myTemplate.getMapper(GoodMapper.class).findGood(good);
	}

	// 상세보기 - 사진 정보
	public Picture detailPicture(int pic_no) {
		return myTemplate.getMapper(GoodMapper.class).detailPicture(pic_no);
	}

}

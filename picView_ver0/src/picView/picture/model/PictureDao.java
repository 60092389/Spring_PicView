package picView.picture.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.member.model.Member;
import picView.picture.mapper.PictureMapper;

@Component
public class PictureDao {

	@Autowired
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}

	public Picture selectByPicno(int pic_no) {
		Picture pic = null;
		pic = myTemplate.getMapper(PictureMapper.class).selectByPicno(pic_no);
		return pic;
	}

	// my_Manage.jsp에 사용되는 날짜뽑는 리스트
	public List<Picture> PictureDate(int mem_no) {
		return myTemplate.getMapper(PictureMapper.class).PictureDate(mem_no);
	}

	// my_Manage.jsp에 사용되는 년도뽑는 리스트
	public List<String> PictureYear(int mem_no) {

		return myTemplate.getMapper(PictureMapper.class).PictureYear(mem_no);
	}

	// my_Manage.jsp에 사용되는 월 뽑는 리스트
	public List<String> PictureMonth(int mem_no) {
		return myTemplate.getMapper(PictureMapper.class).PictureMonth(mem_no);
	}

	// 해당 회원의 사진목록 뽑기
	public List<Picture> PictureList(int mem_no) {
		return myTemplate.getMapper(PictureMapper.class).PictureList(mem_no);
	}

	// 사진 권한 동시에 설정
	public void UpdatePictureOpen(Picture picture) {
		myTemplate.getMapper(PictureMapper.class).UpdatePictureOpen(picture);
	}

	public void UpdatePictureInfo(Picture picture) {
		myTemplate.getMapper(PictureMapper.class).UpdatePictureInfo(picture);
	}

	public void DeletePicture(int pic_no) {
		myTemplate.getMapper(PictureMapper.class).DeletePicture(pic_no);
	}

	// 채영
	// 보여주기 사진목록
	public List<Picture> myShowPicture(Picture picture) {
		return myTemplate.getMapper(PictureMapper.class).myShowPicture(picture);
	}

	// 상세보기 시작
	// 상세보기 - 사진 정보
	public Picture detailPicture(int pic_no) {
		return myTemplate.getMapper(PictureMapper.class).detailPicture(pic_no);
	}

	// 상세보기 - 태그들
	public String tag_list(int pic_no) {
		return myTemplate.getMapper(PictureMapper.class).tag_list(pic_no);
	}

	// 상세보기 - 회원정보(이름, 프로필 사진)
	public Member memInfo(int pic_no) {
		return myTemplate.getMapper(PictureMapper.class).memInfo(pic_no);
	}

	// 상세보기 - 댓글 갯수
	public int rep_count(int pic_no) {
		return myTemplate.getMapper(PictureMapper.class).rep_count(pic_no);
	}

	// 상세보기 - 사진 리스트
	public List<Picture> pic_list(int pic_no) {
		return myTemplate.getMapper(PictureMapper.class).pic_list(pic_no);
	}

	// 상세보기 - 선택한 사진번호
	public int select_pic(String pic_add) {
		return myTemplate.getMapper(PictureMapper.class).select_pic(pic_add);
	}

	// 상세보기 - 메인 사진
	public String main_pic(int pic_no) {
		return myTemplate.getMapper(PictureMapper.class).main_pic(pic_no);
	}
	// 상세보기 끝

}

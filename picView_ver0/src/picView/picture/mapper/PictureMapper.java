package picView.picture.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import picView.member.model.Member;
import picView.picture.model.Picture;

public interface PictureMapper {

	public List<Picture> PictureList(int mem_no);

	public List<Picture> PictureDate(int mem_no);

	public List<String> PictureYear(int mem_no);

	public List<String> PictureMonth(int mem_no);

	public void UpdatePictureOpen(Picture picture);

	public Picture selectByPicno(int pic_no);

	public void UpdatePictureInfo(Picture picture);

	public void DeletePicture(int pic_no);

	// myShow(보여주기)
	public List<Picture> myShowPicture(Picture picture);

	// 상세보기
	public String main_pic(int pic_no);

	public int select_pic(String pic_add);

	public List<Picture> pic_list(int pic_no);

	public Member memInfo(int pic_no);

	public int rep_count(int pic_no);

	public String tag_list(int pic_no);

	public Picture detailPicture(int pic_no);

	public int findGood(int pic_no);

	public String findCategory(int pic_no);

	public int findAlbum_count(int pic_no);

	public List<String> findAlbum_pic_add(int pic_no);

	public List<String> findAlbum_name(int pic_no);

	public List<Integer> findAlbum_pic_count(int pic_no);
	
	public int update_count(Picture picture);

	// 상세보기 끝

	public int insertPicture(Picture picture);
	
	
	public int mem_pic_count(int mem_no);//사진 업로드시 member테이블 사진 갯수 추가
	
	public List<Picture> recent_Pic(RowBounds row);//최근 사진 리스트
	public int count_Recent();

}

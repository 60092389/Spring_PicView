package picView.picture.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.picture.mapper.PictureMapper;

@Component
public class PictureDao {
	
	@Autowired
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	//my_Manage.jsp에 사용되는 날짜뽑는 리스트
	public List<Picture> PictureDate(int mem_no){
		return myTemplate.getMapper(PictureMapper.class).PictureDate(mem_no);
	}
	
	//해당 회원의 사진목록 뽑기
	public List<Picture> PictureList(int mem_no){
		return myTemplate.getMapper(PictureMapper.class).PictureList(mem_no);
	}
	
	
}

package picView.upload.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.upload.mapper.PictureMapper;

@Component
public class UploadDao {
	
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	public int insertPicture(Picture picture){
		return myTemplate.getMapper(PictureMapper.class).insertPicture(picture);
	}
	
}

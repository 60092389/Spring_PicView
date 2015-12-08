package picView.album.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import picView.album.mapper.AlbumMapper;
import picView.cate.model.Category;
import picView.member.model.Member;
import picView.picture.mapper.PictureMapper;
import picView.picture.model.Picture;

@Component
@Repository
public class AlbumDao {
	
	@Autowired
	private SqlSessionTemplate myTemplate;
	
	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	public List<Album> albumlist(Album album){
		return myTemplate.getMapper(AlbumMapper.class).albumlist(album);
	}
	
	public List<Group_Pic> grouplist(int alb_no){
		return myTemplate.getMapper(AlbumMapper.class).grouplist(alb_no);
	}
	
	public List<Picture> albumpiclist(int pic_no){
		return myTemplate.getMapper(AlbumMapper.class).albumpiclist(pic_no);
	}
	
	
	
	public List<Picture> piclist(int mem_no){
		return myTemplate.getMapper(AlbumMapper.class).piclist(mem_no);
	}
	
	public void insertAlbum(Album album){	
		myTemplate.getMapper(AlbumMapper.class).insertAlbum(album);	
	}
	
	public Album selectAlbum_no(String alb_word){
		Album m = null;
		m = myTemplate.getMapper(AlbumMapper.class).selectAlbum_no(alb_word);
		return m;
	}
	
	
	public void insertGroup(Group_Pic group){
		myTemplate.getMapper(AlbumMapper.class).insertGroup(group);
	}
	
	public Album detailAlbum(int alb_no){
		return myTemplate.getMapper(AlbumMapper.class).detailAlbum(alb_no);
	}
	
	public Picture selectPicture(int pic_no){
		return myTemplate.getMapper(AlbumMapper.class).selectPicture(pic_no);
	}
	
	
	public void deleteGroup(int alb_no){
		myTemplate.getMapper(AlbumMapper.class).deleteGroup(alb_no);
	}
	
	public void deleteAlbum(int alb_no){
		myTemplate.getMapper(AlbumMapper.class).deleteAlbum(alb_no);
	}
	
	public void albumlevel(Album levelCommand){
		
		myTemplate.getMapper(AlbumMapper.class).albumlevel(levelCommand);
	}
	
	public List<Picture> pic_search(String pic_search){
		return myTemplate.getMapper(AlbumMapper.class).pic_search(pic_search);
	}
	
	public Category categorylist(int category_no){
		return myTemplate.getMapper(AlbumMapper.class).categorylist(category_no);
	}
	
	public void DeletePicture_In_Album(Group_Pic group_pic){
		myTemplate.getMapper(AlbumMapper.class).DeletePicture_In_Album(group_pic);
	}
	
	public List<Integer> GroupPicList_By_Pic_no(int pic_no){
		return myTemplate.getMapper(AlbumMapper.class).GroupPicList_By_Pic_no(pic_no);
	}
	
	public int GroupPic_AlbNo_count_By_Alb_no(int alb_no){
		return myTemplate.getMapper(AlbumMapper.class).GroupPic_AlbNo_count_By_Alb_no(alb_no);
	}
	

}

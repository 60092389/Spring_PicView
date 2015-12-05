package picView.album.mapper;

import java.util.List;

import picView.album.model.Album;
import picView.album.model.Group_Pic;
import picView.picture.model.Picture;

public interface AlbumMapper {
	
	public List<Album> albumlist(int mem_no);
	public List<Group_Pic> grouplist(int alb_no);
	public List<Picture> albumpiclist(int pic_no);
	public List<Picture> piclist(int mem_no);
	public void insertAlbum(Album album);
	public Album selectAlbum_no(String alb_word);
	public void insertGroup(Group_Pic group);
	public Album detailAlbum(int alb_no);
	public Picture selectPicture(int pic_no);
	public void deleteGroup(int alb_no);
	public void deleteAlbum(int alb_no);

}

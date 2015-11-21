package picView.picture.mapper;

import java.util.List;

import picView.picture.model.Picture;
import picView.picture.model.PictureShow;

public interface PictureMapper {
	
	public int insertPicture(Picture picture);
	public List<PictureShow> listMyShow(int mem_no);
	public List<Picture> ManageListPicture(int mem_no);
	public List<Picture> PictureDate(int mem_no);
	public int deletePicture(int pic_no);

}

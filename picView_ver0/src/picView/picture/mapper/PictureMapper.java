package picView.picture.mapper;

import java.util.List;

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
	
	//myShow(보여주기)
	public List<Picture> myShowPicture(Picture picture);


}

package picView.picture.mapper;

import java.util.List;

import picView.picture.model.Picture;

public interface PictureMapper {
	
	public List<Picture> PictureList(int mem_no);
	public List<Picture> PictureDate(int mem_no);


}

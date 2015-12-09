package picView.picture.model;

import java.io.Serializable;
import java.util.List;

public class PictureShow implements Serializable {
	private List<Picture> pic_list;//가져갈사진목록
	private int relation;//나와친구관계
	
	public PictureShow(){}
	
	public PictureShow(List<Picture> pic_list, int relation) {
		super();
		this.pic_list = pic_list;
		this.relation = relation;
	}

	public List<Picture> getPic_list() {
		return pic_list;
	}

	public void setPic_list(List<Picture> pic_list) {
		this.pic_list = pic_list;
	}

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}
	
		
	

}

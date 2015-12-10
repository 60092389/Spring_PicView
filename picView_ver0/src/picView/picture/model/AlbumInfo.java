package picView.picture.model;

import java.io.Serializable;
import java.util.List;

public class AlbumInfo implements Serializable {
	private List<String> pic_add;
	private List<String> alb_name;
	private List<Integer> alb_pic_count;

	public AlbumInfo() {
	}

	public AlbumInfo(List<String> pic_add, List<String> alb_name, List<Integer> alb_pic_count) {
		super();
		this.pic_add = pic_add;
		this.alb_name = alb_name;
		this.alb_pic_count = alb_pic_count;
	}

	public List<String> getPic_add() {
		return pic_add;
	}

	public void setPic_add(List<String> pic_add) {
		this.pic_add = pic_add;
	}

	public List<String> getAlb_name() {
		return alb_name;
	}

	public void setAlb_name(List<String> alb_name) {
		this.alb_name = alb_name;
	}

	public List<Integer> getAlb_pic_count() {
		return alb_pic_count;
	}

	public void setAlb_pic_count(List<Integer> alb_pic_count) {
		this.alb_pic_count = alb_pic_count;
	}

	@Override
	public String toString() {
		return "AlbumInfo [pic_add=" + pic_add + ", alb_name=" + alb_name + ", alb_pic_count=" + alb_pic_count + "]";
	}
}

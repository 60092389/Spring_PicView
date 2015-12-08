package picView.album.model;

import java.io.Serializable;
import java.util.List;

public class AlbumResult implements Serializable {
	private List<Album> albumlist;
	private int relation;
	
	public AlbumResult(){}
	
	public AlbumResult(List<Album> albumlist, int relation) {
		super();
		this.albumlist = albumlist;
		this.relation = relation;
	}

	public List<Album> getAlbumlist() {
		return albumlist;
	}

	public void setAlbumlist(List<Album> albumlist) {
		this.albumlist = albumlist;
	}

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}
	
	
	
	
}

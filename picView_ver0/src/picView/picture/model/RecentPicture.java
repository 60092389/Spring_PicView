package picView.picture.model;

import java.io.Serializable;
import java.util.List;

public class RecentPicture implements Serializable {
	private List<Picture> list;
	private int requestPage; //요청하는 페이지
	private int totalPageCount;//화면에서 글갯수 몇개를 보여줄것인지 페이지 갯수
	private int startPage;
	private int endPage;
	
	public RecentPicture(){};
	
	
	public RecentPicture(List<Picture> list, int requestPage, int totalPageCount, int startPage, int endPage) {
		super();
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}




	public List<Picture> getList() {
		return list;
	}
	public void setList(List<Picture> list) {
		this.list = list;
	}
	public int getRequestPage() {
		return requestPage;
	}
	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
}

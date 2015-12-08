package picView.newsfeed.model;

import java.io.Serializable;
import java.util.List;

public class ListNewsfeedModel implements Serializable{
	private List<Newsfeed> list;
	private int requestPage; //요청하는 페이지
	private int totalPageCount;//화면에서 글갯수 몇개를 보여줄것인지 페이지 갯수
	private int startPage;
	private int endPage;
	private int reply_count;//뉴스피드에서 보여지는 댓글 카운트 갯수
	
	public ListNewsfeedModel(){}

	public ListNewsfeedModel(List<Newsfeed> list, int requestPage, int totalPageCount, int startPage, int endPage) {
		super();
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public List<Newsfeed> getList() {
		return list;
	}

	public void setList(List<Newsfeed> list) {
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

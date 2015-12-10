package picView.newsfeed.model;

import java.io.Serializable;
import java.util.List;

public class ActivityModel implements Serializable{
	public List<ActivityList> list;
	private int requestPage; //요청하는 페이지
	private int totalPageCount;//화면에서 글갯수 몇개를 보여줄것인지 페이지 갯수
	private int startPage;
	private int endPage;
	private int total_count;
	
	public ActivityModel(){}
	
	

	public ActivityModel(List<ActivityList> list, int requestPage, int totalPageCount, int startPage, int endPage,
			int total_count) {
		super();
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.total_count = total_count;
	}



	public List<ActivityList> getList() {
		return list;
	}

	public void setList(List<ActivityList> list) {
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



	public int getTotal_count() {
		return total_count;
	}



	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	
	
	
	
}

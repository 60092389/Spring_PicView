package picView.admin.model;

import java.util.List;

import picView.member.model.Member;

public class ListModel {
	private List<Member> list;
	private int requestPage;
	private int totalPage;
	private int startPage;
	private int endPage;
	
	public ListModel() {}
	
	public ListModel(List<Member> list, int requestPage, int totalPage,
			int startPage, int endPage) {
		super();
		this.list = list;
		this.requestPage = requestPage;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
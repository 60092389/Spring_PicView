package picView.upload.model;

import java.io.Serializable;

public class KoreaSearch implements Serializable{
	private String addr1;
	private String addr2;
	private String contentid;
	private String contenttypeid;
	private String firstimage;
	private String title;
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getContenttypeid() {
		return contenttypeid;
	}
	public void setContenttypeid(String contenttypeid) {
		this.contenttypeid = contenttypeid;
	}
	public String getFirstimage() {
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

	@Override
	public String toString() {
		return "KoreaSearch [addr1=" + addr1 + ", addr2=" + addr2 + ", contentid=" + contentid + ", contenttypeid="
				+ contenttypeid + ", firstimage=" + firstimage + ", title=" + title + "]";
	}
	
	
	
	
	
	
}

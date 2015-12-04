package picView.upload.model;

import java.io.Serializable;

public class NaverSearch implements Serializable{
	private String title;
	private String image;
	private String author;
	private String price;
	private String publisher;
	private String pubdate;
	private String description;
	private String target; //현재 선택한 카테고리
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	@Override
	public String toString() {
		return "NaverSearch [title=" + title + ", image=" + image + ", author=" + author + ", price=" + price
				+ ", publisher=" + publisher + ", pubdate=" + pubdate + ", description=" + description + "]";
	}
	
}

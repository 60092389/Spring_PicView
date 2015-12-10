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
	private String person_title;//인물 타이틀명
	private String person_image;//인물 사진
	private String person_description;//인물 설명
	private String image_title;//이미지 제목
	private String image_thumbnail;//이미지 썸네일
	
	
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
	
	public String getPerson_title() {
		return person_title;
	}
	public void setPerson_title(String person_title) {
		this.person_title = person_title;
	}
	
	public String getPerson_image() {
		return person_image;
	}
	public void setPerson_image(String person_image) {
		this.person_image = person_image;
	}
	
	public String getPerson_description() {
		return person_description;
	}
	public void setPerson_description(String person_description) {
		this.person_description = person_description;
	}
	
	public String getImage_title() {
		return image_title;
	}
	public void setImage_title(String image_title) {
		this.image_title = image_title;
	}
	public String getImage_thumbnail() {
		return image_thumbnail;
	}
	public void setImage_thumbnail(String image_thumbnail) {
		this.image_thumbnail = image_thumbnail;
	}
	@Override
	public String toString() {
		return "NaverSearch [title=" + title + ", image=" + image + ", author=" + author + ", price=" + price
				+ ", publisher=" + publisher + ", pubdate=" + pubdate + ", description=" + description + "]";
	}
	
}

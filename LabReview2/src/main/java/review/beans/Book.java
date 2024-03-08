package review.beans;

public class Book {
	private String BookId;
	private String Title;
	private String Author;
	private int Release;
	private float Price;
	private String Picture;
	private int PublisherId;
	private int CategoryId;


public Book() {
	
}

public Book(String BookId, String Title, String Author, int Release, float Price, String Picture, int PublisherId, int CategoryId) {
	this.BookId = BookId;
	this.Title = Title;
	this.Author = Author;
	this.Release = Release;
	this.Price = Price;
	this.Picture = Picture;
	this.PublisherId = PublisherId;
	this.CategoryId = CategoryId;
}

/**
 * @return the bookId
 */
public String getBookId() {
	return BookId;
}


/**
 * @param bookId the bookId to set
 */
public void setBookId(String bookId) {
	BookId = bookId;
}


/**
 * @return the title
 */
public String getTitle() {
	return Title;
}


/**
 * @param title the title to set
 */
public void setTitle(String title) {
	Title = title;
}


/**
 * @return the author
 */
public String getAuthor() {
	return Author;
}


/**
 * @param author the author to set
 */
public void setAuthor(String author) {
	Author = author;
}


/**
 * @return the release
 */
public int getRelease() {
	return Release;
}


/**
 * @param release the release to set
 */
public void setRelease(int release) {
	Release = release;
}


/**
 * @return the price
 */
public float getPrice() {
	return Price;
}


/**
 * @param price the price to set
 */
public void setPrice(float price) {
	Price = price;
}


/**
 * @return the picture
 */
public String getPicture() {
	return Picture;
}


/**
 * @param picture the picture to set
 */
public void setPicture(String picture) {
	Picture = picture;
}


/**
 * @return the publisherId
 */
public int getPublisherId() {
	return PublisherId;
}


/**
 * @param publisherId the publisherId to set
 */
public void setPublisherId(int publisherId) {
	PublisherId = publisherId;
}


/**
 * @return the categoryId
 */
public int getCategoryId() {
	return CategoryId;
}


/**
 * @param categoryId the categoryId to set
 */
public void setCategoryId(int categoryId) {
	CategoryId = categoryId;
}

	
}

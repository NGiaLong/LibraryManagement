package com.model;

public class Book {
	int id;
	String title;
	String description;
	String author;
	int edition;
	String publisher;
	int categoryId;
	String categoryName;
	boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Book(String title, String description, String author, int edition, String publisher, int categoryId,
			boolean status) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.edition = edition;
		this.publisher = publisher;
		this.categoryId = categoryId;
		this.status = status;
	}

	public Book(int id, String title, String description, String author, int edition, String publisher, int categoryId,
			boolean status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.edition = edition;
		this.publisher = publisher;
		this.categoryId = categoryId;
		this.status = status;
	}

	public Book() {
	}
}

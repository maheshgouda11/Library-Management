package com.Library.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 @Column(name="Title")
 private String Title;
 @Column(name="Auther")
 private String Auther;
 @Column(name="Borrowed")
 private boolean Borrowed;
 @ManyToOne
 @JoinColumn(name ="userid")
 private User borrowedBy;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getAuther() {
	return Auther;
}
public void setAuther(String auther) {
	Auther = auther;
}
public boolean isBorrowed() {
	return Borrowed;
}
public void setBorrowed(boolean borrowed) {
	Borrowed = borrowed;
}
public User getBorrowedBy() {
	return borrowedBy;
}
public void setBorrowedBy(User borrowedBy) {
	this.borrowedBy = borrowedBy;
}
@Override
public String toString() {
	return "Book [id=" + id + ", Title=" + Title + ", Auther=" + Auther + ", Borrowed=" + Borrowed + ", borrowedBy="
			+ borrowedBy + "]";
}
public Book(String title, String auther, boolean borrowed, User borrowedBy) {
	super();
	Title = title;
	Auther = auther;
	Borrowed = borrowed;
	this.borrowedBy = borrowedBy;
}

}

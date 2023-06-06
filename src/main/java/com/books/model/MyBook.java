package com.books.model;

import java.util.Date;
import java.util.Objects;

// @Entity
public class MyBook {

	// @Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Livro book;
	private Shelf shelf;
	private Date startRead;
	private Date endRead;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getBook() {
		return book;
	}

	public void setBook(Livro book) {
		this.book = book;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Date getStartRead() {
		return startRead;
	}

	public void setStartRead(Date startRead) {
		this.startRead = startRead;
	}

	public Date getEndRead() {
		return endRead;
	}

	public void setEndRead(Date endRead) {
		this.endRead = endRead;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyBook other = (MyBook) obj;
		return Objects.equals(book, other.book);
	}

}

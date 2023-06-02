package com.books.model;

import java.util.Date;
import java.util.Objects;

// @Entity
public class Author {

	// @Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String nationality;
	private Date born;
	private Date died;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public Date getDied() {
		return died;
	}

	public void setDied(Date died) {
		this.died = died;
	}

	@Override
	public int hashCode() {
		return Objects.hash(born, died, name, nationality);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(born, other.born) && Objects.equals(died, other.died) && Objects.equals(name, other.name)
				&& Objects.equals(nationality, other.nationality);
	}

}

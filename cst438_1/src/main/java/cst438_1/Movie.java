package cst438_1;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=20)
	private String firstName;
	private String lastName;
	private String title;
	@Min(1)
	@Max(5)
	private int rating;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date(System.currentTimeMillis());
	
	public Movie() {
		
	}
	
	public Movie(long id, String firstName, String lastName, String title, int rating) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.rating = rating;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

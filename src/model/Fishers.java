package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fishers")
public class Fishers {
	
	@Id
	@GeneratedValue
	private int id;
	private String fisherName;
	
	public Fishers() {
		super();
	}
	
	public Fishers(String fisherName) {
		super();
		this.fisherName = fisherName;
	}
	
	public Fishers(int id, String fisherName) {
		super();
		this.id = id;
		this.fisherName = fisherName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFisherName() {
		return fisherName;
	}
	public void setFisherName(String fisherName) {
		this.fisherName = fisherName;
	}

	@Override
	public String toString() {
		return "Fishers [id=" + id + ", fisherName=" + fisherName + "]";
	}

}

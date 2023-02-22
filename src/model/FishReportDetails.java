package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FishReportDetails {

	@Id
	@GeneratedValue
	private int id;
	private String reportName;
	private LocalDate reportDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Fishers fisher;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<FishWeightLocationRep> listOfFish;
	
	public FishReportDetails() {
		super();
	}
	public FishReportDetails(String reportName, LocalDate reportDate, Fishers fisher) {
		super();
		this.reportName = reportName;
		this.reportDate = reportDate;
		this.fisher = fisher;
	}
	public FishReportDetails(String reportName, LocalDate reportDate, Fishers fisher,
			List<FishWeightLocationRep> listOfFish) {
		super();
		this.reportName = reportName;
		this.reportDate = reportDate;
		this.fisher = fisher;
		this.listOfFish = listOfFish;
	}
	public FishReportDetails(int id, String reportName, LocalDate reportDate, Fishers fisher,
			List<FishWeightLocationRep> listOfFish) {
		super();
		this.id = id;
		this.reportName = reportName;
		this.reportDate = reportDate;
		this.fisher = fisher;
		this.listOfFish = listOfFish;
	}
	
	public int getId() {
		return id;	
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public LocalDate getReportDate() {
		return reportDate;
	}
	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}
	public Fishers getFisher() {
		return fisher;
	}
	public void setFisher(Fishers fisher) {
		this.fisher = fisher;
	}
	public List<FishWeightLocationRep> getListOfFish() {
		return listOfFish;
	}
	public void setListOfFish(List<FishWeightLocationRep> listOfFish) {
		this.listOfFish = listOfFish;
	}
	
	@Override
	public String toString() {
		return "FishReportDetails [id=" + id + ", reportName=" + reportName + ", reportDate=" + reportDate + ", fisher="
				+ fisher + ", listOfFish=" + listOfFish + "]";
	}
}

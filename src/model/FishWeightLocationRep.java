package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FishPopulation")
public class FishWeightLocationRep {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int dataID;
	@Column(name = "FISH")
	private String fishName;
	@Column(name = "WEIGHT")
	private String fishWeight;
	@Column(name = "RIVER")
	private String river;

	public FishWeightLocationRep() {
		super();
	}

	public FishWeightLocationRep(String fishName, String fishWeight, String river) {
		super();
		this.fishName = fishName;
		this.fishWeight = fishWeight;
		this.river = river;
	}

	public int getDataID() {
		return dataID;
	}

	public void setDataID(int dataID) {
		this.dataID = dataID;
	}

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public String getFishWeight() {
		return fishWeight;
	}

	public void setFishWeight(String fishWeight) {
		this.fishWeight = fishWeight;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public String returnReport() {
		return "Fish: " + this.fishName + ", Fish Weight: " + this.fishWeight + ", River: " + this.river;
	}

}

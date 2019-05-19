package edu.drexel.alan.bap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Bacteria")
@Table(name="bacteria")
@NamedQuery(name="Bacteria.findAll", query="SELECT b FROM Bacteria b")
public class Bacteria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bacterial_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="tax_id")
	private int taxId;

	@Column(name="lineage")
	private String lineage;
	
	@Column(name="bacteria_count")
	private int bacteriaCount;
	
	@Column(name="proportion_all")
	private double proportionAll;
	
	@Column(name="proportion_classified")
	private double proportionClassified;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTaxId() {
		return taxId;
	}
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	public String getLineage() {
		return lineage;
	}
	public void setLineage(String lineage) {
		this.lineage = lineage;
	}
	public int getBacteriaCount() {
		return bacteriaCount;
	}
	public void setBacteriaCount(int bacteriaCount) {
		this.bacteriaCount = bacteriaCount;
	}
	public double getProportionAll() {
		return proportionAll;
	}
	public void setProportionAll(double proportionAll) {
		this.proportionAll = proportionAll;
	}
	public double getProportionClassified() {
		return proportionClassified;
	}
	public void setProportionClassified(double proportionClassified) {
		this.proportionClassified = proportionClassified;
	}
	@Override
	public String toString() {
		return "Bacteria [name=" + name + ", taxId=" + taxId + ", lineage=" + lineage + ", bacteriaCount="
				+ bacteriaCount + ", proportionAll=" + proportionAll + ", proportionClassified=" + proportionClassified
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + taxId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bacteria other = (Bacteria) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (taxId != other.taxId)
			return false;
		return true;
	}

}

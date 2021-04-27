package it.polito.tdp.poweroutages.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class blackout {
	
	int id;
	int evet_id;
	int tag_id;
	int area_id;
	int nerc_id;
	int responsible_id;
	int customers_aff;
	LocalDateTime inizio ;
	LocalDateTime fine ;
	int demand_loss;
	
	long duration;
	int year;
	
	public blackout(int id, int evet_id, int tag_id, int area_id, int nerc_id, int responsible_id, int customers_aff,
			LocalDateTime inizio, LocalDateTime fine, int demand_loss) {
		super();
		this.id = id;
		this.evet_id = evet_id;
		this.tag_id = tag_id;
		this.area_id = area_id;
		this.nerc_id = nerc_id;
		this.responsible_id = responsible_id;
		this.customers_aff = customers_aff;
		this.inizio = inizio;
		this.fine = fine;
		this.demand_loss = demand_loss;
		
		LocalDateTime tmp = LocalDateTime.from(inizio);
		duration = tmp.until(fine, ChronoUnit.HOURS);
		year = tmp.getYear();
		
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEvet_id() {
		return evet_id;
	}
	public void setEvet_id(int evet_id) {
		this.evet_id = evet_id;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public int getNerc_id() {
		return nerc_id;
	}
	public void setNerc_id(int nerc_id) {
		this.nerc_id = nerc_id;
	}
	public int getResponsible_id() {
		return responsible_id;
	}
	public void setResponsible_id(int responsible_id) {
		this.responsible_id = responsible_id;
	}
	public int getCustomers_aff() {
		return customers_aff;
	}
	public void setCustomers_aff(int customers_aff) {
		this.customers_aff = customers_aff;
	}
	public LocalDateTime getInizio() {
		return inizio;
	}
	public void setInizio(LocalDateTime inizio) {
		this.inizio = inizio;
	}
	public LocalDateTime getFine() {
		return fine;
	}
	public void setFine(LocalDateTime fine) {
		this.fine = fine;
	}
	public int getDemand_loss() {
		return demand_loss;
	}
	public void setDemand_loss(int demand_loss) {
		this.demand_loss = demand_loss;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		blackout other = (blackout) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "blackout [id=" + id + ", evet_id=" + evet_id + ", tag_id=" + tag_id + ", area_id=" + area_id
				+ ", nerc_id=" + nerc_id + ", responsible_id=" + responsible_id + ", customers_aff=" + customers_aff
				+ ", inizio=" + inizio + ", fine=" + fine + ", demand_loss=" + demand_loss + "]";
	}
	
	

}

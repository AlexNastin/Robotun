package by.robotun.webapp.domain.solr;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

import by.robotun.webapp.domain.Essence;

public class LotSolr implements Essence {

	private static final long serialVersionUID = 1L;

	@Id
	@Field("id_lot")
	private int idLotSolr;

	@Field("name")
	private String name;

	@Field("id_category")
	private int idCategory;

	@Field("id_subcategory")
	private int idSubcategory;

	@Field("start_date")
	private Date startDate;

	@Field("end_date")
	private Date endDate;

	@Field("description")
	private String description;

	@Field("id_user")
	private int idUser;

	@Field("budget")
	private int budget;

	@Field("is_visible")
	private int isVisible;

	@Field("is_call")
	private boolean isCall;

	@Field("id_city")
	private int idCity;

	@Field("time_update")
	private Date timeUpdate;

	public int getIdLotSolr() {
		return idLotSolr;
	}

	public void setIdLotSolr(int idLotSolr) {
		this.idLotSolr = idLotSolr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdSubcategory() {
		return idSubcategory;
	}

	public void setIdSubcategory(int idSubcategory) {
		this.idSubcategory = idSubcategory;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}

	public boolean isCall() {
		return isCall;
	}

	public void setCall(boolean isCall) {
		this.isCall = isCall;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + budget;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + idCategory;
		result = prime * result + idCity;
		result = prime * result + idLotSolr;
		result = prime * result + idSubcategory;
		result = prime * result + idUser;
		result = prime * result + (isCall ? 1231 : 1237);
		result = prime * result + isVisible;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((timeUpdate == null) ? 0 : timeUpdate.hashCode());
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
		LotSolr other = (LotSolr) obj;
		if (budget != other.budget)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (idCategory != other.idCategory)
			return false;
		if (idCity != other.idCity)
			return false;
		if (idLotSolr != other.idLotSolr)
			return false;
		if (idSubcategory != other.idSubcategory)
			return false;
		if (idUser != other.idUser)
			return false;
		if (isCall != other.isCall)
			return false;
		if (isVisible != other.isVisible)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (timeUpdate == null) {
			if (other.timeUpdate != null)
				return false;
		} else if (!timeUpdate.equals(other.timeUpdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LotSolr [idLotSolr=" + idLotSolr + ", name=" + name + ", idCategory=" + idCategory + ", idSubcategory="
				+ idSubcategory + ", startDate=" + startDate + ", endDate=" + endDate + ", description=" + description
				+ ", idUser=" + idUser + ", budget=" + budget + ", isVisible=" + isVisible + ", isCall=" + isCall
				+ ", idCity=" + idCity + ", timeUpdate=" + timeUpdate + "]";
	}
}

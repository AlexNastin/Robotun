package by.robotun.webapp.form;

import by.robotun.webapp.domain.Essence;

public class LotFormAdd implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5361840265819238195L;
	
	private String name;
	private String endDate;
	private String description;
	private int budget;
	private int idCategory;
	private int idSubcategory;
	private boolean isCall;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getBudget() {
		return budget;
	}
	
	public void setBudget(int budget) {
		this.budget = budget;
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
	
	public boolean getIsCall() {
		return isCall;
	}

	public void setIsCall(boolean isCall) {
		this.isCall = isCall;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + budget;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + idCategory;
		result = prime * result + idSubcategory;
		result = prime * result + (isCall ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		LotFormAdd other = (LotFormAdd) obj;
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
		if (idSubcategory != other.idSubcategory)
			return false;
		if (isCall != other.isCall)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LotFormAdd [name=" + name + ", endDate=" + endDate + ", description=" + description + ", budget="
				+ budget + ", idCategory=" + idCategory + ", idSubcategory=" + idSubcategory + ", isCall=" + isCall
				+ "]";
	}

	
}

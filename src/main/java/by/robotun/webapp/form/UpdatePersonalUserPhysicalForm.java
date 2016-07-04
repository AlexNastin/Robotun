package by.robotun.webapp.form;

import java.util.Arrays;

import by.robotun.webapp.domain.Essence;

public class UpdatePersonalUserPhysicalForm implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5361840265819238195L;

	private int idCity;
	private String name;
	private String surname;
	private String middleName;
	
	// Phones
	private String[] phones;

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String[] getPhones() {
		return phones;
	}

	public void setPhones(String[] phones) {
		this.phones = phones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCity;
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(phones);
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		UpdatePersonalUserPhysicalForm other = (UpdatePersonalUserPhysicalForm) obj;
		if (idCity != other.idCity)
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(phones, other.phones))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UpdatePersonalUserPhysicalForm [idCity=" + idCity + ", name=" + name + ", surname=" + surname
				+ ", middleName=" + middleName + ", phones=" + Arrays.toString(phones) + "]";
	}

	
}

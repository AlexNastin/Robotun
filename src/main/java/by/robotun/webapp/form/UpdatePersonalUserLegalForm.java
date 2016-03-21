package by.robotun.webapp.form;

import java.util.Arrays;

import by.robotun.webapp.domain.Essence;

public class UpdatePersonalUserLegalForm implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5361840265819238195L;
	
	private int idCity;
	private String nameEnterprise;
	private String unp;
	private String address;
	private int zipCode;
	
	// Phones
	private String[] phones;

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getNameEnterprise() {
		return nameEnterprise;
	}

	public void setNameEnterprise(String nameEnterprise) {
		this.nameEnterprise = nameEnterprise;
	}

	public String getUnp() {
		return unp;
	}

	public void setUnp(String unp) {
		this.unp = unp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + idCity;
		result = prime * result + ((nameEnterprise == null) ? 0 : nameEnterprise.hashCode());
		result = prime * result + Arrays.hashCode(phones);
		result = prime * result + ((unp == null) ? 0 : unp.hashCode());
		result = prime * result + zipCode;
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
		UpdatePersonalUserLegalForm other = (UpdatePersonalUserLegalForm) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (idCity != other.idCity)
			return false;
		if (nameEnterprise == null) {
			if (other.nameEnterprise != null)
				return false;
		} else if (!nameEnterprise.equals(other.nameEnterprise))
			return false;
		if (!Arrays.equals(phones, other.phones))
			return false;
		if (unp == null) {
			if (other.unp != null)
				return false;
		} else if (!unp.equals(other.unp))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UpdatePersonalUserLegalForm [idCity=" + idCity + ", nameEnterprise=" + nameEnterprise + ", unp=" + unp
				+ ", address=" + address + ", zipCode=" + zipCode + ", phones=" + Arrays.toString(phones) + "]";
	}

	
}

package by.robotun.webapp.form;

import java.util.Arrays;

import by.robotun.webapp.domain.Essence;

public class SignupUserLegalForm implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5361840265819238195L;
	
	private String login;
	private int idCity;
	private String nameEnterprise;
	private String unp;
	private String address;
	private String zipCode;
	private String password;
	private String confirmPassword;
	
	// Phones
	private String[] phones;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + idCity;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nameEnterprise == null) ? 0 : nameEnterprise.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + Arrays.hashCode(phones);
		result = prime * result + ((unp == null) ? 0 : unp.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		SignupUserLegalForm other = (SignupUserLegalForm) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (idCity != other.idCity)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nameEnterprise == null) {
			if (other.nameEnterprise != null)
				return false;
		} else if (!nameEnterprise.equals(other.nameEnterprise))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (!Arrays.equals(phones, other.phones))
			return false;
		if (unp == null) {
			if (other.unp != null)
				return false;
		} else if (!unp.equals(other.unp))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SignupUserLegalForm [login=" + login + ", idCity=" + idCity + ", nameEnterprise=" + nameEnterprise
				+ ", unp=" + unp + ", address=" + address + ", zipCode=" + zipCode + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", phones=" + Arrays.toString(phones) + "]";
	}



	
}

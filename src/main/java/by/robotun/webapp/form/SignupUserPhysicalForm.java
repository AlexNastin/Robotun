package by.robotun.webapp.form;

import java.util.Arrays;

import by.robotun.webapp.domain.Essence;

public class SignupUserPhysicalForm implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5361840265819238195L;
	
	private String login;
	private int idCity;
	private String name;
	private String surname;
	private String middleName;
	private String password;
	private String confirmPassword;
	private boolean confirm;
	
	/**
	 * Array with user`s phones
	 */
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

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (confirm ? 1231 : 1237);
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + idCity;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		SignupUserPhysicalForm other = (SignupUserPhysicalForm) obj;
		if (confirm != other.confirm)
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "SignupUserPhysicalForm [login=" + login + ", idCity=" + idCity + ", name=" + name + ", surname="
				+ surname + ", middleName=" + middleName + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", confirm=" + confirm + ", phones=" + Arrays.toString(phones) + "]";
	}

	
}

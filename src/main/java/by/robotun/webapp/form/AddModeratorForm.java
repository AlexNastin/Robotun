package by.robotun.webapp.form;

import by.robotun.webapp.domain.Essence;

public class AddModeratorForm implements Essence {

	private static final long serialVersionUID = -5361840265819238195L;
	
	private String login;
	private int idCity;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCity;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		AddModeratorForm other = (AddModeratorForm) obj;
		if (idCity != other.idCity)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AddModeratorForm [login=" + login + ", idCity=" + idCity + "]";
	}
}

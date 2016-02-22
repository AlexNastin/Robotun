package by.robotun.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "legal")
@NamedQueries({ @NamedQuery(name = "Legal.findAll", query = "select l from Legal l") })
public class Legal implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_user")
	private int idUser;

	@Column(name = "name_enterprise")
	private String nameEnterprise;

	@Column(name = "unp")
	private String unp;

	@Column(name = "address")
	private String address;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((nameEnterprise == null) ? 0 : nameEnterprise.hashCode());
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
		Legal other = (Legal) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (idUser != other.idUser)
			return false;
		if (nameEnterprise == null) {
			if (other.nameEnterprise != null)
				return false;
		} else if (!nameEnterprise.equals(other.nameEnterprise))
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
		return "Legal [idUser=" + idUser + ", nameEnterprise=" + nameEnterprise + ", unp=" + unp + ", address="
				+ address + ", zipCode=" + zipCode + "]";
	}

	
}

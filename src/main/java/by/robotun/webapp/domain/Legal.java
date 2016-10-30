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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import by.robotun.webapp.domain.json.Views;

@Entity
@Table(name = "legal")
@NamedQueries({ @NamedQuery(name = "Legal.findAll", query = "select l from Legal l") })
public class Legal implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@JsonView(Views.Public.class)
	@Column(name = "id_legal")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLegal;

	@JsonView(Views.Public.class)
	@Column(name = "name_enterprise")
	private String nameEnterprise;

	@JsonView(Views.Public.class)
	@Column(name = "unp")
	private String unp;

	@JsonView(Views.Public.class)
	@Column(name = "address")
	private String address;

	@JsonView(Views.Public.class)
	@Column(name = "zip_code")
	private int zipCode;

	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "id_user")
	private User user;

	public int getIdLegal() {
		return idLegal;
	}

	public void setIdLegal(int idLegal) {
		this.idLegal = idLegal;
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
		result = prime * result + idLegal;
		result = prime * result + ((nameEnterprise == null) ? 0 : nameEnterprise.hashCode());
		result = prime * result + ((unp == null) ? 0 : unp.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Legal other = (Legal) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (idLegal != other.idLegal)
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Legal [idLegal=" + idLegal + ", nameEnterprise=" + nameEnterprise + ", unp=" + unp + ", address="
				+ address + ", zipCode=" + zipCode + ", user=" + user + "]";
	}

}

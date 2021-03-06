package by.robotun.webapp.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import by.robotun.webapp.domain.json.Views;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "select u from User u"),
	@NamedQuery(name = "User.findUserById", query = "select u from User u left outer join fetch u.physical left outer join fetch u.legal join fetch u.phones where u.idUser = :idUser"),
	@NamedQuery(name = "User.findUserByIdWithCity", query = "select u from User u left outer join fetch u.physical left outer join fetch u.legal join fetch u.city join fetch u.avatar where u.idUser = :idUser"),
	@NamedQuery(name = "User.findUserByLogin", query = "select u from User u left outer join fetch u.physical left outer join fetch u.legal join fetch u.avatar where u.login = :login"),
	@NamedQuery(name = "User.findAllStaffs", query = "select u from User u where idRole = :idRole"),
	@NamedQuery(name = "User.findStaffById", query = "select u from User u where u.idUser = :idUser")})
public class User implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@JsonView(Views.Public.class)
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	@JsonView(Views.InternalForListModerators.class)
	@Column(name = "login")
	private String login;

	@JsonView(Views.Public.class)
	@Column(name = "id_role")
	private int idRole;

	@JsonView(Views.Public.class)
	@Column(name = "id_city")
	private int idCity;

	@JsonView(Views.Public.class)
	@Column(name = "registration_date")
	private Date registrationDate;

	@JsonIgnore
	@Column(name = "password")
	private String password;
	
	@JsonView(Views.Public.class)
	@Column(name = "nickname")
	private String nickname;
	
	@JsonView(Views.InternalUserSubclass.class)
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Physical physical;
	
	@JsonView(Views.InternalUserSubclass.class)
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Legal legal;
	
	@JsonView({ Views.Internal.class, Views.InternalUserSubclass.class })
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Avatar avatar;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Phone> phones;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Bet> bets;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Lot> lots;
	
	@JsonView(Views.InternalUserSubclass.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_city", insertable=false, updatable=false)
	private City city;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Physical getPhysical() {
		return physical;
	}

	public void setPhysical(Physical physical) {
		this.physical = physical;
	}

	public Legal getLegal() {
		return legal;
	}

	public void setLegal(Legal legal) {
		this.legal = legal;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public List<Lot> getLots() {
		return lots;
	}

	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCity;
		result = prime * result + idRole;
		result = prime * result + idUser;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
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
		User other = (User) obj;
		if (idCity != other.idCity)
			return false;
		if (idRole != other.idRole)
			return false;
		if (idUser != other.idUser)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", idRole=" + idRole + ", idCity=" + idCity
				+ ", registrationDate=" + registrationDate + ", password=" + password + ", nickname=" + nickname + "]";
	}
	
	

	
}

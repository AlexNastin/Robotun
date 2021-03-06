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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import by.robotun.webapp.domain.json.Views;

@Entity
@Table(name = "archive_lot")
@NamedQueries({ @NamedQuery(name = "ArchiveLot.findAll", query = "select l from ArchiveLot l"),
		@NamedQuery(name = "ArchiveLot.findLotById", query = "select l from ArchiveLot l left outer join fetch l.bets as bet left outer join fetch bet.user join fetch l.city join fetch l.user where l.idArchiveLot = :id order by bet.date desc"),
		@NamedQuery(name = "ArchiveLot.findLotsCreatedUser", query = "select l from ArchiveLot l where l.idUser = :id order by l.startDate desc")})

public class ArchiveLot implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_archive_lot")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Public.class)
	private int idArchiveLot;

	@JsonProperty("name")
	@Column(name = "name")
	@JsonView(Views.Public.class)
	private String name;

	@Column(name = "id_category")
	@JsonView(Views.Public.class)
	private int idCategory;

	@Column(name = "id_subcategory")
	@JsonView(Views.Public.class)
	private int idSubcategory;

	@JsonProperty("startDate")
	@Column(name = "start_date")
	@JsonView(Views.Public.class)
	private Date startDate;

	@JsonProperty("endDate")
	@Column(name = "end_date")
	@JsonView(Views.Public.class)
	private Date endDate;

	@JsonProperty("description")
	@Column(name = "description")
	@JsonView(Views.Public.class)
	private String description;

	@Column(name = "id_user")
	@JsonView(Views.Public.class)
	private int idUser;

	@JsonProperty("budget")
	@Column(name = "budget")
	@JsonView(Views.Public.class)
	private int budget;

	@JsonProperty("isCall")
	@Column(name = "is_call")
	@JsonView(Views.Public.class)
	private boolean isCall;

	@Column(name = "id_city")
	@JsonView(Views.Public.class)
	private int idCity;
	
	@Column(name = "latitude")
	@JsonView(Views.Public.class)
	private double latitude;
	
	@Column(name = "longitude")
	@JsonView(Views.Public.class)
	private double longitude;

	@OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonView(Views.Internal.class)
	private List<ArchiveBet> bets;

	@OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonView({ Views.InternalRejectMessages.class, Views.InternalConfirmLot.class })
	private List<RejectMessage> rejectMessages;

	@JsonView({ Views.Internal.class, Views.InternalConfirmLot.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private User user;
	
	@JsonView({ Views.Internal.class, Views.InternalConfirmLot.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_city", insertable = false, updatable = false)
	private City city;

	@JsonView(Views.InternalConfirmLot.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", insertable = false, updatable = false)
	private Category category;

	@JsonView(Views.InternalConfirmLot.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_subcategory", insertable = false, updatable = false)
	private Subcategory subcategory;

	public int getIdArchiveLot() {
		return idArchiveLot;
	}

	public void setIdArchiveLot(int idArchiveLot) {
		this.idArchiveLot = idArchiveLot;
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

	public boolean getIsCall() {
		return isCall;
	}

	public void setIsCall(boolean isCall) {
		this.isCall = isCall;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<ArchiveBet> getBets() {
		return bets;
	}

	public void setBets(List<ArchiveBet> bets) {
		this.bets = bets;
	}

	public List<RejectMessage> getRejectMessages() {
		return rejectMessages;
	}

	public void setRejectMessages(List<RejectMessage> rejectMessages) {
		this.rejectMessages = rejectMessages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
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
		result = prime * result + budget;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + idArchiveLot;
		result = prime * result + idCategory;
		result = prime * result + idCity;
		result = prime * result + idSubcategory;
		result = prime * result + idUser;
		result = prime * result + (isCall ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		ArchiveLot other = (ArchiveLot) obj;
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
		if (idArchiveLot != other.idArchiveLot)
			return false;
		if (idCategory != other.idCategory)
			return false;
		if (idCity != other.idCity)
			return false;
		if (idSubcategory != other.idSubcategory)
			return false;
		if (idUser != other.idUser)
			return false;
		if (isCall != other.isCall)
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
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
		return true;
	}

	@Override
	public String toString() {
		return "ArchiveLot [idArchiveLot=" + idArchiveLot + ", name=" + name + ", idCategory=" + idCategory
				+ ", idSubcategory=" + idSubcategory + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", description=" + description + ", idUser=" + idUser + ", budget=" + budget + ", isCall=" + isCall
				+ ", idCity=" + idCity + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	
}

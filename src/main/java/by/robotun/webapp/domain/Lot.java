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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lot")
@NamedQueries({ @NamedQuery(name = "Lot.findAll", query = "select l from Lot l"),
	@NamedQuery(name = "Lot.findAllActiveLot", query = "select l from Lot l where l.endDate >= :endDate and l.isVisible = :isVisible order by startDate desc"),
	@NamedQuery(name = "Lot.findLotById", query = "select l from Lot l left outer join fetch l.bets as bet left outer join fetch bet.user join fetch l.user where l.idLot = :id order by bet.date desc"),
	@NamedQuery(name = "Lot.findLotByCategory", query = "select l from Lot l where l.idCategory = :idCategory and l.endDate >= :endDate  and l.isVisible = :isVisible order by startDate desc"),
	@NamedQuery(name = "Lot.findLotByCategoryAndSubcategory", query = "select l from Lot l where l.idCategory = :idCategory and l.idSubcategory = :idSubcategory and l.endDate >= :endDate and l.isVisible = :isVisible order by startDate desc"),
	@NamedQuery(name = "Lot.findDateLotById", query = "select l.endDate from Lot l where l.idLot = :idLot"),
	@NamedQuery(name = "Lot.findAllLotOnModeration", query = "select l from Lot l where l.isVisible = :isVisible order by startDate")})
public class Lot implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_lot")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLot;

	@Column(name = "name")
	private String name;
	
	@Column(name = "id_category")
	private int idCategory;
	
	@Column(name = "id_subcategory")
	private int idSubcategory;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "budget")
	private int budget;
	
	@Column(name = "is_visible")
	private int isVisible;
	
	@Column(name = "is_call")
	private boolean isCall;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Bet> bets;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RejectMessage> rejectMessages;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private User user;

	public int getIdLot() {
		return idLot;
	}

	public void setIdLot(int idLot) {
		this.idLot = idLot;
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

	public int getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}

	public boolean isCall() {
		return isCall;
	}

	public void setCall(boolean isCall) {
		this.isCall = isCall;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + budget;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + idCategory;
		result = prime * result + idLot;
		result = prime * result + idSubcategory;
		result = prime * result + idUser;
		result = prime * result + (isCall ? 1231 : 1237);
		result = prime * result + isVisible;
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
		Lot other = (Lot) obj;
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
		if (idLot != other.idLot)
			return false;
		if (idSubcategory != other.idSubcategory)
			return false;
		if (idUser != other.idUser)
			return false;
		if (isCall != other.isCall)
			return false;
		if (isVisible != other.isVisible)
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
		return "Lot [idLot=" + idLot + ", name=" + name + ", idCategory=" + idCategory + ", idSubcategory="
				+ idSubcategory + ", startDate=" + startDate + ", endDate=" + endDate + ", description=" + description
				+ ", idUser=" + idUser + ", budget=" + budget + ", isVisible=" + isVisible + ", isCall=" + isCall + "]";
	}

	
}

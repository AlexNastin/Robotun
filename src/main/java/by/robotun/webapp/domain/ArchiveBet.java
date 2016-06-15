package by.robotun.webapp.domain;

import java.util.Date;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import by.robotun.webapp.domain.json.Views;

@Entity
@Table(name = "archive_bet")
@NamedQueries({ @NamedQuery(name = "ArchiveBet.findAll", query = "select b from ArchiveBet b"),
	@NamedQuery(name = "ArchiveBet.findBetById", query = "select b from ArchiveBet b where b.idArchiveBet = :id"),
	@NamedQuery(name = "ArchiveBet.findCountBetByLot", query = "select count(b.idArchiveBet) from ArchiveBet b where b.idArchiveLot = :id"),
	@NamedQuery(name = "ArchiveBet.findCountBetByUserByLot", query = "select count(b.idArchiveBet) from ArchiveBet b where b.idArchiveLot = :idLot and b.idUser = :idUser")})

public class ArchiveBet implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_archive_bet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Public.class)
	private int idArchiveBet;
	
	@Column(name = "id_user")
	@JsonView(Views.Public.class)
	private int idUser;
	
	@Column(name = "id_archive_lot")
	@JsonView(Views.Public.class)
	private int idArchiveLot;

	@Column(name = "date")
	@JsonView(Views.Public.class)
	private Date date;
	
	@Column(name = "cost")
	@JsonView(Views.Public.class)
	private double cost;
	
	@JsonView(Views.Internal.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", insertable=false, updatable=false)
	private User user;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_archive_lot", insertable=false, updatable=false)
	private ArchiveLot lot;

	public int getIdArchiveBet() {
		return idArchiveBet;
	}

	public void setIdArchiveBet(int idArchiveBet) {
		this.idArchiveBet = idArchiveBet;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdArchiveLot() {
		return idArchiveLot;
	}

	public void setIdArchiveLot(int idArchiveLot) {
		this.idArchiveLot = idArchiveLot;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArchiveLot getLot() {
		return lot;
	}

	public void setLot(ArchiveLot lot) {
		this.lot = lot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + idArchiveBet;
		result = prime * result + idArchiveLot;
		result = prime * result + idUser;
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
		ArchiveBet other = (ArchiveBet) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idArchiveBet != other.idArchiveBet)
			return false;
		if (idArchiveLot != other.idArchiveLot)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArchiveBet [idArchiveBet=" + idArchiveBet + ", idUser=" + idUser + ", idArchiveLot=" + idArchiveLot + ", date=" + date + ", cost=" + cost
				+ "]";
	}
	
	
}

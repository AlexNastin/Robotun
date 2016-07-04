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
@Table(name = "bet")
@NamedQueries({ @NamedQuery(name = "Bet.findAll", query = "select b from Bet b"),
	@NamedQuery(name = "Bet.findBetById", query = "select b from Bet b where b.idBet = :id"),
	@NamedQuery(name = "Bet.findCountBetByLot", query = "select count(b.idBet) from Bet b where b.idLot = :id"),
	@NamedQuery(name = "Bet.findCountBetByUserByLot", query = "select count(b.idBet) from Bet b where b.idLot = :idLot and b.idUser = :idUser")})

public class Bet implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_bet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Public.class)
	private int idBet;
	
	@Column(name = "id_user")
	@JsonView(Views.Public.class)
	private int idUser;
	
	@Column(name = "id_lot")
	@JsonView(Views.Public.class)
	private int idLot;

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
	@JoinColumn(name = "id_lot", insertable=false, updatable=false)
	private Lot lot;

	public int getIdBet() {
		return idBet;
	}

	public void setIdBet(int idBet) {
		this.idBet = idBet;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdLot() {
		return idLot;
	}

	public void setIdLot(int idLot) {
		this.idLot = idLot;
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

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
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
		result = prime * result + idBet;
		result = prime * result + idLot;
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
		Bet other = (Bet) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idBet != other.idBet)
			return false;
		if (idLot != other.idLot)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bet [idBet=" + idBet + ", idUser=" + idUser + ", idLot=" + idLot + ", date=" + date + ", cost=" + cost
				+ "]";
	}
	
	
}

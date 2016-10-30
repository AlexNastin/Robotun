package by.robotun.webapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "password_reset_token")

@NamedQueries({ @NamedQuery(name = "PasswordResetToken.findAll", query = "select p from PasswordResetToken p"),
		@NamedQuery(name = "PasswordResetToken.findTokenByUser", query = "select p from PasswordResetToken p where p.idUser = :idUser"),
		@NamedQuery(name = "PasswordResetToken.findTokenByToken", query = "select p from PasswordResetToken p where p.token = :token") })
public class PasswordResetToken implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7955005647844576256L;

	@Id
	@Column(name = "id_token")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idToken;

	@Column(name = "id_user")
	private int idUser;

	@Column(name = "token")
	private String token;

	@Column(name = "expiry_date")
	private Date expiryDate;

	public PasswordResetToken() {
		super();
	}

	public int getIdToken() {
		return idToken;
	}

	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + idToken;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		PasswordResetToken other = (PasswordResetToken) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (idToken != other.idToken)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PasswordResetToken [idToken=" + idToken + ", idUser=" + idUser + ", token=" + token + ", expiryDate="
				+ expiryDate + "]";
	}

}
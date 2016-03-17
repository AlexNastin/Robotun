package by.robotun.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "reject_message")
@NamedQueries({ @NamedQuery(name = "RejectMessage.findAll", query = "select r from RejectMessage r")})
public class RejectMessage implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_reject_message")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRejectMessage;

	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "id_lot")
	private int idLot;
	
	@Column(name = "message")
	private String message;

	public int getIdRejectMessage() {
		return idRejectMessage;
	}

	public void setIdRejectMessage(int idRejectMessage) {
		this.idRejectMessage = idRejectMessage;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLot;
		result = prime * result + idRejectMessage;
		result = prime * result + idUser;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		RejectMessage other = (RejectMessage) obj;
		if (idLot != other.idLot)
			return false;
		if (idRejectMessage != other.idRejectMessage)
			return false;
		if (idUser != other.idUser)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RejectMessage [idRejectMessage=" + idRejectMessage + ", idUser=" + idUser + ", idLot=" + idLot
				+ ", message=" + message + "]";
	}
	
	
}

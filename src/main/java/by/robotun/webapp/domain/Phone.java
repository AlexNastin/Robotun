package by.robotun.webapp.domain;

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

@Entity
@Table(name = "phone")
@NamedQueries({ @NamedQuery(name = "Phone.findAll", query = "select p from Phone p") })
public class Phone implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_phone")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPhone;
	
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "id_operator")
	private int idOperator;

	@Column(name = "title")
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private User user;

	public int getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdOperator() {
		return idOperator;
	}

	public void setIdOperator(int idOperator) {
		this.idOperator = idOperator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		result = prime * result + idOperator;
		result = prime * result + idPhone;
		result = prime * result + idUser;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Phone other = (Phone) obj;
		if (idOperator != other.idOperator)
			return false;
		if (idPhone != other.idPhone)
			return false;
		if (idUser != other.idUser)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phone [idPhone=" + idPhone + ", idUser=" + idUser + ", idOperator=" + idOperator + ", title=" + title
				+ "]";
	}

	
}

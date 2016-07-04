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
@Table(name = "operator")
@NamedQueries({ @NamedQuery(name = "Operator.findAll", query = "select o from Operator o") })
public class Operator implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4330683445782244458L;

	@Id
	@Column(name = "id_operator")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperator;

	@Column(name = "name")
	private String name;

	public int getIdOperator() {
		return idOperator;
	}

	public void setIdOperator(int idOperator) {
		this.idOperator = idOperator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOperator;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Operator other = (Operator) obj;
		if (idOperator != other.idOperator)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operator [idOperator=" + idOperator + ", name=" + name + "]";
	}

	
}

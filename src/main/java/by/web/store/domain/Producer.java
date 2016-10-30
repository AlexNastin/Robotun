package by.web.store.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "producer")
@NamedQueries({ @NamedQuery(name = "Producer.findAll", query = "select p from Producer p") })
public class Producer implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_producer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducer;

	@Column(name = "name")
	private String name;

	public int getIdProducer() {
		return idProducer;
	}

	public void setIdProducer(int idProducer) {
		this.idProducer = idProducer;
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
		result = prime * result + idProducer;
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
		Producer other = (Producer) obj;
		if (idProducer != other.idProducer)
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
		return "Producer [idProducer=" + idProducer + ", name=" + name + "]";
	}

}

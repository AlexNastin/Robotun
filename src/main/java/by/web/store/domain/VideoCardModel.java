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
@Table(name = "video_card_model")
@NamedQueries({ @NamedQuery(name = "VideoCardModel.findAll", query = "select v from VideoCardModel v") })
public class VideoCardModel implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_video_card_model")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVideoCardModel;

	@Column(name = "name")
	private String name;

	public int getIdVideoCardModel() {
		return idVideoCardModel;
	}

	public void setIdVideoCardModel(int idVideoCardModel) {
		this.idVideoCardModel = idVideoCardModel;
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
		result = prime * result + idVideoCardModel;
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
		VideoCardModel other = (VideoCardModel) obj;
		if (idVideoCardModel != other.idVideoCardModel)
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
		return "VideoCardModel [idVideoCardModel=" + idVideoCardModel + ", name=" + name + "]";
	}

	
}

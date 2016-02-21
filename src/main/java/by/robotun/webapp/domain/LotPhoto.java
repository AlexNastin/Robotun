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
@Table(name = "lot_photo")
@NamedQueries({ @NamedQuery(name = "LotPhoto.findAll", query = "select l from LotPhoto l") })
public class LotPhoto implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_lot_photo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLotPhoto;

	@Column(name = "path")
	private String path;

	public int getIdLotPhoto() {
		return idLotPhoto;
	}

	public void setIdLotPhoto(int idLotPhoto) {
		this.idLotPhoto = idLotPhoto;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLotPhoto;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		LotPhoto other = (LotPhoto) obj;
		if (idLotPhoto != other.idLotPhoto)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LotPhoto [idLotPhoto=" + idLotPhoto + ", path=" + path + "]";
	}

	
}

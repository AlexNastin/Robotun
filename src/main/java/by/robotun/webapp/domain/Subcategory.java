package by.robotun.webapp.domain;

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
@Table(name = "subcategory")
@NamedQueries({ @NamedQuery(name = "Subcategory.findAll", query = "select s from Subcategory s"),
	 @NamedQuery(name = "Subcategory.findAllByIdCategory", query = "select s from Subcategory s where s.idCategory = :idCategory")})
public class Subcategory implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_subcategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubcategory;
	
	@Column(name = "id_category")
	private int idCategory;

	@Column(name = "title")
	private String title;
	
	@JsonIgnore
	@JoinColumn(name = "id_category", referencedColumnName = "id_category", insertable=false, updatable=false)
	@ManyToOne(optional = false)
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Lot> lots;

	public int getIdSubcategory() {
		return idSubcategory;
	}

	public void setIdSubcategory(int idSubcategory) {
		this.idSubcategory = idSubcategory;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Lot> getLots() {
		return lots;
	}

	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCategory;
		result = prime * result + idSubcategory;
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
		Subcategory other = (Subcategory) obj;
		if (idCategory != other.idCategory)
			return false;
		if (idSubcategory != other.idSubcategory)
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
		return "Subcategory [idSubcategory=" + idSubcategory + ", idCategory=" + idCategory + ", title=" + title + "]";
	}

	
}

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
@Table(name = "product")
@NamedQueries({ @NamedQuery(name = "Product.findAll", query = "select p from Product p") })
public class Product implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	@Column(name = "id_producer")
	private int idProducer;
	
	@Column(name = "id_cpu")
	private int idCpu;
	
	@Column(name = "id_ram")
	private int idRam;
	
	@Column(name = "id_video_card_type")
	private int idVideoCardType;
	
	@Column(name = "id_video_card_model")
	private int idVideoCardModel;
	
	@Column(name = "id_os")
	private int idOs;
	
	@Column(name = "id_color")
	private int idColor;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "core")
	private int core;
	
	@Column(name = "frequency")
	private double frequency;
	
	@Column(name = "ramValue")
	private int ramValue;
	
	@Column(name = "path")
	private String path;

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdProducer() {
		return idProducer;
	}

	public void setIdProducer(int idProducer) {
		this.idProducer = idProducer;
	}

	public int getIdCpu() {
		return idCpu;
	}

	public void setIdCpu(int idCpu) {
		this.idCpu = idCpu;
	}

	public int getIdRam() {
		return idRam;
	}

	public void setIdRam(int idRam) {
		this.idRam = idRam;
	}

	public int getIdVideoCardType() {
		return idVideoCardType;
	}

	public void setIdVideoCardType(int idVideoCardType) {
		this.idVideoCardType = idVideoCardType;
	}

	public int getIdVideoCardModel() {
		return idVideoCardModel;
	}

	public void setIdVideoCardModel(int idVideoCardModel) {
		this.idVideoCardModel = idVideoCardModel;
	}

	public int getIdOs() {
		return idOs;
	}

	public void setIdOs(int idOs) {
		this.idOs = idOs;
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCore() {
		return core;
	}

	public void setCore(int core) {
		this.core = core;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public int getRamValue() {
		return ramValue;
	}

	public void setRamValue(int ramValue) {
		this.ramValue = ramValue;
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
		result = prime * result + core;
		long temp;
		temp = Double.doubleToLongBits(frequency);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idColor;
		result = prime * result + idCpu;
		result = prime * result + idOs;
		result = prime * result + idProducer;
		result = prime * result + idProduct;
		result = prime * result + idRam;
		result = prime * result + idVideoCardModel;
		result = prime * result + idVideoCardType;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ramValue;
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
		Product other = (Product) obj;
		if (core != other.core)
			return false;
		if (Double.doubleToLongBits(frequency) != Double.doubleToLongBits(other.frequency))
			return false;
		if (idColor != other.idColor)
			return false;
		if (idCpu != other.idCpu)
			return false;
		if (idOs != other.idOs)
			return false;
		if (idProducer != other.idProducer)
			return false;
		if (idProduct != other.idProduct)
			return false;
		if (idRam != other.idRam)
			return false;
		if (idVideoCardModel != other.idVideoCardModel)
			return false;
		if (idVideoCardType != other.idVideoCardType)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (ramValue != other.ramValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", idProducer=" + idProducer + ", idCpu=" + idCpu + ", idRam="
				+ idRam + ", idVideoCardType=" + idVideoCardType + ", idVideoCardModel=" + idVideoCardModel + ", idOs="
				+ idOs + ", idColor=" + idColor + ", price=" + price + ", core=" + core + ", frequency=" + frequency
				+ ", ramValue=" + ramValue + ", path=" + path + "]";
	}
}

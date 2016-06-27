package by.robotun.webapp.form;

import by.robotun.webapp.domain.Essence;

public class RejectMessageForm implements Essence {

	private static final long serialVersionUID = 5181462478030150576L;

	private String text;
	
	private int idLot;
	

	public RejectMessageForm() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIdLot() {
		return idLot;
	}

	public void setIdLot(int idLot) {
		this.idLot = idLot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLot;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		RejectMessageForm other = (RejectMessageForm) obj;
		if (idLot != other.idLot)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RejectMessageForm [text=" + text + ", idLot=" + idLot + "]";
	}

	

	
}

package it.polito.tdp.extflightdelays.model;

import java.util.Objects;

public class CoppiaA {

	private Airport partenza;
	private Airport destinazione;
	private double distanza;
	
	public CoppiaA(Airport partenza, Airport destinazione, double distanza) {
		super();
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.distanza = distanza;
	}

	
	/**
	 * @return the partenza
	 */
	public Airport getPartenza() {
		return partenza;
	}

	/**
	 * @param partenza the partenza to set
	 */
	public void setPartenza(Airport partenza) {
		this.partenza = partenza;
	}

	/**
	 * @return the destinazione
	 */
	public Airport getDestinazione() {
		return destinazione;
	}

	/**
	 * @param destinazione the destinazione to set
	 */
	public void setDestinazione(Airport destinazione) {
		this.destinazione = destinazione;
	}

	/**
	 * @return the distanza
	 */
	public double getDistanza() {
		return distanza;
	}

	/**
	 * @param distanza the distanza to set
	 */
	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destinazione, partenza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoppiaA other = (CoppiaA) obj;
		return Objects.equals(destinazione, other.destinazione) && Objects.equals(partenza, other.partenza);
	}
	
}

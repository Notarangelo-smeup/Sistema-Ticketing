package org.fondazionejac.architetturasw.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Software")
public class TicketSoftware extends BaseTicket implements Ticket  {

	@Column (name= "gravita")
	private String gravita;
	
	@Column (name = "bloccante")
	private boolean bloccante;
	
	@Column (name = "area")
	private String areaSoftware;

	public TicketSoftware() {
	};

	@Override
	public String tipoticket() {
		return "Ticket MalfunzionamentoSoftware";
	}
	
	public String getGravita() {
		return gravita;
	}

	public void setGravita(String gravita) {
		this.gravita = gravita;
	}

	public String getAreaSoftware() {
		return areaSoftware;
	}	

	public void setAreaSoftware(String areaSoftware) {
		this.areaSoftware = areaSoftware;
	}

	@Override
	public String toString() {
		return "TicketSoftware [gravita=" + gravita + ", bloccante=" + bloccante + ", areaSoftware=" + areaSoftware
				+ ","  + super.toString() ;
	}

	
}

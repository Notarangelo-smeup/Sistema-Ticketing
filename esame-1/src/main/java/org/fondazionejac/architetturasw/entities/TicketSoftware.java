package org.fondazionejac.architetturasw.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Software")
@Inheritance(strategy = InheritanceType.JOINED)
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
}

package org.fondazionejac.architetturasw.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Generico")
@Inheritance(strategy = InheritanceType.JOINED)
public class TicketGenerico extends BaseTicket implements Ticket {

	
	private String reparto;

	public TicketGenerico() {
	};

	@Override
	public String tipoticket() {
		return "Ticket generico";
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

}

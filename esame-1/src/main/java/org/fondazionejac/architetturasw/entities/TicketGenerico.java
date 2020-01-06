package org.fondazionejac.architetturasw.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TicketGenerico extends BaseTicket implements Ticket {

	@Column(name="reparto")
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

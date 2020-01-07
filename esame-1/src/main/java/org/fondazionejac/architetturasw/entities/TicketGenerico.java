package org.fondazionejac.architetturasw.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component(value="generico")
@Entity
@DiscriminatorColumn(name="tipo")
@DiscriminatorValue(value="Generico")
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

	@Override
	public String toString() {
		return "TicketGenerico [reparto=" + reparto + ", " + super.toString() + "]";
	}

	
	
}

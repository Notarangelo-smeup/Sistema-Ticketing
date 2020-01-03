package org.fondazionejac.architetturasw.entities;

import java.util.Date;

public class TicketGenerico extends Ticket {
	
	private String campoappartenenza;
	private String reparto;
	public TicketGenerico(String titolo, String descrizione, Date data,String campoappartenenza,String reparto) {
		super(titolo, descrizione, data);
		this.campoappartenenza=campoappartenenza;
		this.reparto=reparto;
		// TODO Auto-generated constructor stub
	}
	public String getCampoappartenenza() {
		return campoappartenenza;
	}
	public void setCampoappartenenza(String campoappartenenza) {
		this.campoappartenenza = campoappartenenza;
	}
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	@Override
	public String toString() {
		return "TicketGenerico [campoappartenenza=" + campoappartenenza + ", reparto=" + reparto + ", toString()="
				+ super.toString() + "]";
	}
	

}

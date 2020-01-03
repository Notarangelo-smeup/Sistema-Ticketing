package org.fondazionejac.architetturasw.entities;

import java.util.Date;

public class TicketSoftware extends Ticket {
	
	private String gravita;
	private String areaSoftware;
	
	
	public TicketSoftware(String titolo, String descrizione, Date data,String gravita,String areaSoftware) {
		super(titolo, descrizione, data);
		this.gravita=gravita;
		this.areaSoftware=areaSoftware;
		
		
		// TODO Auto-generated constructor stub
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
		return "TicketSoftware [gravita=" + gravita + ", areaSoftware=" + areaSoftware + ", toString()="
				+ super.toString() + "]";
	}
	

}

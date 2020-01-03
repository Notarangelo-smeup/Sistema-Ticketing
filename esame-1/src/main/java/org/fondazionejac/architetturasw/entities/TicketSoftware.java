package org.fondazionejac.architetturasw.entities;

import java.util.Date;

public class TicketSoftware implements Ticket {
	private String titolo;
	private String descrizione;
    private Date data;
	private String gravita;
	private String areaSoftware;
	
	public TicketSoftware() {};
	public TicketSoftware(String titolo, String descrizione, Date data,String gravita,String areaSoftware) {
	    this.titolo=titolo;
	    this.descrizione=descrizione;
	    this.data=data;
		this.gravita=gravita;
		this.areaSoftware=areaSoftware;
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String tipoticket()
	{
		return "Ticket MalfunzionamentoSoftware";
	}
	
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
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
		return "TicketSoftware [titolo=" + titolo + ", descrizione=" + descrizione + ", data=" + data + ", gravita="
				+ gravita + ", areaSoftware=" + areaSoftware + "]";
	}


	
}

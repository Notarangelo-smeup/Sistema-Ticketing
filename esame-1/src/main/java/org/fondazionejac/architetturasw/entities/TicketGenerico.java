package org.fondazionejac.architetturasw.entities;

import java.util.Date;

public class TicketGenerico implements Ticket {
	private String titolo;
	private String descrizione;
    private Date data;
	private String campoappartenenza;
	private String reparto;
	
	public TicketGenerico(String titolo, String descrizione, Date data,String campoappartenenza,String reparto) {
		this.titolo=titolo;
		this.descrizione=descrizione;
		this.data=data;
		this.campoappartenenza=campoappartenenza;
		this.reparto=reparto;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String tipoticket()
	{
		return "Ticket generico";
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
		return "TicketGenerico [titolo=" + titolo + ", descrizione=" + descrizione + ", data=" + data
				+ ", campoappartenenza=" + campoappartenenza + ", reparto=" + reparto + "]";
	}


}

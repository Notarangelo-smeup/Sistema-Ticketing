package org.fondazionejac.architetturasw.entities;

import java.util.Date;

public abstract class Ticket {
  private String titolo;
  private String Descrizione;
   private Date data;
	public Ticket()
	{
		
	}
	public Ticket(String titolo, String descrizione, Date data) {
		
		this.titolo = titolo;
		Descrizione = descrizione;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Ticket [titolo=" + titolo + ", Descrizione=" + Descrizione + ", data=" + data + "]";
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}

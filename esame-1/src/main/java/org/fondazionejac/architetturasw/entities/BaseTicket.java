package org.fondazionejac.architetturasw.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Ticket")
public class BaseTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;
	
	@Column(name= "cliente", updatable= false)
	private String cliente;

	@Column(name= "oggetto")
	private String oggetto;
	
	@Column(name= "descrizione")
	private String descrizione;
    
	@Column(name = "creation_time", updatable= false)
	private Date creationTime;
	
	@Column(name = "creation_user", updatable= false)
	private String creationUser;
	
	@Column(name= "dtype", insertable = false, updatable = false )
	private String dtype;
	
	/**
	 * @return the id
	 */
		
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the oggetto
	 */
	public String getOggetto() {
		return oggetto;
	}

	/**
	 * @param oggetto the oggetto to set
	 */
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the creationUser
	 */
	
	
	public String getCreationUser() {
		return creationUser;
	}

	/**
	 * @param creationUser the creationUser to set
	 */
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	
	
	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	 
	

	/**
	 * @return the dtype
	 */
	public String getDtype() {
		return dtype;
	}

	/**
	 * @param dtype the dtype to set
	 */
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	@Override
	public String toString() {
		return "BaseTicket [id=" + id + ", oggetto=" + oggetto + ", cliente=" + cliente + ", descrizione=" + descrizione + ", creationTime="
				 + creationTime + ", creationUser=" + creationUser +"]";
	}
	
}



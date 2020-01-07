package org.fondazionejac.architetturasw.entities;

public class TicketFactory {
	
	public TicketFactory()
	{
		
	}

	   public BaseTicket getTicket (String type){
		   
		   if(type.equals("Generico"))return new TicketGenerico();		   
	        
	        return new TicketSoftware();
	    }
}

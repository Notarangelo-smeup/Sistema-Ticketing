package org.fondazionejac.architetturasw.entities;

import java.util.Date;
import java.util.Scanner;

public class TicketFactory {
	
	public TicketFactory()
	{
		
	}

	   public Ticket getTicket (TicketEnum type){
		   Scanner in = new Scanner(System.in);
	        Ticket retval = null;
	        switch (type){
	            case Generico:
	            	System.out.print("Inserire titolo ticket: ");
	        		String titolo=in.nextLine();

	        		System.out.print("Inserire descrizione ticket: ");
	        		String descrizione=in.nextLine();

	        		System.out.print("Inserire campoappartenenza ticket: ");
	        		String campoappartenenza=in.nextLine();

	        		System.out.print("Inserire reparto ticket: ");
	        		String reparto=in.nextLine();
	            	Date data = new Date();
	                retval = new TicketGenerico();
	                break;
	            case Software:
	            	System.out.print("Inserire titolo ticket: ");
	        		String titolo1=in.nextLine();

	        		System.out.print("Inserire descrizione ticket: ");
	        		String descrizione1=in.nextLine();

	        		System.out.print("Inserire gravita ticket: ");
	        		String gravita=in.nextLine();

	        		System.out.print("Inserire areasoftware ticket: ");
	        		String areasoftware=in.nextLine();
	            	Date data1 = new Date();
	                retval = new TicketSoftware();
	                break;
	        }
	        return retval;
	    }
}

package org.fondazionejac.architetturasw;

import java.util.List;

import org.fondazionejac.architetturasw.dao.TicketDao;
import org.fondazionejac.architetturasw.entities.BaseTicket;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DataController {
	
@RequestMapping(value="/lista2" ,method= RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
	
	public  List <BaseTicket> stampaTicket() {

	TicketDao dao = new TicketDao();
		
		
		List<BaseTicket> tickets = dao.findAll();
		  return tickets;
		
	}



}

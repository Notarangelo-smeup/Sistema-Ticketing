package org.fondazionejac.architetturasw.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.fondazionejac.architetturasw.entities.BaseTicket;
import org.fondazionejac.architetturasw.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


@Transactional
public class TicketDao {
		
	public void creaTicket(BaseTicket ticket) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			
			ticket.setCreationTime(new Date());
			ticket.setCreationUser("Default");
			session.save(ticket);
			
			tx.commit();
		}
	}
		

		
		
	}



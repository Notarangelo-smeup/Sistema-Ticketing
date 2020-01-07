package org.fondazionejac.architetturasw.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.fondazionejac.architetturasw.entities.BaseTicket;
import org.fondazionejac.architetturasw.entities.TicketFactory;
import org.fondazionejac.architetturasw.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

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
	
	public List<BaseTicket> findAll() {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					
			NativeQuery<BaseTicket> query = session.createNativeQuery("select * from ticket", BaseTicket.class);			
			List<BaseTicket> list = query.list();		
			
			return list;
		}		
	}
	
	public BaseTicket findById(int id){		
		
		BaseTicket bt = new TicketFactory().getTicket(findType(id));
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {	
			
			bt = session.find(bt.getClass(), id);
			if(bt.getId() > 0) System.out.println("Selected Record " + id);
		}		
		
		return bt;
	}
	
	public String findType(int id) {
		
		String dtype;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
			NativeQuery query = session.createNativeQuery("select dtype from ticket where id = " + id);
			
			dtype = (String) query.getSingleResult();
		}
		
		return dtype;
	}
	
	public void update(BaseTicket ticket) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {			

			session.beginTransaction();
			session.update(ticket);
			session.getTransaction().commit();
			session.close();
			
		}
	}
		
}



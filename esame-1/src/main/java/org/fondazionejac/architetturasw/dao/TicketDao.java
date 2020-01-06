package org.fondazionejac.architetturasw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.fondazionejac.architetturasw.entities.BaseTicket;
import org.fondazionejac.architetturasw.entities.TicketGenerico;
import org.fondazionejac.architetturasw.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


@Transactional
public class TicketDao {

    @Autowired
    protected SessionFactory sessionFactory;

   
	
    
	
		public Connection getConnection() throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/gestionale?serverTimezone=UTC", "root", "");
		}

		public boolean testConnessione() {

			Connection connection = null;
			try {

				connection = getConnection();

				return (connection != null);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {

				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {

						// non faccio nulla in questo caso
					}
				}
			}

			return false;
		}

		public List<BaseTicket> findAll() {
			
			List<BaseTicket> result = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT *");
			sql.append(" FROM TICKET");
					
			Connection connection = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				connection = getConnection();
				
				pstm = connection.prepareStatement(sql.toString());
				
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					
					BaseTicket ticket = new TicketGenerico();
					
					ticket.setId(rs.getInt("ID"));
					
					result.add(ticket);
				}
				
			} catch(SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
				
			} finally {
				
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// non faccio nulla
					}
				}			
				
				if (pstm != null) {
					try {
						pstm.close();
					} catch (SQLException e) {
						// non faccio nulla
					}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// non faccio nulla
					}
				}
			}
			
			return result;
			
		}
		
		public void creaTicket(BaseTicket ticket) {
			
			System.out.print("try to save item " + ticket);
			
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {

				Transaction tx = session.beginTransaction();
				try {

					System.out.println("salvando");
					session.persist(ticket);
					tx.commit();
					
					
				} catch(Exception e) {
					
					tx.rollback();
				}
			}	
			
		}
		
		public void eliminaDocumento(BaseTicket ticket) {
			
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
				Transaction tx = session.beginTransaction();
				
				session.delete(ticket);
				
				tx.commit();
			}
		}

		public BaseTicket findById(Integer id) {

			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
				return session.get(BaseTicket.class, id);
			}
		}
		
		
	}



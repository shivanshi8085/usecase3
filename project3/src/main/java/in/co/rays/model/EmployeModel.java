package in.co.rays.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.EmployeDto;

public class EmployeModel {
	
	public void add(EmployeDto dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx= session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
		
	}
	
	public void update(EmployeDto dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session= sf.openSession();
		Transaction tx= session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();
	}
	
	public void delete(EmployeDto dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session= sf.openSession();
		Transaction tx= session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
		
		
	}
	
	public EmployeDto findByPk(int id) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		EmployeDto dto=(EmployeDto) session.get(EmployeDto.class, id);
		
		session.close();
		return dto;
		
	}
	
	
	
	
	
	
	

}

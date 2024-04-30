package in.co.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.dto.ProgressDto;

public class ProgressModel {
	
	public void add(ProgressDto dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
		
	}
	
	public void update(ProgressDto dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();

	}
	
	public void delete(ProgressDto dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
	}
	
	public ProgressDto findByPK(int id) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
        ProgressDto dto =  (ProgressDto) session.get(ProgressDto.class, id);
        
        session.close();
		
		
		return dto;
		
		
	}
	
	
	public List search(ProgressDto dto, int pageNo,int pageSize) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(ProgressDto.class);
		
		if(dto!=null) {
			
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getId() !=0 && dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));	
				}
			
		}
		
		 if (pageSize > 0) { 
			  pageNo = (pageNo - 1) * pageSize;
		      criteria.setFirstResult(pageNo); 
		      criteria.setMaxResults(pageSize);
		      } 
		 
		List list = criteria.list();

		session.close();
		
		return list;
		
		
	}

}

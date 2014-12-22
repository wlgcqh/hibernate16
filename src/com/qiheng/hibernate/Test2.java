package com.qiheng.hibernate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test2 {
	public static SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Student student = null;

		
		try{
			tx = session.beginTransaction();
//			Query query = session.createQuery("select s.student_name,s.timestamp from Student as s");
//			Iterator iter = query.iterate();
//			while(iter.hasNext()){
//				
//				Object[] obj = (Object[]) iter.next();
//				System.out.println(obj[0]+","+obj[1]);
//			}
			
			Query query = session.createQuery("select new Course(c.course_name,c.credit) from Course c");

			List<Course> list = query.list();
			for(Course course:list){
				System.out.println(course.getId());
				System.out.println(course.getCourse_name());
				System.out.println(course.getCredit());
				System.out.println(course.getStudents());
				System.out.println(course.getClass());
			}
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		
		
		}finally{
			session.close();
		}
		
	}
}


package com.pack;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration().configure();//reads cfg file
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();//acts as an interface between java appl and hibernate
		Transaction t=null;
		try{
			t=s.beginTransaction();
			Employee e1=new Employee();
			e1.setName("dikshajaiswal");
			Address a=new Address();
			a.setAddress("unitech");
			a.setCountry("India");
			e1.setAddress(a);//since each employee has 1 address
			s.save(e1);//since address has cascade property .once employee is saved ,address will be saved automatically
			
			t.commit();
			System.out.println("success");
			
		}
		catch(HibernateException ex){
			System.err.println(ex);
			t.rollback();
			
		}
		finally{
			s.close();
		}
	
	}

}

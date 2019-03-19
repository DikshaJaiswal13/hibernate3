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
		AnnotationConfiguration cfg=(AnnotationConfiguration) new AnnotationConfiguration().configure();//reads cfg file
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();//acts as an interface between java appl and hibernate
		Transaction t=null;
		try{
			t=s.beginTransaction();
			Student s1=new Student();
			s1.setStudentid(111);
			s1.setStudentname("diksha");
			s1.setGroup("qqwq");
			Address a=new Address();
			a.setAddressid(333);
			a.setPlace("kol");
			a.setStudent(s1);
			s.save(a);
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

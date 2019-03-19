package com.pack;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
			Vendor v=new Vendor();
			v.setVendorid(111);
			v.setVname("qwerty");
			Customer c1=new Customer();
			c1.setId(222);
			c1.setName("tom");
			Customer c2=new Customer();
			c1.setId(333);
			c1.setName("tomy");
			Set s1=new HashSet();
			s1.add(c1);
			s1.add(c2);
			v.setCustomer(s1);
			s.save(v);
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

package study;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibernateDAO1 {
	Session session=null;
	public static Session getSession()
	{

		//Reading the hibernate.cfg.xml from classpath
				StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
				//Create MetadataSources
				MetadataSources sources=new MetadataSources(registry);
				//create Metadata
				Metadata metadata=sources.getMetadataBuilder().build();
				//
				org.hibernate.SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
				
				Session session=sessionFactory.openSession();//Start transaction
				
				return session;
	}
	public  void addStudent(int roll,String name)
	{
		session=getSession();
		session.beginTransaction();
		StudentEntity s=new StudentEntity(roll,name);
		session.save(s);

		session.getTransaction().commit();
		session.close();
	}
	public StudentEntity update(int id,String name)
	{
		session=getSession();
		session.beginTransaction();
		StudentEntity s=session.find(StudentEntity.class, id);
		if(s!=null)
		{
			System.out.println(name);
			s.setName(name);
			return s;
			//System.out.println(s);
		}
		else
		{
			System.out.println("no such entry in table");
			
		}
		session.getTransaction().commit();
		session.close();
	return null;

	}
	public void delete(int id)
	{
		session=getSession();
		session.beginTransaction();
		StudentEntity s=session.find(StudentEntity.class, id);
		if(s!=null)
		{
			session.delete(s);
			System.out.println("deleted");
		}
		else
		{
			System.out.println("no such entry in table");
		}
		session.getTransaction().commit();
		session.close();

	}
	public StudentEntity search(int id)
	{
		session=getSession();
		session.beginTransaction();
		StudentEntity s=session.find(StudentEntity.class, id);
		if(s!=null)
		{
			System.out.println("inside search to return s");
			return s;
			//System.out.println(s);
		}
		else
		{
			System.out.println("no such entry in table");
			
		}
		session.getTransaction().commit();
		session.close();
	return null;

	}
	
}

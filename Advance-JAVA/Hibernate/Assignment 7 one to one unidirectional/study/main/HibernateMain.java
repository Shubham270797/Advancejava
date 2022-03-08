package study.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import study.pojo.Address;
import study.pojo.Employee;



public class HibernateMain {
public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		Session session=getSession();
		add(session,sc);
		session.close();
		//update(session);
	
		
	}
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
				System.out.println("connection done");
		return session;
	}
	public static void add(Session session,Scanner sc)
	{
		session.beginTransaction();
		
		while(true)
		{
			System.out.println("Enter employee name and if you want to stop enter quit");
			String name=sc.next();
			if(name.equalsIgnoreCase("quit"))
			{
				System.out.println("addition method stopped");
				break;
			}
			System.out.println("Enter employee emailID");
			String email=sc.next();
			//employee class
			Employee emp=new Employee();
			emp.setEname(name);
			emp.setEmail(email);
			
			//address class
			Address add=new Address();
			System.out.println("Enter address line");
			String Line=sc.next();
			add.setAddressLine1(Line);
			System.out.println("Enter the city");
			String city=sc.next();
			add.setCity(city);
			System.out.println("Enter the state");
			String state=sc.next();
			add.setState(state);
			System.out.println("Enter the country");
			String country=sc.next();
			add.setCountry(country);
			System.out.println("Enter the pincode");
			int pincode=sc.nextInt();
			add.setPincode(pincode);
			
			emp.setAddress(add);
			session.save(emp);

		}
		
		
		System.out.println("inserted in both table sucessfully");
		session.getTransaction().commit();
	}
	

}

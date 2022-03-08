package study.main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import study.pojo.AccountEntity;

import study.pojo.EmployeeEntity;



public class HibernateMain {
public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		//Reading the hibernate.cfg.xml from classpath
				StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
				//Create MetadataSources
				MetadataSources sources=new MetadataSources(registry);
				//create Metadata
				Metadata metadata=sources.getMetadataBuilder().build();
				//
				org.hibernate.SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
				
				Session session=sessionFactory.openSession();//Start transaction
		
		add(session);
		session.close();
		//update(session);
	
		
	}
	/*public static Session getSession()
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
	}*/
	public static void add(Session session)
	{
		session.beginTransaction();
		AccountEntity account1=new AccountEntity();
		account1.setAccountNumber("12435756841");
		AccountEntity account2=new AccountEntity();
		account1.setAccountNumber("905746432");
		AccountEntity account3=new AccountEntity();
		account1.setAccountNumber("12349867434");
		
		
		EmployeeEntity firstEmployee=new EmployeeEntity();
		firstEmployee.setEmail("shubham12@gmail.com");
		firstEmployee.setFirstName("Shubham");
		
		EmployeeEntity firstEmployee1=new EmployeeEntity();
		firstEmployee1.setEmail("advay22@gmail.com");
		firstEmployee1.setFirstName("Advay");
		
		

		Set<AccountEntity> accountOfFirstEmployee=new HashSet<AccountEntity>();
		accountOfFirstEmployee.add(account1);
		accountOfFirstEmployee.add(account2);
		
		Set<AccountEntity> accountOfFirstEmployee1=new HashSet<AccountEntity>();
		accountOfFirstEmployee1.add(account3);
		
		firstEmployee.setAccounts(accountOfFirstEmployee);
		firstEmployee1.setAccounts(accountOfFirstEmployee1);
		
		session.save(firstEmployee);
		session.save(firstEmployee1);
		System.out.println("inserted in both table sucessfully");
		session.getTransaction().commit();
	}
	

}

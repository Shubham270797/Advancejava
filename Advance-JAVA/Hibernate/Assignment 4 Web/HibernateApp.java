package study;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateApp {
Session session;
public GroceryProduct searchProduct(int id) {
	session=getSession();
	Transaction trx=session.beginTransaction();
	GroceryProduct obj=session.get(GroceryProduct.class, id);
	if(obj!=null)
	{
		return obj;
	}
	trx.commit();
		return null;
	
	

}
public void deleteProduct(int id) {
	session=getSession();
	Transaction trx=session.beginTransaction();
	
	GroceryProduct obj=session.find(GroceryProduct.class,id);//select query
	if(obj!=null)
	{
		session.delete(obj);//delete query
	}
	trx.commit();
}
public void updateProduct(int id,int choice,String record) {
	System.out.println(id+choice+record);
	session=getSession();
	session.beginTransaction();
	//select by primary key
	System.out.println(id+choice+record);
	 GroceryProduct obj=session.get(GroceryProduct.class, id);//select * from table name where id=enterd id
	if(obj!=null)
	{
		
		if(choice==2 && record!=null)
		{
			
			obj.setProductName(record);//update query//update table name
			
		}
		else if(choice==3 && record!=null)
		{
			
			obj.setProductDesc(record);
			
		}
		else if(choice==4)
		{
		    int unit=Integer.parseInt(record);
			obj.setUnit(unit);
		}
		else if(choice==5)
		{

		    int cost=Integer.parseInt(record);
			obj.setProductCost(cost);
		}
		else
		{
			System.out.println("Entered column number is envalid try again");
		}
		
	}
session.getTransaction().commit();
	System.out.println("record updated successfully");
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
			System.out.println("Connected sucessfully!!!");
			return session;
}

public void addProduct(GroceryProduct gross)
{
	session=getSession();
	Transaction trx=session.beginTransaction();
    session.save(gross);//
    trx.commit();
    System.out.println("inserted successfully");
}


}
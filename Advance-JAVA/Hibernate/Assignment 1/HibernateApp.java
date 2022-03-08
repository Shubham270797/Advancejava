package study.entity;

import java.sql.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateApp {
public static void main(String[] args) {
	
		Session session=getSession();
		Scanner sc=new Scanner(System.in);
			
				//Transaction trx=session.beginTransaction();
				while(true)
				{
					showMenu();
					int choice=sc.nextInt();
					if(choice==5)
					{
						System.out.println("Quit!!!!");
						break;
					}
					switch(choice)
					{
					case 1: //insert into table
						   addProduct(session,sc);
					        break;
					case 2://update values
						    updateProduct(session,sc);
						    break;
					case 3://delete value
						        deleteProduct(session,sc);
						        break;
					case 4://read value
						        readSelectProduct(session,sc);
						        break;
					}
				}
				
				session.close();
}
private static void readSelectProduct(Session session, Scanner sc) {
	Transaction trx=session.beginTransaction();
	System.out.println("Enter the product id you want read");
	int id=sc.nextInt();
	GroceryProduct obj=session.get(GroceryProduct.class, id);
	if(obj!=null)
	{
		System.out.println(obj);
	}
	trx.commit();
}
private static void deleteProduct(Session session, Scanner sc) {
	Transaction trx=session.beginTransaction();
	System.out.println("Enter the product id you want to delete");
	int id=sc.nextInt();
	GroceryProduct obj=session.find(GroceryProduct.class,id);//select query
	if(obj!=null)
	{
		session.delete(obj);//delete query
	}
	trx.commit();
}
private static void updateProduct(Session session, Scanner sc) {
	Transaction trx=session.beginTransaction();
	//select by primary key
	System.out.println("Enter the product id whose records you want to change");
	int id=sc.nextInt();
	 GroceryProduct obj=session.get(GroceryProduct.class, id);//internal query select
	if(obj!=null)
	{
		System.out.println("what column value you want to change?\n2.product_name\n3.product_desc\n4.unit\n5.cost");
		int num=sc.nextInt();
		if(num==2)
		{
			System.out.println("Enter new product Name");
			String productName=sc.next();
			obj.setProductName(productName);//update query
		}
		else if(num==3)
		{
			System.out.println("Enter new product desc");
			sc.nextLine();
			String productDesc=sc.nextLine();
			obj.setProductDesc(productDesc);
		}
		else if(num==4)
		{
			System.out.println("Enter the new number of unit");
			int unit=sc.nextInt();
			obj.setUnit(unit);
		}
		else if(num==5)
		{
			System.out.println("Enter the new cost price");
			int cost=sc.nextInt();
			obj.setProductCost(cost);
		}
		else
		{
			System.out.println("Entered column number is envalid try again");
			updateProduct(session,sc);
		}
		
	}
	trx.commit();
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
			
			return session;
}
public static void showMenu()
{
	System.out.println("***************MENU***************");
	System.out.println("1.Add new product");
	System.out.println("2.Change the product property");
	System.out.println("3.Delete Product");
	System.out.println("4.Show details of product with given productId");
	System.out.println("5.Quit");
	System.out.println("Enter your Choice");
	System.out.println("**********************************");
}
public static void addProduct(Session session,Scanner sc)
{
	Transaction trx=session.beginTransaction();
	System.out.println("Enter the product name");
	String name=sc.next();
	System.out.println("Enter the product desc");
	sc.nextLine();
	String desc=sc.nextLine();
	System.out.println("Enter the unit");
	int unit=sc.nextInt();
	System.out.println("Enter the cost ");
	int cost=sc.nextInt();
	System.out.println("Enter the expiary date");
	String str=sc.next();
    Date date=Date.valueOf(str);
	
    GroceryProduct obj=new GroceryProduct(name,desc,unit,cost,date);//transient
    session.save(obj);//
    trx.commit();
}


}
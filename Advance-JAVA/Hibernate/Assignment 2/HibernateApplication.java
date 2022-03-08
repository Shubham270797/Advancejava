package study.entity;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



public class HibernateApplication {
	
	public static void main(String[] args) {
	
		
		Session session=getSession();
		
		Transaction trx=session.beginTransaction();
	//getAllRows( session).stream().forEach((row)->{System.out.println(row);});//print all
		getAllRowsUsingNative(session).stream().forEach((row)->{System.out.println(row);});
		/*StudentEntity obj=new StudentEntity(4,"Jitendra");//transient State
		StudentEntity obj1=new StudentEntity(5,"Advay");//transient State
		StudentEntity obj2=new StudentEntity(6,"Ojas");//transient State
		StudentEntity obj3=new StudentEntity(7,"Bhushan");//transient State
		*/
		/*session.save(obj);//after using save persistence know the object and it become Managed
		session.save(obj1);//Managed
		session.save(obj2);//Managed
		session.save(obj3);*///Managed
	
		trx.commit();
		//update(session);
		//delete(session);
		
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
	public static void update(Session session)
	{
		session.beginTransaction();
		//here the object is auto filled with all column as it is from db
		/*StudentEntity fromDB=session.find(StudentEntity.class, 1);//persistant
		fromDB.setStudentName("Prabhat");*/
		/*//Not recommanded below method
		StudentEntity trobj=new StudentEntity(4,"shubz");//If you have more columns then you have to add here all columns(who are not changed or
		//not changed) if not done that then unset column also get changed
		session.saveOrUpdate(trobj);*/
		
		session.getTransaction().commit();
		
	}
	public static void delete(Session session)
	{
		session.beginTransaction();
		StudentEntity obj=session.find(StudentEntity.class, 4);//persisetant
		if(obj !=null)
			session.delete(obj);//after this remove state
		session.getTransaction().commit();
	}
    public static List<StudentEntity>getAllRows(Session session)
    {
    	//Query<StudentEntity> query=session.createQuery("from study.entity.StudentEntity");
    	//Query<StudentEntity>query=session.createQuery("from study.entity.StudentEntity as s where s.rollNumber<5");
    	Query<StudentEntity>query=session.createQuery("from study.entity.StudentEntity as s where s.rollNumber<:maxroll");//placeholder
    	query.setParameter("maxroll", 7);
    	return query.list();
    	 
    }
    public static List<StudentEntity>getAllRowsUsingNative(Session session)//sql
    {
    	//Query<StudentEntity> query=session.createNativeQuery("select * from iet_student",StudentEntity.class);
    	//Query<StudentEntity>query=session.createQuery("from study.entity.StudentEntity as s where s.rollNumber<5");
    	Query<StudentEntity>query=session.createNativeQuery("select * from iet_student as s where s.roll_number<:maxroll",StudentEntity.class);//placeholder
    	query.setParameter("maxroll",5);
    	return query.list();
    	 
    }
}

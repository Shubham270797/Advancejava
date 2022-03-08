package com.java.miniproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;
//DAO 
public class DBManager {
    private Connection connect;

     public DBManager()
     {
    	 
     }
	public Connection getConnect() {
		return connect;
	}

	public void openConnection()
	{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url="jdbc:Mysql://localhost:3306/mini_project_db";
			String usname="root";
			String pwd="root";
			 connect=DriverManager.getConnection(jdbc_url, usname, pwd);
			System.out.println("Db connection sucess");
			
		} catch (ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
			
	}
	public void closeConnection()
	{
		try {
			connect.close();
			System.out.println("Connection is closed now");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     public boolean validateUser(User nuser)
     {
    	 //connect db
    	 openConnection();
    	 //fire query 
    	 try {
    		 String query="SELECT * FROM USER_INFO_TBL WHERE USER_USERNAME='"+nuser.getUsername()+"' AND USER_PASSWORD='"+nuser.getPwd()+"'";
    		 Statement stmt=connect.createStatement();
    		 ResultSet rs=stmt.executeQuery(query);
    		 //validate output
    		 if(rs.next())
    		 {  
    			 nuser.setId(rs.getInt(1));
    			 nuser.setFname(rs.getString(2));
    			 nuser.setLname(rs.getString(3));
    			 nuser.setEmailID(rs.getString(4));
    			 nuser.setMobileNo(rs.getString(5));
    			 return true;
    		 }
    		 else
    		 {
    			 return false;
    		 }
    	 }
    	 catch(Exception e)
    	 {
    		 System.err.println(e.getMessage());
    		 e.printStackTrace();
    	 }
    	 finally
    	 {
    		 //close connection
        	 closeConnection();
    	 }
    
    	
    	//return value
    	 return false;
     }
     public void addUser(User nuser)
     {
    	 //connect db
    	 openConnection();
    	 
    	
    	 
    	 try {
    		 String sql="INSERT INTO USER_INFO_TBL VALUES(DEFAULT,?,?,?,?,?,?)";
			PreparedStatement pstmt=connect.prepareStatement(sql);
			pstmt.setString(1,nuser.getFname());
			pstmt.setString(2, nuser.getLname());
			pstmt.setString(3, nuser.getEmailID());
			pstmt.setString(4, nuser.getMobileNo());
			pstmt.setString(5, nuser.getUsername());
			pstmt.setString(6, nuser.getPwd());
			pstmt.executeUpdate();
			System.out.println("record inserted sucessfully");
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
    	 finally
    	 {
    		//close connection
        	 closeConnection();
        	 System.out.println("Connection is closed");
    	 }
    	 
     }
	public void addHobby(Hobby hobby) {
		// TODO Auto-generated method stub
		openConnection();
		try {
			String sql="INSERT INTO HOBBY_TBL VALUES(DEFAULT,?,?)";
			PreparedStatement pstmt=connect.prepareStatement(sql);
			pstmt.setInt(1,hobby.getUserId());
			pstmt.setString(2,hobby.getHobby());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
			System.out.println("addHobby connection close");
		}
		
	}
	public ArrayList<Hobby> viewHobby(User currentUser)
	{
		
		ArrayList<Hobby> hobbyList=new ArrayList<>();
		openConnection();
	   	 System.out.println("connection inview hobby done");
	   	System.out.println("user id ="+currentUser.getId());
	   	 try {
	   		 String sql="SELECT HOBBY_HOBBYNAME FROM HOBBY_TBL WHERE HOBBY_USERID=?";
				PreparedStatement pstmt=connect.prepareStatement(sql);
			
				pstmt.setInt(1,currentUser.getId());
				
				
				//pstmt.executeUpdate();
				System.out.println("record fetched sucessfully");
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					Hobby h=new Hobby();
					h.setHobby(rs.getString(1));
					
					hobbyList.add(h);
				}
				
			} catch (SQLException e) {
				
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
	   	 finally
	   	 {
	   		//close connection
	       	 closeConnection();
	       	 System.out.println("Connection is closed");
	   	 }
	   	System.out.println("done with view hobby");
		return hobbyList;
		
	}
       
}

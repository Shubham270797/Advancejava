package study.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/*@Entity 
@Table(name="emp220")  
public class Employee {    
      
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @PrimaryKeyJoinColumn  
private int employeeId;    
private String name,email;

@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)  
private Address address;



public int getEmployeeId() {  
    return employeeId;  
}  
public void setEmployeeId(int employeeId) {  
    this.employeeId = employeeId;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getEmail() {  
    return email;  
}  
public void setEmail(String email) {  
    this.email = email;  
}  
public Address getAddress() {  
    return address;  
}  
public void setAddress(Address address) {  
    this.address = address;  
}    
  
} */
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
     private int employeeID;
	@Column(name="emp_name")
     private String ename;
	@Column(name="emp_email")
      private String email;
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)//
	@JoinColumn(name="addressId")
     private Address address;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee( String ename, String email, Address address) {
		super();
		
		this.ename = ename;
		this.email = email;
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", ename=" + ename + ", email=" + email + ", address=" + address
				+ "]";
	}
	
	
}
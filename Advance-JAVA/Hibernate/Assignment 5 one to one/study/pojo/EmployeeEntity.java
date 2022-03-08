package study.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;





@Entity
@Table(name="empMany")
public class EmployeeEntity implements Serializable {
 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto_increment
	@Column(name="empID")
	private Integer employeeId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@OneToMany(mappedBy="EmployeeEntity",cascade=CascadeType.ALL)
	//@JoinColumn()//name="EMPLOYEE_ID"
	private Set<AccountEntity> accounts;//more than one account
	
	public EmployeeEntity(Integer employeeId, String email, String firstName, Set<AccountEntity> accounts) {
		super();
		this.employeeId = employeeId;
		this.email = email;
		this.firstName = firstName;
		this.accounts = accounts;
	}

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}



	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", email=" + email + ", firstName=" + firstName
				+ ", accounts=" + accounts + "]";
	}
	
	
	 
}

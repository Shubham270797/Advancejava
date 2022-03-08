package study.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="ACCOUNTMany")
public class AccountEntity implements Serializable{
private static final long serialVersionUID=-6790693372846798580L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="ID")
private Integer accountID;

@Column(name="ACC_NUMBER")
private String accountNumber;

@ManyToOne
private EmployeeEntity employee;

public AccountEntity(Integer accountID , String accountNumber, EmployeeEntity employee) {
	super();
	this.accountID = accountID ;
	this.accountNumber = accountNumber;
	this.employee = employee;
}

public AccountEntity() {
	super();
	// TODO Auto-generated constructor stub
}

public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public EmployeeEntity getEmployee() {
	return employee;
}

public void setEmployee(EmployeeEntity employee) {
	this.employee = employee;
}

public Integer getAccountID() {
	return accountID;
}

public void setAccountID(Integer accountID) {
	this.accountID = accountID;
}

@Override
public String toString() {
	return "AccountEntity [accountID=" + accountID + ", accountNumber=" + accountNumber + ", employee=" + employee
			+ "]";
}
}

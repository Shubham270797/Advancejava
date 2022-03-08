package study;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="iet_student")
public class StudentEntity {
       @Id
       @Column(name="student_rollNo")
	private int rollNo;
       @Column(name="student_name")
     private String name;
	public StudentEntity(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentEntity [rollNo=" + rollNo + ", name=" + name + "]";
	}
       
}

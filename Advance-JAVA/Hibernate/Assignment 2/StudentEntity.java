package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="iet_student")
public class StudentEntity {
	@Id
	@Column(name="roll_number")
	private int rollNumber;
	
	@Column(name="student_name")
	private String studentName;

	public StudentEntity() {
		System.out.println("student entity");
	}
		

	public StudentEntity(int rollNumber, String studentName) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		System.out.println("get student rollnumber");
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		System.out.println("get student studentName");
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudentEntity [rollNumber=" + rollNumber + ", studentName=" + studentName + "]";
	}
	

}

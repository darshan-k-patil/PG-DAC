package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table
public class Student {
	
// studentId : Integer (PK) ,first name , last name,email,password,
//course(enum with admission fees), dob : LocalDate 
	@Id //Mandatory, PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="student_id")
	private Integer studentId;
	@Column(name="first_name",length = 20)//varchar(20)
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length = 30, unique = true)//unique constraint
	private String email;
	@Column(length = 20, nullable = false)//NOT NULL constraint
	private String password;
	@Transient//=> skips from persistence => no col. generation
	private String confirmPassword;
	@Column(name="dob")
	private LocalDate dob;
	@Enumerated(EnumType.STRING)//=> col type : varchar => enum const name
	@Column(length = 20)
	private Course course;
	
	//def ctor
	public Student() {
		
	}
	
	//ctor
	public Student(String firstName, String lastName, String email, String password,
			String confirmPassword, LocalDate dob, Course course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dob = dob;
		this.course = course;
	}
	
	//toString
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", dob=" + dob
				+ ", course=" + course + "]";
	}
	
	//getters and setters
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}

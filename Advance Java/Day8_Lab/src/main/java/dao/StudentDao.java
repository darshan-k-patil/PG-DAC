package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao {
//add a method to insert new emp details
	String registerNewStudent(Student emp);
	String studentLogin(String email, String password);
	
	//add a method to Get all students from a specific course
	List<Student> getStudentsByCourse(Course course);
}

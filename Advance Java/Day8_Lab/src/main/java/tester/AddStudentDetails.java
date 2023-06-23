package tester;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class AddStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) // invoking static method -->
		// cls loading --> static init block --> configure : entire hib frmwork loaded
		{
			//create dao instance
			StudentDaoImpl dao=new StudentDaoImpl();
			System.out.println(
					"Enter student details : firstName,  lastName,  email,  "
					+ "password,  confirmPassword, dob,  course");
			Student newStudent = new Student(sc.next(),sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), Course.valueOf(sc.next().toUpperCase()));
			System.out.println(dao.registerNewStudent(newStudent));
			
		} // sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package dao;

import org.hibernate.SessionFactory;

import pojos.Course;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class GetAllStudentsByCourse {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter course name");
			dao.getStudentsByCourse(Course.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

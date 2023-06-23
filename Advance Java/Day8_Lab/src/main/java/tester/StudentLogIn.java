package tester;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class StudentLogIn {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		//invoking static method-->cla loading-->static init block
		//-->configure : entire hib frmwk loaded
		{
			//create dao instance
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter email and password");
		System.out.println(dao.studentLogin(sc.next(), sc.next()));
		}//sf.close()-->cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

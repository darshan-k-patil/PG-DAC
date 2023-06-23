package dao;

import pojos.Course;
import pojos.Student;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String registerNewStudent(Student student) {
		String mesg="Registering student failed!!!";
		// get session from Session Factory
		Session session = getFactory().getCurrentSession();
		//begin a tx
		Transaction tx = session.beginTransaction();
		try {
			Serializable id = session.save(student);
			tx.commit();
			mesg = "Student registered successfully with id="+id;
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String studentLogin(String email, String password) {
		Student stud = null;
		String jpql = "select s from Student s where s.email=:em and s.password=:pass";
		String mesg = "Student login failed!!!";
		//get session from session factory
		Session session = getFactory().getCurrentSession();
		//begin a tx
		Transaction tx = session.beginTransaction();
		try {
			stud = session.createQuery(jpql, Student.class)
					.setParameter("em", email)
					.setParameter("pass", password)
					.getSingleResult();
			tx.commit();	
			mesg="Student Login successfully!! "+stud;
		}catch (RuntimeException e) {
			// rollback tx
			if(tx != null)
				tx.rollback();//no dirty checking -->session.close()
				//-->l1 chache destroyed and db connection returns to pool
			
			//re throw the same exc to the caller : to inform the user
			throw e;
		}
		return mesg;
	}
	
	@Override
	public List<Student> getStudentsByCourse(Course course) {
		List<Student> studList = null;
		String jpql = "select s from Student s where s.course=:crs";
		//get session from SF
		Session session = getFactory().getCurrentSession();
		//begin tx
		Transaction tx = session.beginTransaction();
		try {
			studList = session.createQuery(jpql, Student.class)
					.setParameter("crs", course)
					.getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			// rollback tx
			if(tx != null)
				tx.rollback();//no dirty checking -->session.close()
				//-->l1 chache destroyed and db connection returns to pool
			
			//re throw the same exc to the caller : to inform the user
			throw e;
		}
		return studList;
	}
	

}

package dao;
import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Team;
public class TeamDaoImpl implements TeamDao {

	@Override
	public List<Team> getAllTeams() {
		List<Team> teams = null;
		String jpql = "select new pojos.Team(id,abbreviation) from Team";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return teams;
	}

	@Override
	public String addNewTeam(Team newTeam) {
		String mesg = "adding new team fail";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			session.persist(newTeam);
			tx.commit();
			mesg="added new team with id="+newTeam.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Team getTeamDetails(long teamId) {
		Team t = null;
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			t=session.get(Team.class, teamId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return t;
	}


}

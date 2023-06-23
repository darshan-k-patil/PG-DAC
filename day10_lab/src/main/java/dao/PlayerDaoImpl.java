package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao{

	@Override
	public String addPlayerToTeam(Player newPlayer, long teamId) {
		String mesg = "Adding player failed ";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			Team t = session.get(Team.class, teamId);
			if(t != null) {
				t.addPlayer(newPlayer);
				mesg = "Adding player successfull";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}

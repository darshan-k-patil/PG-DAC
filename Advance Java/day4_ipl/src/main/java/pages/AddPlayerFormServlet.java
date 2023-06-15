package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

/**
 * Servlet implementation class AddPlayerFormServlet
 */
@WebServlet(value = "/add_player_form", loadOnStartup = 1)
public class AddPlayerFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDaoImpl teamDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		// create team dao instance
		try {
			teamDao = new TeamDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			teamDao.cleanUp();
		} catch (Exception e) {
			System.out.println("err in destroy of " + getClass() + " " + e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// invoke dao's method to get all teams details
			List<Team> teams = teamDao.getSelectedDetails();
			// dynamic form generation
			pw.print("<form action='process_form'>");
			pw.print(" <h5> Choose A Team ");
			pw.print("<select name='team_id'>");
			for (Team t : teams)
				pw.print("<option value='" + t.getTeamId() + "'>" + t.getAbbreviation() + "</option>");
			pw.print("</select></h5>");
			pw.print("<h5>Player Name ");
			pw.print("<input type='text' name='full_name'/></h5>");
			pw.print("<h5>DoB");
			pw.print("<input type='date' name='dob'/></h5>");
			pw.print("<h5>Batting Average");
			pw.print("<input type='number' name='avg'/></h5>");
			pw.print("<h5>Wickets Taken ");
			pw.print("<input type='number' name='wickets'/></h5>");
			pw.print("<h5><input type='submit' value='Add A Player'/></h5>");
			pw.print("</form>");

		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}

}

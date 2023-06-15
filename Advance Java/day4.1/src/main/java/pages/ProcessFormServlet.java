package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Course;
import pojos.Student;

/**
 * Servlet implementation class ProcessFormServlet
 */
@WebServlet("/process_form")
public class ProcessFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html");      //not req
//		try (PrintWriter pw = response.getWriter()) {    //not req
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			int score = Integer.parseInt(request.getParameter("score"));
			Course selectedCourse = Course.valueOf(request.getParameter("course"));
			//encap details in student object
			Student student=new Student(firstName, lastName, score, selectedCourse);
			//chk if admission to be granted or not
			if(score > selectedCourse.getMinScore())
				student.setAdmitted(true);
		//	pw.print("<h4> from 1st page...</h4>"); //doesnt get print on web page due to forward
		//	pw.flush(); //48 line throws ISE exception
			//store the student details under CURRENT REQUEST scope
			request.setAttribute("student_dtls", student);
			//server pull : RequestDispatcher : forward 
			//1. get RD
			RequestDispatcher rd=request.getRequestDispatcher("result"); //faster resp than clnt pull
			//forward
			rd.forward(request, response); //req going to end after current req's resp is rendered
			System.out.println("came back.....");//appears on server side console
//			pw.print("<h5>content after forward....</h5>");  //not req
			/*
			 * WC clears/discards resp buffer. 
			 * Suspends the exec of this method
			 * Invokes doPost of the next page(Result page)
			 * last page in the chain(result page) : can generate dyn resp
			 * control of exec comes back n then response is rendered.
			 */
			
//		}
	}

}

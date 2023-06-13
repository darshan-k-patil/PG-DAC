package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test1",loadOnStartup = 2)
//WC processes(reads) this only once @ web application deployment time
//WC creates an empty map and then populates URL map
//key : /test1
//value : pages.Servlet1
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get by : "+Thread.currentThread());
		//set response content type (setting a response header content-type: text/html)
		resp.setContentType("text/html");
		//get PW to send character, buffer data to client
		try(PrintWriter pw=resp.getWriter()){
			pw.print("<h4>Welcome 2 servlet : "+getClass()+"TS"+LocalDateTime.now()+"</h4>");
		}
	}//Web Container(WC) : pw.flush() --->buffer contents are sent ---> pw.close()

	@Override
	public void destroy() {
		System.out.println("in destroy by : "+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init by : "+Thread.currentThread());
	}

}

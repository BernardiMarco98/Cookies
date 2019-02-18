
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;


/**
 * Servlet implementation class Pippo
 */
@WebServlet("/Pippo")
public class Pippo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;
	
	
	public Pippo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init()
	{
		logger = Logger.getRootLogger();
		PatternLayout layout = new PatternLayout("%d{ABSOLUTE} %5p %c:%L - %m%n");
		logger.addAppender(new ConsoleAppender(layout));
		
	
		RollingFileAppender appender;
		try {
			appender = new RollingFileAppender(layout,"/home/marco/Desktop/servletRuntime.log");
			appender.setMaxFileSize("10MB");
			logger.addAppender(appender);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Cookie userCookies[] = request.getCookies();
		Cookie cookiePippo = getCookie(userCookies, "Pippo");
		
		request.setAttribute("color", "brown");
		//se il cookie Pluto non esiste, setto Pluto e Disney e li aggiungo all'arraylist
		if (cookiePippo == null) {
			Cookie Pippo = new Cookie("Pippo", "CookieDiPippo");
			Pippo.setPath("/Cookies/Pippo");
			Pippo.setMaxAge(300);
			response.addCookie(Pippo);

			Cookie Disney = new Cookie("Disney", "CookieDisney");
			Disney.setPath("/Cookies");
			Disney.setMaxAge(300);
			response.addCookie(Disney);
	
		}
		if(userCookies != null) {
			for(int i = 0; i < userCookies.length; i++) {
				logger.debug("Pippo -> "+userCookies[i].getName()+":"+userCookies[i].getValue());
			}
		}
		else {
			logger.error("ERROR: Nessun Cookie presente");
		}
		
	
		request.setAttribute("arraylist", userCookies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayCookies.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public Cookie getCookie(Cookie cookies[], String Name) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Name)) {
					return cookie;
				}
			}
		}
		return null;
	}
}

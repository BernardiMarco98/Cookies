
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


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
			String debugMessage = null;
			for(int i = 0; i < userCookies.length; i++) {
				debugMessage = "Pippo -> "+userCookies[i].getName()+":"+userCookies[i].getValue();
				logger.debug(debugMessage);
			}
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

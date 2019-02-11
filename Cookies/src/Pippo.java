

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pippo
 */
@WebServlet("/Pippo")
public class Pippo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pippo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Cookie Pippo = new Cookie("Pippo", "CookieDiPippo");
		Pippo.setDomain("/Cookies/Pippo");
		Pippo.setMaxAge(300);
		Cookie Disney = new Cookie("Disney", "CookieDisney");
		Disney.setDomain("/Cookies");
		Disney.setMaxAge(300);
		response.addCookie(Pippo);
		response.addCookie(Disney);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayCookies.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public Cookie getCookie(Cookie cookies[], String Path) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getPath().equals(Path)) {
					return cookie;
				}
			}
		}
		return null;
	}
}

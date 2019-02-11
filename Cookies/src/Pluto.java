

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pluto
 */
@WebServlet("/Pluto")
public class Pluto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Pluto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Cookie userCookies[] = request.getCookies();

		Cookie Pluto = new Cookie("Pluto", "CookieDiPluto");
		Pluto.setDomain("/cookies/pluto");
		Pluto.setMaxAge(300);
		Cookie Disney = new Cookie("Disney", "CookieDisney");
		Disney.setDomain("/cookies");
		Disney.setMaxAge(300);
		response.addCookie(Pluto);
		response.addCookie(Disney);

		if(userCookies != null) {
		request.setAttribute("cookie1", getCookie(userCookies, "/cookies/pluto").getName());
		request.setAttribute("cookie1value", getCookie(userCookies, "/cookies/pluto").getValue());
		request.setAttribute("cookie2", getCookie(userCookies, "/cookies").getName());
		request.setAttribute("cookie2value", getCookie(userCookies, "/cookies").getValue());
		}
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

	public Cookie getCookie(Cookie cookies[], String domain) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getDomain().equals(domain)) {
					return cookie;
				}
			}
		}
		return null;
	}

}


import java.io.IOException;
import java.util.ArrayList;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Cookie userCookies[] = request.getCookies();
		Cookie cookiePluto = getCookie(userCookies, "Pluto");
		ArrayList<Cookie> cookiesList = new ArrayList<Cookie>();

		//se il cookie Pluto non esiste, setto Pluto e Disney e li aggiungo all'arraylist
		if (cookiePluto == null) {
			Cookie Pluto = new Cookie("Pluto", "CookieDiPluto");
			Pluto.setPath("/Cookies/Pluto");
			Pluto.setMaxAge(300);
			response.addCookie(Pluto);
			cookiesList.add(Pluto);

			Cookie Disney = new Cookie("Disney", "CookieDisney");
			Disney.setPath("/Cookies");
			Disney.setMaxAge(300);
			response.addCookie(Disney);
			cookiesList.add(Disney);

			request.setAttribute("arraylist", cookiesList);
		} else {// altrimenti, scorro tutto l'array dei cookies e aggiungo tutti i
				// cookies(tranne JSESSIONID) all'arraylist
			for (int i = 0; i < userCookies.length; i++) {
				if (!userCookies[i].getName().equals("JSESSIONID"))
					cookiesList.add(userCookies[i]);
			}
			request.setAttribute("arraylist", cookiesList);
		}
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

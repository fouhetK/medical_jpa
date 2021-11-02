package medical.m2i.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.DAO.PaysDAO;
import medical.m2i.DAO.VilleDAO;
import medical.m2i.bo.Ville;

/**
 * Servlet implementation class VilleServlet
 */
@WebServlet("/villes")
public class VilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static VilleDAO villeDAO = new VilleDAO();
	private static PaysDAO paysDAO = new PaysDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VilleServlet() {
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

		Collection<Ville> villes;

		String pays = request.getParameter("pays");

		if (pays == null) {
			villes = villeDAO.findAll();
			request.setAttribute("listeville", villes);
			getServletContext().getRequestDispatcher("/listeville.jsp").forward(request, response);
		} else {
			villes = villeDAO.findAll(paysDAO.get(pays));
			request.setAttribute("listeville", villes);
			getServletContext().getRequestDispatcher("/fragments/option.jsp").forward(request, response);
		}

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

}

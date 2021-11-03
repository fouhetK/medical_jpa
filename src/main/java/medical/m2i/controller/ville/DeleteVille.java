package medical.m2i.controller.ville;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.DAO.VilleDAO;

/**
 * Servlet implementation class DeleteVille
 */
@WebServlet(name = "deleteville", urlPatterns = { "/deleteville" })
public class DeleteVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VilleDAO villeDAO = new VilleDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteVille() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		villeDAO.delete(id);
		getServletContext().getRequestDispatcher("/villes").forward(request, response);
	}

}

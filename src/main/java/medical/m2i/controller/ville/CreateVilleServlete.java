package medical.m2i.controller.ville;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.DAO.PaysDAO;
import medical.m2i.DAO.VilleDAO;
import medical.m2i.model.Pays;
import medical.m2i.model.Ville;

/**
 * Servlet implementation class CreateVilleServlete
 */
@WebServlet(name = "createville", urlPatterns = { "/createville" })
public class CreateVilleServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VilleDAO villeDAO = new VilleDAO();
	private static PaysDAO paysDAO = new PaysDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateVilleServlete() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collection<Pays> pays = paysDAO.findAll();
		request.setAttribute("listepays", pays);
		getServletContext().getRequestDispatcher("/villecreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String nom = request.getParameter("nom");
			String codepostal = request.getParameter("codepostal");
			Pays pays = paysDAO.get(request.getParameter("pays"));

			Ville ville = new Ville(nom, codepostal, pays);

			villeDAO.save(ville);

			response.sendRedirect("/medical5_jpa/villes");

		} catch (Exception e) {
			System.out.println();
		}
	}

}

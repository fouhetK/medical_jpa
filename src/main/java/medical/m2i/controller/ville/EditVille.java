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
import medical.m2i.bo.Pays;
import medical.m2i.bo.Ville;

/**
 * Servlet implementation class EditVille
 */
@WebServlet(name = "editville", urlPatterns = { "/editville" })
public class EditVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VilleDAO villeDAO = new VilleDAO();
	private static PaysDAO paysDAO = new PaysDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditVille() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Ville ville = villeDAO.get(id);
			Collection<Pays> pays = paysDAO.findAll();
			request.setAttribute("ville", ville);
			request.setAttribute("listepays", pays);
			getServletContext().getRequestDispatcher("/villeedit.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id_ville"));
			String nom = request.getParameter("nom");
			String codepostal = request.getParameter("codepostal");
			Pays pays = paysDAO.get(request.getParameter("pays"));

			Ville ville = villeDAO.get(id);

			ville.setNom(nom);
			ville.setCodePostal(codepostal);
			ville.setPays(pays);

			villeDAO.update(ville);

			response.sendRedirect("/medical5_jpa/villes");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

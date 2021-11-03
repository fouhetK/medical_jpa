package medical.m2i.controller.patient;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.DAO.PatientDAO;
import medical.m2i.DAO.PaysDAO;
import medical.m2i.DAO.VilleDAO;
import medical.m2i.bo.Patient;
import medical.m2i.bo.Pays;
import medical.m2i.bo.Ville;

/**
 * Servlet implementation class AjoutPatient
 */
@WebServlet("/ajoutpatient")
public class AjoutPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientDAO personneDAO = new PatientDAO();
	private static VilleDAO villeDAO = new VilleDAO();
	private static PaysDAO paysDAO = new PaysDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutPatient() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String date = request.getParameter("datenaissance");
		String adresse = request.getParameter("adresse");
		Pays pays = paysDAO.get(request.getParameter("pays"));
		Ville ville = villeDAO.get(request.getParameter("ville"));

		if (pays != null && ville != null) {
			Patient personne = new Patient(prenom, nom, Date.valueOf(date), adresse, ville, pays);
			personneDAO.save(personne);
		}
		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

}

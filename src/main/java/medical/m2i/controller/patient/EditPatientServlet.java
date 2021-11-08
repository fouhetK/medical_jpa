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
import medical.m2i.model.Patient;
import medical.m2i.model.Pays;
import medical.m2i.model.Ville;

/**
 * Servlet implementation class EditPatientServlet
 */
@WebServlet("/editpatient")
public class EditPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientDAO patientDAO = new PatientDAO();
	private static VilleDAO villeDAO = new VilleDAO();
	private static PaysDAO paysDAO = new PaysDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPatientServlet() {
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
			Patient patient = patientDAO.get(id);
			request.setAttribute("patient", patient);
			getServletContext().getRequestDispatcher("/patientedit.jsp").forward(request, response);
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
			int id = Integer.parseInt(request.getParameter("id_patient"));
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String date = request.getParameter("datenaissance");
			String adresse = request.getParameter("adresse");
			Pays pays = paysDAO.get(request.getParameter("pays"));
			Ville ville = villeDAO.get(request.getParameter("ville"));

			Patient patient = patientDAO.get(id);

			patient.setPrenom(prenom);
			patient.setNom(nom);
			patient.setDatenaissance(Date.valueOf(date));
			patient.setAdresse(adresse);
			patient.setPays(pays);
			patient.setVille(ville);

			patientDAO.update(patient);
			getServletContext().getRequestDispatcher("/listepatients").forward(request, response);

		} catch (Exception e) {
			System.out.println();
		}
	}

}

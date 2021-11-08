package medical.m2i.controller.patient;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.DAO.PatientDAO;
import medical.m2i.model.Patient;

/**
 * Servlet implementation class Test
 */
@WebServlet("/listepatients")
public class ListPatients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static PatientDAO personneDAO = new PatientDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPatients() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collection<Patient> personnes = personneDAO.findAll();

		request.setAttribute("listepatient", personnes);

		getServletContext().getRequestDispatcher("/listepatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

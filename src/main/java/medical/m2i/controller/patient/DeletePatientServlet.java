package medical.m2i.controller.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.DAO.PatientDAO;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet(name = "deletepatient", urlPatterns = { "/deletepatient" })
public class DeletePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientDAO patientDAO = new PatientDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePatientServlet() {
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
			patientDAO.delete(id);
			getServletContext().getRequestDispatcher("/listepatients").forward(request, response);
		} catch (Exception e) {
			System.out.println();
		}

	}

}

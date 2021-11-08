import medical.m2i.DAO.PaysDAO;
import medical.m2i.DAO.VilleDAO;
import medical.m2i.model.Pays;
import medical.m2i.model.Ville;

public class CreateVille {
	private static VilleDAO villeDAO = new VilleDAO();

	public CreateVille() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// populate();
	}

	private static void populate() {
		PaysDAO paysDAO = new PaysDAO();

		Pays france = paysDAO.get("Fra");
		if (france == null) {
			france = new Pays("France");
			paysDAO.save(france);
		}
		Pays italie = paysDAO.get("Ita");
		if (italie == null) {
			italie = new Pays("Italie");
			paysDAO.save(italie);
		}
		Pays angleterre = paysDAO.get("Ang");
		if (angleterre == null) {
			angleterre = new Pays("Angleterre");
			paysDAO.save(angleterre);
		}

		createVilleFrance(france);
		createVilleItalie(italie);
		createVilleAngleterre(angleterre);
	}

	private static void createVilleFrance(Pays pays) {
		villeDAO.save(new Ville("Paris", "", pays));
		villeDAO.save(new Ville("Nice", "", pays));
		villeDAO.save(new Ville("Antibes", "", pays));
		villeDAO.save(new Ville("Lyon", "", pays));
		villeDAO.save(new Ville("Fréjus", "", pays));
	}

	private static void createVilleAngleterre(Pays pays) {
		villeDAO.save(new Ville("Londres", "", pays));
		villeDAO.save(new Ville("Birmingham", "", pays));
		villeDAO.save(new Ville("Manchester", "", pays));
		villeDAO.save(new Ville("Liverpool", "", pays));
		villeDAO.save(new Ville("Glasgow", "", pays));
	}

	private static void createVilleItalie(Pays pays) {
		villeDAO.save(new Ville("Rome", "", pays));
		villeDAO.save(new Ville("Milan", "", pays));
		villeDAO.save(new Ville("Naples", "", pays));
		villeDAO.save(new Ville("Turin", "", pays));
		villeDAO.save(new Ville("Gênes", "", pays));
	}

	private static void saveVille(Ville ville) {
		villeDAO.save(ville);
	}
}

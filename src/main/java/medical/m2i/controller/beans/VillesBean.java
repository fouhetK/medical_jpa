package medical.m2i.controller.beans;

import java.io.Serializable;
import java.util.Collection;

import medical.m2i.DAO.VilleDAO;
import medical.m2i.model.Ville;

/**
 * Session Bean implementation class VillesBean
 */
//@ManagedBean
//@SessionScoped
public class VillesBean implements Serializable {
	// villesBean

	/**
	 * 
	 */
	private static final long serialVersionUID = 4356685251785460886L;

	private Collection<Ville> listeVilles;
	private Ville ville;

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Collection<Ville> getListeVilles() {
		return listeVilles;
	}

	public void setListeVilles(Collection<Ville> listeVilles) {
		this.listeVilles = listeVilles;
	}

	public VillesBean() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		VilleDAO vdao = new VilleDAO();
		listeVilles = vdao.findAll();

		ville = new Ville();
		System.out.println("Je suis dans init bean ville , taille de la liste = " + listeVilles.size());
	}

	public String saveVille() throws ClassNotFoundException {
		VilleDAO vdao = new VilleDAO();
		ville.setCodePostal("8888");
		vdao.save(ville);
		// System.out.println(ville.getNom());
		return "/done.xhtml?faces-redirect=true";
	}

}

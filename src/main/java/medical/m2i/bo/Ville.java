package medical.m2i.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ville {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String codePostal;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Pays pays;

	public Ville() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nom
	 * @param codePostal
	 */
	public Ville(int id, String nom, String codePostal, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.codePostal = codePostal;
		this.pays = new Pays(pays);
	}

	public Ville(String nom, String codePostal, Pays pays) {
		super();
		this.nom = nom;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}

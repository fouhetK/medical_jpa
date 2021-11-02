package medical.m2i.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pays {

	@Id
	@Column(name = "code")
	private String code;
	private String nom;

	public Pays() {
		// TODO Auto-generated constructor stub
	}

	public Pays(String nom) {
		this.nom = nom;
		this.code = nom.substring(0, 3);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

}

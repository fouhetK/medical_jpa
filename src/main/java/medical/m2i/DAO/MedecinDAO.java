package medical.m2i.DAO;

import java.util.Collection;

import javax.persistence.Query;

import medical.m2i.model.Medecin;

public class MedecinDAO extends AbstractDAO<Medecin> {

	@Override
	public Medecin get(Integer id) {
		Medecin medecin = em.find(Medecin.class, id);
		return medecin;
	}

	public Medecin getByMail(String mail) {
		return em.createNamedQuery("Medecin.find", Medecin.class).setParameter("mail", mail).getSingleResult();
	}

	@Override
	public Collection<Medecin> findAll() {
		Query query = em.createQuery("from Medecin");

		return query.getResultList();
	}

}

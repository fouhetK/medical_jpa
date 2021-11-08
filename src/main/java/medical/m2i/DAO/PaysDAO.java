package medical.m2i.DAO;

import java.util.Collection;

import javax.persistence.Query;

import medical.m2i.model.Pays;

public class PaysDAO extends AbstractDAO<Pays> {

	public PaysDAO() {
		super();
	}

	@Override
	public Pays get(Integer id) {
		Pays pays = em.find(Pays.class, id);
		return pays;
	}

	public Pays get(String id) {
		Pays pays = em.find(Pays.class, id);
		return pays;
	}

	@Override
	public Collection<Pays> findAll() {
		Query query = em.createQuery("from Pays");

		return query.getResultList();
	}
}

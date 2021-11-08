package medical.m2i.DAO;

import java.util.Collection;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import medical.m2i.model.Pays;
import medical.m2i.model.Ville;

public class VilleDAO extends AbstractDAO<Ville> {

	public VilleDAO() {
		super();
	}

	@Override
	public Ville get(Integer id) {
		Ville livre = em.find(Ville.class, id);
		return livre;
	}

	public Ville get(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ville> cq = cb.createQuery(Ville.class);

		Root<Ville> ville = cq.from(Ville.class);
		Predicate codepays = cb.equal(ville.get("nom"), name);
		cq.where(codepays);

		TypedQuery<Ville> query = em.createQuery(cq);

		return query.getResultList().get(0);
	}

	@Override
	public Collection<Ville> findAll() {
		Query query = em.createQuery("from Ville");

		return query.getResultList();
	}

	public Collection<Ville> findAll(Pays pays) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ville> cq = cb.createQuery(Ville.class);

		Root<Ville> ville = cq.from(Ville.class);
		Predicate codepays = cb.equal(ville.get("pays"), pays);
		cq.where(codepays);

		TypedQuery<Ville> query = em.createQuery(cq);

		return query.getResultList();
	}

}

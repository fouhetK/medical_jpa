package medical.m2i.DAO;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class AbstractDAO<T extends Object> {

	protected static EntityManagerFactory emf = null;
	protected static EntityManager em = null;

	public AbstractDAO() {
		super();
		if (emf == null) {
			// Création de l’EntityManagerFactory
			emf = Persistence.createEntityManagerFactory("medical5_jpa");

			// Création de l’EntityManager
			em = emf.createEntityManager();
		}
	}

	/**
	 * sauvegarde un t
	 * 
	 * @param livre
	 */
	public void save(T object) {
		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();

		// Début des modifications
		try {
			tx.begin();
			em.persist(object);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			tx.rollback();
		}
	}

	/**
	 * update un t
	 * 
	 * @param livre
	 */
	public void update(T object) {
		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();

		// Début des modifications
		try {
			tx.begin();
			em.merge(object);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/**
	 * supprime un t a partir de son id
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();

		// Début des modifications
		try {
			tx.begin();
			T object = get(id);
			em.remove(em.contains(object) ? object : em.merge(object));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	/**
	 * recupere un t avec son id
	 * 
	 * @param id
	 */
	abstract T get(Integer id);

	/**
	 * recupere tous les ts
	 * 
	 * @return
	 */
	abstract Collection<T> findAll();
}
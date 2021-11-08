package medical.m2i.DAO;

import java.util.Collection;

import javax.persistence.Query;

import medical.m2i.model.User;

public class UserDAO extends AbstractDAO<User> {

	@Override
	public User get(Integer id) {
		User user = em.find(User.class, id);
		return user;
	}

	public User getByUserAndPassword(String username, String password) {
		User user = null;
		if (username != null && password != null) {
			user = em.createNamedQuery("User.findByUsernameAndPassword", User.class).setParameter("username", username)
					.setParameter("password", password).getSingleResult();
		}

		return user;
	}

	@Override
	public Collection<User> findAll() {
		Query query = em.createQuery("from User", User.class);

		return query.getResultList();
	}

}

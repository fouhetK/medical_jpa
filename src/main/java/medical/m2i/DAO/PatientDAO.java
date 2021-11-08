package medical.m2i.DAO;

import java.util.Collection;

import javax.persistence.Query;

import medical.m2i.model.Patient;

public class PatientDAO extends AbstractDAO<Patient> {

	public PatientDAO() {
		super();
	}

	@Override
	public Patient get(Integer id) {
		Patient pays = em.find(Patient.class, id);
		return pays;
	}

	@Override
	public Collection<Patient> findAll() {
		Query query = em.createQuery("from Patient");

		return query.getResultList();
	}

}

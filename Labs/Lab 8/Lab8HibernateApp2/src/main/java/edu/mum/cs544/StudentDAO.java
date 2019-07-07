package edu.mum.cs544;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {

	private Collection<Student> studentlist = new ArrayList<Student>();

	public StudentDAO() {

	}

	public Student load(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
		TypedQuery<Student> query = em.createQuery("select s from Student s join s.courselist c where s.studentid = :id",Student.class);
		EntityGraph<Student> entityGraph = em.createEntityGraph(Student.class);
		entityGraph.addSubgraph("courselist");
		query.setParameter("id",studentid);
		query.setHint("javax.persistence.fetchgraph", entityGraph);
		return query.getSingleResult();
	}
}

package org.example.tpcomputer.dao;

import org.example.tpcomputer.models.Computer;
import org.example.tpcomputer.models.Project;

import java.util.List;

public class ProjectDao extends BaseDao<Project> {

    @Override
    public List<Project> get() {
        return em.createQuery("Select a from Project a", Project.class).getResultList();
    }

    public boolean addCumputer(int idProject,int idComputer) {
        try {
            em.getTransaction().begin();
            Project project = em.find(Project.class, idProject);
            Computer computer = em.find(Computer.class, idComputer);
            project.addComputer(computer);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeComputer(int idProject,int idComputer) {
        try {
            em.getTransaction().begin();
            Project project = em.find(Project.class, idProject);
            Computer computer = em.find(Computer.class, idComputer);
            project.removeComputer(computer);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

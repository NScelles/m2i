package org.example.tpcomputer.dao;

import org.example.tpcomputer.models.Computer;
import org.example.tpcomputer.models.OperatingSystem;

import java.util.List;

public class OperatingSystemDao extends BaseDao<OperatingSystem> {
    @Override
    public List<OperatingSystem> get() {
        return em.createQuery("Select os from OperatingSystem os", OperatingSystem.class).getResultList();
    }
}

package org.example.tpcomputer.dao;

import org.example.tpcomputer.models.OperatingSystem;
import org.example.tpcomputer.models.Processor;

import java.util.List;

public class ProcessorDao extends BaseDao<Processor> {
    @Override
    public List<Processor> get() {
        return em.createQuery("Select p from Processor p", Processor.class).getResultList();
    }
}

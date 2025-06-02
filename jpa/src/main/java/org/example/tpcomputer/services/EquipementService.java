package org.example.tpcomputer.services;

import lombok.NoArgsConstructor;
import org.example.tpcomputer.dao.ComputerDao;
import org.example.tpcomputer.dao.OperatingSystemDao;
import org.example.tpcomputer.dao.ProcessorDao;
import org.example.tpcomputer.dao.ProjectDao;
import org.example.tpcomputer.models.*;


import java.util.List;

@NoArgsConstructor
public class EquipementService {

    private ComputerDao computerDao = new ComputerDao();
    private OperatingSystemDao operatingSystemDao = new OperatingSystemDao();
    private ProcessorDao processorDao = new ProcessorDao();
    private ProjectDao projectDao = new ProjectDao();

    /// CRUD Computer
    public void createComputer(String model, Identification identification,int idProcessor, int idOS){

        Processor processor = processorDao.get(idProcessor,Processor.class);
        OperatingSystem os = operatingSystemDao.get(idOS,OperatingSystem.class);
        Computer computer = Computer.builder().model(model).identification(identification).processor(processor).operatingSystem(os).build();
        computerDao.save(computer);
    }

    public Computer getComputer(int id){
        return computerDao.get(id,Computer.class);
    }

    public List<Computer> getComputers(){
        return computerDao.get();
    }

    public void updateComputer(Computer computer) {
        computerDao.update(computer);
    }

    public void deleteComputer(int id) {
        computerDao.delete(id,Computer.class);
    }

    /// CRUD Processor
    public List<Processor> getProcessors(){
        return processorDao.get();
    }

    public void createProcessor(String brand, String name,String model) {
        Processor processor = Processor.builder().brand(brand).name(name).model(model).build();
        processorDao.save(processor);
    }


    /// CRUD OperatingSystem
    public List<OperatingSystem> getAllOS(){
        return operatingSystemDao.get();
    }

    public void createOperatingSystem(String name,String version) {
        OperatingSystem os = OperatingSystem.builder().name(name).version(version).build();
        operatingSystemDao.save(os);
    }

    /// CRUD Project
    public void createProject(String name, String description){
        Project project = Project.builder().name(name).description(description).build();
        projectDao.save(project);
    }

    public Project getProjects(int id){
        return projectDao.get(id,Project.class);
    }

    public List<Project> getProjects(){
        return projectDao.get();
    }

    public void updateProject(Project project) {
        projectDao.update(project);
    }

    public void deleteProject(int id) {
        projectDao.delete(id,Project.class);
    }

    public void addComputerProject(int idProject, int idComputer) {
        projectDao.addCumputer(idProject,idComputer);
    }

}

package org.example.tpcomputer.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "project_computer",
            joinColumns = @JoinColumn(name ="project_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id")
    )
    private List<Computer> computers;

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void removeComputer(Computer computer) {
        computers.remove(computer);
    }

    @Override
    public String toString() {
        return "\nProject:" +
                id +
                " | name: " + name +
                " | description: " + description  +
                " | computers: " + computers;
    }
}

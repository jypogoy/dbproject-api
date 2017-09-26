package com.yogop.dbprojectapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;

/**
 * @author Jeffrey Y. Pogoy
 * @created 14 Sep 2017 11:21 AM
 */
@Entity(name = "project")
@Data
@XmlRootElement
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @Column(name = "date_added", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp dateAdded;

    public Project() {
    }

    public Project(Long id, String name, String description, Timestamp dateAdded) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public Project(String name, String description, Timestamp dateAdded) {
        super();
        this.name = name;
        this.description = description;
        this.dateAdded = dateAdded;
    }
}

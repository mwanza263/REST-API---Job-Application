package com.embarkx.firstjobapp.job;

import com.embarkx.firstjobapp.Company.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String minSalary;
    private String maxSalary;

    @ManyToOne
    @JsonBackReference
    private Company company;

    public Job() {}
    public Job(Long id, String title, String description, String location, String minSalary, String maxSalary, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public String getMinSalary() {return minSalary;}

    public void setMinSalary(String minSalary) {this.minSalary = minSalary;}

    public String getMaxSalary() {return maxSalary;}

    public void setMaxSalary(String maxSalary) {this.maxSalary = maxSalary;}

    public Company getCompany() {return company;}
    public void setCompany(Company company) {this.company = company;}
}

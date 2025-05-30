package com.embarkx.firstjobapp.Company;

import com.embarkx.firstjobapp.Review.Review;
import com.embarkx.firstjobapp.job.Job;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Job> jobs;
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company() {}

    public void setId(Long id) {this.id = id;}

    public List<Review> getReviews() {return reviews;}
    public void setReviews(List<Review> reviews) {this.reviews = reviews;}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Job> getJobs() { return jobs; }

    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setJobs(List<Job> jobs) { this.jobs = jobs; }

}

package com.example.demo.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String projectNo;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String projectCode;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "project_teams",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "team_id"))
//    private Set<Team> teams = new HashSet<>();
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "project_customers",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_id"))
//    private Set<Customer> customers = new HashSet<>();
//
//    @NotNull
//    private LocalDate start_date;
//
//    @NotNull
//    private LocalDate end_date;
//
//    @NotNull
//    private LocalDate create_date;
//
//    @NotNull
//    private LocalDate update_date;

    public Project() {

    }

    public Project(Long id,
                   String name,
                   String projectNo,
                   String projectCode) {
        this.id = id;
        this.name = name;
        this.projectNo = projectNo;
        this.projectCode = projectCode;
    }

//    public Project(String name, String projectNo, String projectCode, LocalDate start_date, LocalDate end_date, LocalDate create_date, LocalDate update_date) {
//        this.name = name;
//        this.projectNo = projectNo;
//        this.projectCode = projectCode;
//        this.start_date = start_date;
//        this.end_date = end_date;
//        this.create_date = create_date;
//        this.update_date = update_date;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
//
//    public LocalDate getStart_date() {
//        return start_date;
//    }
//
//    public void setStart_date(LocalDate start_date) {
//        this.start_date = start_date;
//    }
//
//    public LocalDate getEnd_date() {
//        return end_date;
//    }
//
//    public void setEnd_date(LocalDate end_date) {
//        this.end_date = end_date;
//    }
//
//    public LocalDate getCreate_date() {
//        return create_date;
//    }
//
//    public void setCreate_date(LocalDate create_date) {
//        this.create_date = create_date;
//    }
//
//    public LocalDate getUpdate_date() {
//        return update_date;
//    }
//
//    public void setUpdate_date(LocalDate update_date) {
//        this.update_date = update_date;
//    }
}

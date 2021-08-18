package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "team_leaders",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Team> leader = new HashSet<>();

    private LocalDate createDate;

    private LocalDate updateDate;

    public Team() {

    }

    public Team(String description, LocalDate createDate, LocalDate updateDate) {
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Team> getLeader() {
        return leader;
    }

    public void setLeader(Set<Team> leader) {
        this.leader = leader;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(description, team.description) && Objects.equals(leader, team.leader) && Objects.equals(createDate, team.createDate) && Objects.equals(updateDate, team.updateDate);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", leader=" + leader +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

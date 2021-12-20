package com.example.programmeringseksambackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "parti")
public class Parti {

    @Id
    @Column(name = "parti_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partiID;

    @Column(name = "parti_name")
    private String partiName;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "parti_id")
    private Set<Kandidat> partietsKandidatSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parti parti = (Parti) o;
        return partiID.equals(parti.partiID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partiID);
    }
}
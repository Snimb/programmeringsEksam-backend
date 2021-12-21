package com.example.programmeringseksambackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "kandidat")
public class Kandidat {

    @Id
    @Column(name = "kandidat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kandidatID;

    @Column(name = "kandidat_name")
    private String kandidatName;

    @ManyToOne
    @JoinColumn(name = "parti_id")
    @JsonBackReference
    private Parti parti;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kandidat kandidat = (Kandidat) o;
        return kandidatID.equals(kandidat.kandidatID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kandidatID);
    }
}

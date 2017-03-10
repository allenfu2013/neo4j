package org.allen.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class Actor {

    @GraphId
    private Long id;

    private String name;

    private int born;

    @Relationship(type = "ACTED_IN")
    private List<Movie> movies = new ArrayList<>();

    public Actor() {
    }

    public Actor(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

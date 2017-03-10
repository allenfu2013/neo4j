package org.allen.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "BLACK_OF")
public class BlackOfRelation {

    @GraphId
    private Long id;

    @StartNode
    private Person person;

    @EndNode
    private BlackType blackType;

    public BlackOfRelation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BlackType getBlackType() {
        return blackType;
    }

    public void setBlackType(BlackType blackType) {
        this.blackType = blackType;
    }
}

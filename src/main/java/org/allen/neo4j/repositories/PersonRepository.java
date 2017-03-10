package org.allen.neo4j.repositories;

import org.allen.neo4j.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @Query("MATCH (p:Person)-[:BLACK_OF]-(b:BlackType) WHERE b.type={type} RETURN p")
    Collection<Person> findBlack(@Param("type") String type);

    @Query("MATCH (p:Person)-[:FRIENDS]-(p1:Person)-[r:BLACK_OF]->(b:BlackType) RETURN p")
    Collection<Person> findFirstBlack();
}

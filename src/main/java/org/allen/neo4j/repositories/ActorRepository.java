package org.allen.neo4j.repositories;

import org.allen.neo4j.domain.Actor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long> {

}

package org.allen.neo4j.repositories;

import org.allen.neo4j.domain.BlackType;
import org.allen.neo4j.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackTypeRepository extends PagingAndSortingRepository<BlackType, Long> {

}

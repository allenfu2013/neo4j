package org.allen.neo4j.repositories;

import java.util.Collection;

import org.allen.neo4j.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    Movie findByTitle(@Param("title") String title);

    @Query("MATCH (m:Movie) WHERE m.title =~ ('(?i).*'+{title}+'.*') RETURN m")
    Collection<Movie> findByTitleContaining(@Param("title") String title);

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Actor) RETURN m,r,a LIMIT {limit}")
    Collection<Movie> graph(@Param("limit") int limit);

    @Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Actor) WHERE a.name = {actor} RETURN m")
    Collection<Movie> getMovies(@Param("actor") String actor);
}

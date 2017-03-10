package org.allen.neo4j.repositories;

import org.allen.neo4j.domain.HomeCity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeCityRepository extends PagingAndSortingRepository<HomeCity, Long> {

    @Query("MATCH (c:HomeCity) WHERE c.cityCode = {cityCode} RETURN c")
    HomeCity getHomeCity(@Param("cityCode") String cityCode);
}

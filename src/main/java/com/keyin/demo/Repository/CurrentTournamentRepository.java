package com.keyin.demo.Repository;

import com.keyin.demo.accessdatarest.CurrentTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

    @RepositoryRestResource(collectionResourceRel = "CurrentTournament", path = "CurrentTournament")
    public interface CurrentTournamentRepository extends PagingAndSortingRepository<CurrentTournament, Long> {

        List<CurrentTournament> findByStartDate(@Param("startDate") String startDate);

    }


package com.keyin.demo.Repository;

import com.keyin.demo.accessdatarest.CurrentTournament;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

    @RepositoryRestResource(collectionResourceRel = "CurrentTournament", path = "CurrentTournament")
    public interface CurrentTournamentRepository extends PagingAndSortingRepository<CurrentTournament, Long> {

        List<CurrentTournament> findByStartDate(@Param("startDate") String startDate);
        //List<CurrentTournament> deleteByStartDate(@Param("startDate") String startDate);



    }


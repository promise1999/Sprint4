package com.keyin.demo.Repository;

import com.keyin.demo.accessdatarest.CurrentTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

    @RepositoryRestResource(collectionResourceRel = "CurrentTournament", path = "CurrentTournament")
    public interface PastTournamentRepository extends PagingAndSortingRepository<CurrentTournament, Long> {

        default List<CurrentTournament> findByStartDate() {
            return findByStartDate();
        }

        List<CurrentTournament> findByStartDate(@Param("startDate") String startDate);
        List<CurrentTournament> findByEndDate(@Param("endDate") String endDate);
        List<CurrentTournament> findByLocation(@Param("location") String location);
        List<CurrentTournament> findByEntryFee(@Param("entryFee") double entryFee);
        List<CurrentTournament> findByPrizeAmount(@Param("prizeAmount") int prizeAmount);
        List<CurrentTournament> findByParticipatingMember(@Param("participatingMember") String participatingMember);
        List<CurrentTournament> findByFinalStanding(@Param("finalStanding") String finalStanding);


    }


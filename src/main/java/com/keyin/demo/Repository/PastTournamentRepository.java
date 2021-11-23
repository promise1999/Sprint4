
package com.keyin.demo.Repository;

import com.keyin.demo.accessdatarest.CurrentTournament;
import com.keyin.demo.accessdatarest.PastTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "PastTournament", path = "PastTournament")
public interface PastTournamentRepository extends PagingAndSortingRepository<PastTournament, Long> {

    List<PastTournament> findByEndDate(@Param("endDate") String endDate);
    /*
    List<PastTournament> findByLocation(@Param("location") String location);
    List<PastTournament> findByEntryFee(@Param("entryFee") double entryFee);
    List<PastTournament> findByPrizeAmount(@Param("prizeAmount") int prizeAmount);
    List<PastTournament> findByParticipatingMember(@Param("participatingMember") String participatingMember);
    List<PastTournament> findByFinalStanding(@Param("finalStanding") String finalStanding);
*/

}


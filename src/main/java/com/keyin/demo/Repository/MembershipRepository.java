
package com.keyin.demo.Repository;

import com.keyin.demo.accessdatarest.Membership;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Membership", path = "Membership")
public interface MembershipRepository extends PagingAndSortingRepository<Membership, Long> {

    List<Membership> findById(@Param("Id") int Id);

    default Iterable<Object> findById() {
        return null;
    }
    /*
    List<Membership> findByStartDate(@Param("startDate") String startDate);
    List<Membership> findByEndDate(@Param("name") String endDate);
    List<Membership> findByLocation(@Param("location") String location);
    List<Membership> findByEntryFee(@Param("entryFee") double entryFee);
    List<Membership> findByPrizeAmount(@Param("prizeAmount") int prizeAmount);
    List<Membership> findByParticipatingMember(@Param("participatingMember") String participatingMember);
    List<Membership> findByFinalStanding(@Param("finalStanding") String finalStanding);
*/
}

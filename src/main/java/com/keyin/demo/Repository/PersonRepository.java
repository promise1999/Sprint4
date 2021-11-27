package com.keyin.demo.Repository;

import com.keyin.demo.accessdatarest.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

    @RepositoryRestResource(collectionResourceRel = "person", path = "person")
    public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

        List<Person> findByLastName(@Param("lastName") String lastName);


        /*
        List<Person> findById(@Param("Id") long Id);
        List<Person> findByFirstName(@Param("name") String name);
        List<Person> findByLastName(@Param("name") String name);
        List<Person> findByEmailAddress(@Param("emailAddress") String emailAddress);
        List<Person> findByPhoneNumber(@Param("phoneNumber") int phoneNumber);
        List<Person> findById(@Param("startDate")LocalDate startDate);
        List<Person> findByEndDate(@Param("startDate") LocalDate startDate);
*/

    }

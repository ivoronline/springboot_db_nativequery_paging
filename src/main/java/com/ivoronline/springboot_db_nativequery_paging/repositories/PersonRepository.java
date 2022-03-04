package com.ivoronline.springboot_db_nativequery_paging.repositories;

import com.ivoronline.springboot_db_nativequery_paging.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> {
  @Query(
    value       = "SELECT *        FROM PERSON WHERE AGE > :age",
    countQuery  = "SELECT count(*) FROM PERSON WHERE AGE > :age",
    nativeQuery = true
  )
  Page<Person> getPersons(Integer age, Pageable pageable);
}

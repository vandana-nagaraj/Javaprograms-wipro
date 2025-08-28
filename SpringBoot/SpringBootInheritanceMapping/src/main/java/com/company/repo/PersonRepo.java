package com.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.base.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person , Long>{

}
